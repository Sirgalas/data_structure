package trees.binary;

import trees.binary.tree.BinaryTree;
import trees.binary.tree.impl.BinaryTreeImpl;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTreeImpl<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.traverseInOrder(); // 20 30 40 50 60 70 80

        tree.delete(20);
        tree.traverseInOrder(); // 30 40 50 60 70 80

        tree.delete(30);
        tree.traverseInOrder(); // 40 50 60 70 80

        tree.delete(50);
        tree.traverseInOrder(); // 40 60 70 80
    }
}
