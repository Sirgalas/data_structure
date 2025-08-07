package trees.multi.tree.impl;

import trees.multi.tree.ChildSelection;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Node<T extends Comparable<T>> {

    T value;
    List<Node<T>> children = new ArrayList<>();

    Node(T value) {
        this.value = value;
    }

   Node insert(T newValue, Integer maxChildren, ChildSelection<T> selection) {
        int cmp = newValue.compareTo(this.value);
        if(cmp == 0) {
            return this;
        }

        if(children.size() < maxChildren) {
            children.add(new Node<>(newValue));
            sortChildren();
            return this;
        }

       selection.select(children, newValue).insert(newValue, maxChildren, selection);
       sortChildren();
       return this;
    }

   Boolean contains(T searchValue) {
        if(searchValue.compareTo(value) == 0) {
            return true;
        }
        return children.stream().anyMatch(c -> c.contains(searchValue));
    }

   Node<T> delete(T delValue) {
        if(delValue.compareTo(value) == 0) {
            if(children.isEmpty()) {
                return null;
            }
            if(children.size() == 1) {
                return children.get(0);
            }
            Node<T> min = Collections.min(children,Comparator.comparing(n -> n.value));
            this.value = min.value;
            children.remove(min);
            children.addAll(min.children);
            sortChildren();
            return this;
        }
        children = children.stream()
                .map(c -> c.delete(delValue))
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(ArrayList::new));
        sortChildren();
        return this;
    }

   void traverseChildrenPreOrder(Consumer<T> action) {
        action.accept(value);
        children.forEach(c -> c.traverseChildrenPreOrder(action));
    }


    private void sortChildren() {
        children.sort(Comparator.comparing(n -> n.value));
    }
}
