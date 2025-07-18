package trees.binary.tree.node;

import trees.binary.tree.BinaryTree;
import trees.binary.tree.node.contract.Node;

public class TwoChildNode <T extends Comparable<T>> extends Node<T> {
    public TwoChildNode(T value) {
        super(value);
    }

    @Override
    public Node insert(T newValue) {
        int cmp = newValue.compareTo(this.getValue());
        if(cmp < 0 ) {
            this.setLeft(getLeft() == null ? new LeafNode(newValue) : getLeft().insert(newValue));
        }
        if(cmp > 0) {
            this.setRight(getRight() == null ? new LeafNode(newValue) : getRight().insert(newValue));
        }
        return this.rebuild();
    }


    @Override
    public Node delete(BinaryTree tree) {
        T smallest = (T) tree.findMin(getRight());
        this.setValue(smallest);
        this.setRight(tree.delete(getRight(), smallest));
        return this;
    }

}
