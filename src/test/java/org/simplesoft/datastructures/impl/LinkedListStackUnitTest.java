package org.simplesoft.datastructures.impl;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LinkedListStackUnitTest {

    LinkedListStack<Integer> stack;


    public LinkedListStackUnitTest() {
    }

    @BeforeMethod
    public void beforeMethod() {
        stack = new LinkedListStack<Integer>();
    }

    @Test
    public void testPush() {
        stack.push(10);
        stack.push(20);

        assertEquals(stack.head.value, new Integer(20));
    }

    @Test
    public void testPop() {
        stack.push(10);
        stack.push(20);

        assertEquals(stack.pop(), new Integer(20));
        assertEquals(stack.pop(), new Integer(10));
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void testEmptyStackPop() {
        stack.push(10);
        stack.push(20);

        stack.pop();
        stack.pop();
        stack.pop(); // this should throw RuntimeException

    }

    @Test
    public void testIsEmptyTrue() {
        assertEquals(stack.isEmpty(), true);
    }

    @Test
    public void testIsEmptyFalse() {
        stack.push(10);
        assertEquals(stack.isEmpty(), false);
    }

    @Test
    public void testSizeEmptyStack() {
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testSizeNonEmptyStack() {
        stack.push(10);
        stack.push(20);
        assertEquals(stack.size(), 2);

        stack.pop();
        assertEquals(stack.size(), 1);

        stack.pop();
        assertEquals(stack.size(), 0);
    }

}
