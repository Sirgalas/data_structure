package queue.queue.impl;

import queue.queue.Queue;

public class QueueImpl<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void enqueue(T t) {
        Node<T> node = new Node<>(t);
        if(head == null) {
            head = node;
        }
        if(tail != null) {
            tail.next = node;
        }
        tail = node;
    }

    @Override
    public void dequeue() {
        head = head.next;
        if(head == null) {
            tail = null;
        }
    }

    @Override
    public T peek() {
        return head.value;
    }

    private static class Node <T> {
        private final T value;
        private Node <T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
