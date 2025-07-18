package trees.binary.tree.impl;

import trees.binary.tree.BinaryTree;
import trees.binary.tree.node.LeafNode;
import trees.binary.tree.node.contract.Node;

import java.util.Objects;

public class BinaryTreeImpl<T extends Comparable<T>>  implements BinaryTree<T> {

    private Node root;

    @Override
    public int compareTo(T o) {
        return 0;
    }


    public T findMin(Node node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return (T) node.getValue();
    }

    @Override
    public Node delete(Node node, T value) {
        return deleteNode(node,value);
    }

    @Override
    public void insert(T value) {
       Objects.requireNonNull(value);
       if(root == null) {
           this.root = new LeafNode(value);
       } else {
           this.root = root.insert(value);
       }
    }

    private Node deleteNode(Node currentNode, T value) {
        if(currentNode == null) {
            return null;
        }
        Integer cmp = value.compareTo((T) currentNode.getValue());
        switch (Integer.signum(cmp)) {
            case -1 ->  currentNode.setLeft(deleteNode(currentNode.getLeft(), value));
            case 1 -> currentNode.setRight(deleteNode(currentNode.getRight(), value));
            default -> {return currentNode.delete(this);}
        }
        return currentNode.rebuild();
    }

    @Override
    public void delete(T value) {
        root = deleteNode(root, value);
    }

    @Override
    public Boolean contains(T value) {
        Node current = root;
        while (current != null) {
            Integer cmp = value.compareTo((T) current.getValue());
            if(cmp.equals(0)) {
                return true;
            }
            current =(cmp < 0) ? current.getLeft() : current.getRight();
        }
        return false;
    }

    @Override
    public void traverseInOrder() {
        if(root != null) {
            root.traverseInOrder();
        }
        System.out.println(" ");
    }
}
