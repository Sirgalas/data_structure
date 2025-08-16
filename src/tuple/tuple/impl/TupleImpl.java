package tuple.tuple.impl;

import tuple.tuple.Tuple;

import java.util.NoSuchElementException;

public class TupleImpl<T>  implements Tuple<T> {

    private final T[] ts;

    public TupleImpl(T... ts) {
        this.ts = ts;
    }

    @Override
    public T get(int index) {
        if(index > -1 && index < ts.length){
            return ts[index];
        }
        throw new NoSuchElementException("element not found");
    }
}
