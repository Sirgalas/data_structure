package stack.stack;

public interface Stack<T> {
    void push(T value);

    T pick();
    T pop();
    boolean isEmpty();
    int size();
}
