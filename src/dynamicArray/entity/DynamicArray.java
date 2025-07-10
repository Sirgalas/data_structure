package dynamicArray.entity;

public interface DynamicArray<T> {
    T get(int index);
    T remove(int index);
    void add(T t);
    boolean isEmpty();
    void insert(T t, int index);
    int size();
}
