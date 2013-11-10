package org.simplesoft.datastructures.impl;

import org.simplesoft.datastructures.Stack;

/**
 * Stack implementation backed by LinkedList.
 * This is a non-thread-safe implementation.
 * @param <T>
 */
public class LinkedListStack<T> implements Stack<T> {

    Node head;
    private int count;

    public LinkedListStack() {
    }

    @Override
    public void push(T item) {

        // This is inverted linked list. Head points
        // to the most recently added item.
        Node newNode = new Node();
        newNode.value = item;
        newNode.next  = head;
        head = newNode;
        count++;
    }

    @Override
    public T pop() {
        if (head == null ) {
            throw new RuntimeException("Empty stack");
        }

        Node returnNode = head;
        head = head.next;
        count--;

        return returnNode.value;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (head==null);
    }

    class Node {
        T value;
        Node next;
    }

}
