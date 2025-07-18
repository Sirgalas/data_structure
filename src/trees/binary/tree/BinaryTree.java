package trees.binary.tree;

import trees.binary.tree.node.contract.Node;

public interface BinaryTree<T> extends Comparable<T> {
    public void insert(T value);
    public Boolean contains(T value);
    public void delete(T value);
    public void traverseInOrder();
    public T findMin(Node node);
    public Node delete(Node node, T value);

}
