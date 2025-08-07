package trees.multi.tree;

import trees.multi.tree.impl.Node;

import java.util.List;

public interface ChildSelection <T extends Comparable<T>>{
    Node<T> select(List<Node<T>> children, T value);
}
