package linkedList.linkedList.impl;

import linkedList.linkedList.LinkedList;

public class LinkedListDouble<T> implements LinkedList<T> {

    private Node head;
    private Node tail;


    public LinkedListDouble() {
        head = null;
        tail = null;
    }

    public class Node<N> {
        public N value;
        public Node next;
        public Node prev;

        public Node(N value) {
            this.value = value;
        }

    }

    public void insertHead (T value) {
        Node node = new Node(value);
        if(isEmpty()) {
            tail = node;
        } else {
            head.prev = node;
        }
        node.next = head;
        head = node;
    }


    public void  removeFirst() {
        if(head.next == null) {
            tail.next = null;
        } else {
            head.next.prev = null;
        }
        head = head.next;
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    @Override
    public void add(T data) {
        Node node = new Node (data);
        if(isEmpty()) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
    }

    @Override
    public void remove(T data) {
        if(tail.prev ==  null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
    }

    @Override
    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }


    public void printDesc() {
        Node currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode);
            currentNode = currentNode.prev;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
