package trees.binary.tree.node;

import trees.binary.tree.BinaryTree;
import trees.binary.tree.impl.BinaryTreeImpl;
import trees.binary.tree.node.contract.Node;

public class SingleChildNode<T extends Comparable<T>> extends Node<T> {


    public SingleChildNode(T value) {
        super(value);
    }

    @Override
    public Node insert(T newValue) {
        int cmp = newValue.compareTo(this.getValue());
        if(cmp < 0) {
            this.setLeft(getLeft() == null ? new LeafNode(newValue) :getLeft().insert(newValue));
        }
        if(cmp > 0 ) {
            this.setRight(getRight() == null ? new LeafNode(newValue) : getLeft().insert(newValue));
        }
        return this.rebuild();
    }

    @Override
    public Node delete(BinaryTree tree) {
        return (getLeft() != null) ? getLeft() : getRight();
    }


}
