package org.simplesoft.datastructures;

public interface Queue<T> {

    public void enqueue(T item);

    public T dequeue();

    public int size();

    public boolean isEmpty();
}
