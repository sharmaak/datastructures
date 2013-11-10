package org.simplesoft.datastructures.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;


public class ArrayStackUnitTest {

    ArrayStack<Integer> stack;


    public ArrayStackUnitTest() {
    }

    @BeforeMethod
    public void beforeMethod() {
        stack = new ArrayStack<Integer>();
    }

    @Test
    public void testPush() {
        stack.push(10);
        stack.push(20);

        assertEquals(stack.size(), 2);
        assertFalse(stack.isEmpty());
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

    @Test
    public void testArrayResize() {
        stack = new ArrayStack<Integer>(10);
        for(int i=0; i<100; i++) {
            stack.push(i);
        }

        for(Integer i=99; i>=0; i--) {
            assertEquals(stack.pop(), i);
        }


    }

}
