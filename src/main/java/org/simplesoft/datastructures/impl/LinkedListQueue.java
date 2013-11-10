package org.simplesoft.datastructures.impl;


import org.simplesoft.datastructures.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    Node head;
    Node tail;
    private int count;

    @Override
    public void enqueue(T item) {

        Node newNode = new Node();
        newNode.value = item;
        newNode.next = null;

        if(head==null && tail==null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;

    }

    @Override
    public T dequeue() {

        if(head == null) {
            throw new RuntimeException("Empty Queue");
        }


        // This check ensures that when we dequeue the
        // last element, tail pointer does not contain
        // a wrong reference.
        if(head == tail) {
            tail = null;
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
        return head==null;
    }

    class Node {
        T value;
        Node next;
    }
}
