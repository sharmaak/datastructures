package org.simplesoft.datastructures.impl;

import org.simplesoft.datastructures.Stack;

public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 20;
    T[] array;
    private int count=0;
    int tail=-1;

    public ArrayStack(int initialSize) {
        array = (T[]) new Object[initialSize];
    }

    public ArrayStack() {
        array = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void push(T item) {

        if(tail == (array.length-1) ) {
            resizeArray();
        }

        tail++;
        array[tail]=item;
        count++;
    }

    @Override
    public T pop() {
        if(tail == -1) { throw new RuntimeException("Empty stack"); }

        T item = array[tail];
        array[tail] = null; // for efficient GC
        tail--;
        count--;
        return item;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return tail==-1;
    }

    protected void resizeArray() {
        int newSize = array.length * 2;
        T[] newArray = (T[])new Object[newSize];

        for(int i=0; i<array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

}
