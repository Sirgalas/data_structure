package tuple.tuple.impl;

import tuple.tuple.Pair;

public class PairImpl<T,V> implements Pair<T,V> {

    private final T first;
    private final V second;

    public PairImpl(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public V getSecond() {
        return null;
    }
}
