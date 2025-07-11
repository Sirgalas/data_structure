package linkedList.linkedList.impl;

import linkedList.linkedList.LinkedList;

public class LinkedListSimply<T> implements LinkedList<T> {

    private Node head;

    public LinkedListSimply() {
        head = null;
    }

    public class Node<N> {
        public N data;
        public Node next;

        public Node(N data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return  head == null;
    }


    @Override
    public void add(T data) {
        Node newNode = new Node(data);
        Node curentNode = head;

        if(isEmpty()) {
            head =  newNode;
        } else {
            while (curentNode.next != null) {
                curentNode = curentNode.next;
            }
            curentNode.next = newNode;
        }
    }

    @Override
    public void remove(T data) {
        Node currentNode = head;
        Node previousNode = null;

        while (currentNode.next != null) {

            if(currentNode.data == data) {
                if(currentNode == head) {
                    head = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    @Override
    public void print() {
        Node currentNode = head;
        if(isEmpty()) {
            System.out.println(head.data);
        }
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            System.out.println(currentNode.data);
        }
    }
}
