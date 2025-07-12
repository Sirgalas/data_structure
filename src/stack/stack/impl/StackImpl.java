package stack.stack.impl;

import linkedList.linkedList.exception.StackIsEmptyException;
import linkedList.linkedList.exception.StackIsFullException;
import stack.stack.Stack;

public class StackImpl<T> implements Stack<T> {

    private T[] stack;
    private final int capacity;
    private int top;

    public StackImpl(int capacity) {
        this.stack = (T[]) new Object[this.capacity = capacity];
        top = -1;
    }

    @Override
    public void push(T value) {
        if(isFull()) {
            throw new StackIsFullException();
        }
        stack[++top] = value;
    }

    @Override
    public T pick() {
        if(isEmpty()) {
            throw new StackIsEmptyException();
        }
        return stack[top];
    }

    @Override
    public T pop() {
        if(isEmpty()) {
            throw new StackIsEmptyException();
        }
        return stack[top--];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top +1;
    }

    private boolean isFull() {
        return top >= capacity - 1;
    }
}
