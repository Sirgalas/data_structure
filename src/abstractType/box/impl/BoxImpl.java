package abstractType.box.impl;

import abstractType.box.Box;
import abstractType.exception.BoxIntegerFullException;
import abstractType.exception.IsGetException;

public class BoxImpl implements Box {

     private int  sum;
     private boolean isGet;

    public BoxImpl(int sum) {
        this.sum = sum;
        isGet = false;
    }

    public BoxImpl() {
        sum = 0;
    }

    @Override
    public void add(int integer) {
        if(integer <= 0) {
            throw new IllegalArgumentException();
        }
        if(sum + integer < sum) {
            throw new BoxIntegerFullException();
        }
        sum += integer;
    }

    @Override
    public int get() {
        if(isGet) {
            throw new IsGetException();
        }
        isGet = true;

        return sum;
    }
}
