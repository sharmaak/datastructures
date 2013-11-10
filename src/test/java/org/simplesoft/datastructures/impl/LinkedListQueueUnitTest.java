package org.simplesoft.datastructures.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;


public class LinkedListQueueUnitTest {

    LinkedListQueue<Integer> queue;


    public LinkedListQueueUnitTest() {
    }

    @BeforeMethod
    public void beforeMethod() {
        queue = new LinkedListQueue<Integer>();
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(queue.head.value, new Integer(10));
    }

    @Test
    public void testDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(queue.dequeue(), new Integer(10));
        assertEquals(queue.dequeue(), new Integer(20));
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testEmptyQueuePop() {
        queue.enqueue(10);
        queue.enqueue(20);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // this should throw RuntimeException
    }

    @Test
    public void testIsEmptyTrue() {
        assertEquals(queue.isEmpty(), true);
    }

    @Test
    public void testIsEmptyFalse() {
        queue.enqueue(10);
        assertEquals(queue.isEmpty(), false);
    }

    @Test
    public void testSizeEmptyQueue() {
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testSizeNonEmptyQueue() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(queue.size(), 2);

        queue.dequeue();
        assertEquals(queue.size(), 1);

        queue.dequeue();
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testQueueHeadTailSanity() {
        queue.enqueue(10);
        queue.enqueue(20);

        assertNotEquals(queue.head, queue.tail);
        queue.dequeue();
        assertEquals(queue.head, queue.tail);
        queue.dequeue();
        assertNull(queue.head);
        assertNull(queue.tail);

    }

}
