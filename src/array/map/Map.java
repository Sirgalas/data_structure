package array.map;

public interface Map<K,V> {
    void put(K key, V value);
    V find(K key);
    void remove(K key);

}
