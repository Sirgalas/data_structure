package trees.multi;

import trees.multi.tree.BalanceStrategy;
import trees.multi.tree.ChildSelection;
import trees.multi.tree.MultiTree;
import trees.multi.tree.impl.BalanceStrategyImpl;
import trees.multi.tree.impl.ChildSelectionImpl;
import trees.multi.tree.impl.MultiTreeImpl;

public class Main {


    public static void main(String[] args) throws IllegalAccessException {
        BalanceStrategy balanceStrategy = new BalanceStrategyImpl(3);
        ChildSelection childSelection = new ChildSelectionImpl();

        MultiTree<Integer> tree = new MultiTreeImpl<>(3, balanceStrategy,childSelection);

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(60);
        tree.insert(20);
        tree.insert(40);

        tree.traverseInOrder(v -> System.out.print(v + " "));
        System.out.println();

        System.out.println(tree.contains(40)); // true

        tree.delete(30);
        tree.traverseInOrder(v -> System.out.print(v + " "));
    }
}
