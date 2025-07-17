package trees.binary.tree;

public interface BinaryTree<T> extends Comparable<T> {
    public void insert(T value);
    public Boolean contains(T value);
    public void delete(T value);
    public void traverseInOrder();

}
