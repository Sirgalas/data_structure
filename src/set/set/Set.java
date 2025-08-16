package set.set;

public interface Set<T> {
    Boolean add(T value) throws IllegalAccessException;
    Boolean remove(T value);
    Boolean contains(T value);
    Integer size();
    Boolean isEmpty();
    void clear();
}
