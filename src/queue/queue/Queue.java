package queue.queue;

public interface Queue<T> {

    public void enqueue(T t);

    public void dequeue();

    public T peek();
}
