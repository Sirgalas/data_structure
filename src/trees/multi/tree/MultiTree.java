package trees.multi.tree;

import java.util.function.Consumer;

public interface MultiTree <T extends Comparable<T>> {
    void insert(T value);
    boolean contains(T value);
    void delete(T value);
    void traverseInOrder(Consumer<T> action);
}
