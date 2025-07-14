package queue;

import queue.queue.Queue;
import queue.queue.impl.QueueImpl;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new QueueImpl<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("!");
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
    }
}
