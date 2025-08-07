package trees.multi.tree;

import trees.multi.tree.impl.Node;

public interface BalanceStrategy <T extends Comparable<T>>{
    Node<T> rebalance(Node<T> root);
}
