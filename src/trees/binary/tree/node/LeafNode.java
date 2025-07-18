package trees.binary.tree.node;

import trees.binary.tree.BinaryTree;
import trees.binary.tree.impl.BinaryTreeImpl;
import trees.binary.tree.node.contract.Node;

public class LeafNode<T extends Comparable <T>> extends Node<T> {
    public LeafNode(T value) {
        super(value);
    }

    @Override
    public Node insert(T newValue) {
        int cmp = newValue.compareTo(this.getValue());
        if(cmp < 0) {
            this.setLeft(new LeafNode(newValue));
        }
        if(cmp > 0) {
            this.setLeft(new LeafNode(newValue));
        }
        return this.rebuild();
    }

    @Override
    public Node delete(BinaryTree tree) {
        return  null;
    }
}
