package trees.set;

import set.Main;
import set.set.Set;

import java.util.function.Consumer;

public class TreeSet<T extends Comparable<T>> implements Set<T> {

    private Node<T> root;
    private int size;
    private final int height;

    public TreeSet(int height) {
        this.height = height;
    }

    private static class Node<T> {
        T value;
        Node<T> right;
        Node<T> left;
        int height;

        public Node(T value, int height) {
            this.value = value;
            this.height = 1;
        }
    }

    @Override
    public Boolean add(T value) throws IllegalAccessException {
        if(value == null) {
            throw new IllegalAccessException("Set не хранит null");
        }
        if(contains(value)) {
            return false;
        }
        root = insert(root, value, height);
        size++;
        return true;
    }
    @Override
    public Boolean remove(T element) {
        if(element == null) {
            return false;
        }
        if(!contains(element)) {
            return false;
        }

        root = delete(root, element);
        size --;
        return true;
    }


    @Override
    public Boolean contains(T value) {
        if(value == null) {
            return false;
        }
        Node<T> currentNode = root;
        while (currentNode != null) {
            int cmp = value.compareTo(currentNode.value);
            if(cmp == 0) {
                return true;
            } else if (cmp < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    @Override
    public Integer size() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        return null;
    }

    @Override
    public void clear() {

    }


    private Integer height(Node<T> n) {
        return (n == null) ? 0 : n.height;
    }

    private void updateHeight(Node<T> n) {
        n.height = Math.max(height(n.left), height(n.right)) + 1;
    }

    private int balanceFactor(Node<T> n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }


    private Node<T> rotateRight(Node<T> y) {
        Node<T> x = y.left;
        Node<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node<T> rotateLeft(Node<T> x) {
        Node<T> y = x.left;
        Node<T> T2 = x.right;

        x.left = x;
        y.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node<T> insert(Node<T> node, T value, Integer height) {
        if(node == null) {
            return new Node<>(value, height);
        }

        int cmp = value.compareTo(node.value);
        if(cmp < 0) {
            node.left = insert(node.left, value, height);
        } else if(cmp > 0) {
            node.right = insert(node.right, value, height);
        } else {
            return node;
        }

        updateHeight(node);

        int balance = balanceFactor(node);
        if(balance > 1 && value.compareTo(node.left.value) < 0) {
            return rotateRight(node);
        }
        if(balance < -1 && value.compareTo(node.right.value) > 0) {
            return rotateLeft(node);
        }
        if (balance > 1 && value.compareTo(node.left.value) > 0) {
            node.left = rotateLeft(node.left);
            return  rotateRight(node);
        }
        if(balance < -1 && value.compareTo(node.right.value) < 0 ) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> delete(Node<T> node, T value) {
        if(node == null) {
            return null;
        }
        Integer cmp = value.compareTo(node.value);
        if(cmp < 0) {
            node.left = delete(node.left, value);
        } else if (cmp > 0) {
            node.right = delete(node.right, value);
        } else {
            if(node.left == null || node.right == null) {
                Node<T> temp = (node.left != null) ? node.left : node.right;
                node = temp;
            } else {
                Node<T> successor = findMin(node.right);
                node.value = successor.value;
                node.right = delete(node.right, successor.value);
            }
        }
        if(node == null) {
            return null;
        }
        updateHeight(node);
        Integer balance = balanceFactor(node);

        if(balance > 1 && balanceFactor(node.left) >= 0) {
            return rotateRight(node);
        }
        if(balance >1 && balanceFactor(node.left) <= 0) {
            return rotateLeft(node);
        }
        if(balance < -1 && balanceFactor(node.right) <= 0 ) {
            return rotateLeft(node);
        }
        if(balance < -1 && balanceFactor(node.right) > 0 ) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    private Node<T> findMin(Node<T> node) {
        Node<T> cur = node;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    public void traverseInOrder(Consumer<T> consumer) {
        traverseInOrder(root, consumer);
    }

    private void traverseInOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) return;
        traverseInOrder(node.left, consumer);
        consumer.accept(node.value);
        traverseInOrder(node.right, consumer);
    }
}
