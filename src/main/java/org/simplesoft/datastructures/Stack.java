package org.simplesoft.datastructures;

public interface Stack<T> {

    public void push(T item);

    public T pop();

    public int size();

    public boolean isEmpty();

}
