package trees.multi.tree.impl;

import trees.binary.tree.node.LeafNode;
import trees.multi.tree.BalanceStrategy;

import java.util.ArrayList;
import java.util.List;

public class BalanceStrategyImpl<T extends Comparable<T>> implements BalanceStrategy<T> {
    private final Integer maxChildren;

    public BalanceStrategyImpl(Integer maxChildren) {
        this.maxChildren = maxChildren;
    }


    @Override
    public Node<T> rebalance(Node<T> root) {
        if(root.children.size() <= maxChildren) {
            return root;
        }
        Integer mid = root.children.size() / 2;
        List<Node<T>> leftPart = new ArrayList<>(root.children.subList(0, mid));
        List<Node<T>> rightPart = new ArrayList<>(root.children.subList(mid, root.children.size()));

        Node<T> leftNode = new Node<>(leftPart.get(0).value);
        leftNode.children = leftPart;

        Node<T> rigthNode = new Node<>(rightPart.get(0).value);
        rigthNode.children = rightPart;

        Node<T> newRoot = new Node<>(root.value);
        newRoot.children = new ArrayList<>();
        newRoot.children.add(leftNode);
        newRoot.children.add(rigthNode);

        return newRoot;
    }
}
