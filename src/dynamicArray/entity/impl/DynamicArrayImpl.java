package dynamicArray.entity.impl;

import dynamicArray.entity.DynamicArray;

import java.util.Arrays;

public class DynamicArrayImpl<T> implements DynamicArray<T> {

    private Object[] array;
    private int index;

    public DynamicArrayImpl() {
        array = new Object[10];
        index = -1;
    }

    public DynamicArrayImpl(int capacity) {
        array = new Object[capacity];
        index = -1;
    }


    @Override
    public T get(int index) {
        if(index > this.index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    @Override
    public T remove(int index) {
        T deleted = (T) array[index];
        for(int i = index; i < this.index; i ++) {
            array[i] = array[i +1];
        }
        this.index --;
        return deleted;
    }

    @Override
    public void add(T t) {
        if(array.length == index + 1) {
            addSize();
        }
        array[++index] = t;
    }

    @Override
    public boolean isEmpty() {
        return index == -1;
    }

    @Override
    public void insert(T t, int index) {
        if(this.index + 1 >= array.length ) {
            addSize();
        }
        for(int i = this.index + 1; i > index; i --) {
            array[i] = array[i - 1];
        }
        array[index] = t;
    }

    @Override
    public int size() {
        return index +1;
    }

    private void addSize() {
        int size = array.length;
        Object[] newArray = new Object[size + size / 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public String toString() {
        return "DynamicArrayImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
