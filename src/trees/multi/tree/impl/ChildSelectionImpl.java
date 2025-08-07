package trees.multi.tree.impl;

import trees.multi.Main;
import trees.multi.tree.ChildSelection;

import java.util.List;

public class ChildSelectionImpl<T extends Comparable<T>> implements ChildSelection<T> {
    @Override
    public Node<T> select(List<Node<T>> children, T value) {
        if(children.isEmpty()) {
            return null;
        }
        return children.stream().min((a,b) -> {
            int distA = Math.abs(a.value.compareTo(value));
            int distB = Math.abs(b.value.compareTo(value));
            return Integer.compare(distA, distB);
        }).orElseThrow();
    }
}
