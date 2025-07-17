package trees.binary.tree.impl;

import trees.binary.tree.BinaryTree;

import java.util.Objects;

public class BinaryTreeImpl<T extends Comparable<T>>  implements BinaryTree<T> {

    private Node root;

    @Override
    public int compareTo(T o) {
        return 0;
    }

    private abstract class Node {
        T value;
        Node left;
        Node right;

        Node(T value) {
            this.value = value;
        }

        abstract Node insert(T newValue);

        abstract Node delete(BinaryTreeImpl<T> tree);

        void traverseInOrder() {
            if(left != null) {
                left.traverseInOrder();
            }
            System.out.print(value + " ");
            if(right != null) {
                right.traverseInOrder();
            }
        }

        Node rebuild() {
            if(left == null && right == null && !(this instanceof LeafNode)) {
                return new LeafNode(value);
            }
            if((left == null || right == null) && !(this instanceof SingleChildNode)) {
                SingleChildNode n = new SingleChildNode(value);
                n.left = this.left;
                n.right = this.right;
                return n;
            }
            if(left != null && right != null && !(this instanceof TwoChildNode)) {
                TwoChildNode n = new TwoChildNode(value);
                n.left = this.left;
                n.right = this.right;
                return n;
            }
            return this;
        }

    }

    private class LeafNode extends Node {
        LeafNode(T value) {
            super(value);
        }

        @Override
        Node insert(T newValue) {
            int cmp = newValue.compareTo(this.value);
            if(cmp < 0) {
                this.left = new LeafNode(newValue);
            }
            if(cmp > 0) {
                this.right = new LeafNode(newValue);
            }
            return this.rebuild();
        }

        @Override
        Node delete(BinaryTreeImpl tree) {
            return  null;
        }
    }

    private class SingleChildNode extends Node {

        SingleChildNode(T value) {
            super(value);
        }

        @Override
        Node insert(T newValue) {
            int cmp = newValue.compareTo(this.value);
            if(cmp < 0) {
                this.left = (left == null ? new LeafNode(newValue) : left.insert(newValue));
            }
            if(cmp > 0 ) {
                this.right = (right == null ? new LeafNode(newValue) : right.insert(newValue));
            }
            return this.rebuild();
        }

        @Override
        Node delete(BinaryTreeImpl tree) {
            return (left != null) ? left : right;
        }
    }

    private class TwoChildNode extends Node {
        TwoChildNode(T value) {
            super(value);
        }

        @Override
        Node insert(T newValue) {
            int cmp = newValue.compareTo(this.value);
            if(cmp < 0 ) {
                this.left = (left == null ? new LeafNode(newValue) : left.insert(newValue));
            }
            if(cmp > 0) {
                this.right = (right == null ? new LeafNode(newValue) : right.insert(newValue));
            }
            return this.rebuild();
        }

        @Override
        Node delete(BinaryTreeImpl tree) {
            T smallest = (T) tree.findMin(this.right);
            this.value = smallest;
            this.right = tree.deleteNode(this.right, smallest);
            return this;
        }
    }

    private T findMin(Node node) {
        while(node.left != null) {
            node = node.left;
        }
        return node.value;
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
        Integer cmp = value.compareTo(currentNode.value);
        switch (Integer.signum(cmp)) {
            case -1 ->  currentNode.left = deleteNode(currentNode.left, value);
            case 1 -> currentNode.right = deleteNode(currentNode.right, value);
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
            Integer cmp = value.compareTo(current.value);
            if(cmp.equals(0)) {
                return true;
            }
            current =(cmp < 0) ? current.left : current.right;
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
