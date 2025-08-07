package trees.multi.tree.impl;

import trees.multi.tree.impl.Node;
import trees.multi.tree.BalanceStrategy;
import trees.multi.tree.ChildSelection;
import trees.multi.tree.MultiTree;

import java.util.*;
import java.util.function.Consumer;

public class MultiTreeImpl<T extends Comparable<T>> implements MultiTree<T> {

    private Node root;
    private final Integer maxChildren;
    private final BalanceStrategy<T> balanceStrategy;
    private final ChildSelection<T> childSelection;


    public MultiTreeImpl(
            Integer maxChildren,
            BalanceStrategy<T> balanceStrategy,
            ChildSelection<T> childSelection
    ) throws IllegalAccessException {
        this.balanceStrategy = balanceStrategy;
        this.childSelection = childSelection;
        if(maxChildren < 2) {
            throw new IllegalAccessException("maxChildren должно быть >= 2");
        }
        this.maxChildren = maxChildren;
    }

    @Override
    public void insert(T value) {
        Objects.requireNonNull(value);
        root = Optional.ofNullable(root)
                .map(r -> r.insert(value,maxChildren,childSelection))
                .orElse(new Node<>(value));
    }

    @Override
    public boolean contains(T value) {
        return Optional.ofNullable(root).map(r -> r.contains(value)).orElse(false);
    }

    @Override
    public void delete(T value) {
        root = Optional.ofNullable(root).map(r -> r.delete(value)).orElse(null);
        root =  Optional.ofNullable(root).map(balanceStrategy::rebalance).orElse(null);
    }

    @Override
    public void traverseInOrder(Consumer<T> action) {
        Optional.ofNullable(root).ifPresent(r -> r.traverseChildrenPreOrder(action));
    }
}
