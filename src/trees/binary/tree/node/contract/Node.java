package trees.binary.tree.node.contract;

import trees.binary.tree.BinaryTree;
import trees.binary.tree.impl.BinaryTreeImpl;
import trees.binary.tree.node.LeafNode;
import trees.binary.tree.node.SingleChildNode;
import trees.binary.tree.node.TwoChildNode;

public abstract class Node < T extends Comparable<T>> {

    private T value;
    private Node left;
    private Node right;

    public Node(T value) {
        this.value = value;
    }

    public abstract Node insert(T newValue);

    public abstract Node delete(BinaryTree<T> tree);

    public void traverseInOrder() {
        if(left != null) {
            left.traverseInOrder();
        }
        System.out.print(value + " ");
        if(right != null) {
            right.traverseInOrder();
        }
    }

    public Node rebuild() {
        if(left == null && right == null && !(this instanceof LeafNode)) {
            return new LeafNode(value);
        }
        if((left == null || right == null) && !(this instanceof SingleChildNode)) {
            SingleChildNode n = new SingleChildNode(value);
            n.setLeft(this.left);
            n.setRight(this.right);
            return n;
        }
        if(left != null && right != null && !(this instanceof TwoChildNode)) {
            TwoChildNode n = new TwoChildNode(value);
            n.setLeft(this.left);
            n.setRight(this.right);
            return n;
        }
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
