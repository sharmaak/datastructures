package org.simplesoft.datastructures.impl;

import junit.framework.Assert;
import org.testng.annotations.Test;

public class BinarySearchTreeSymbolTableUnitTest extends BinarySearchTreeUnitTest{

    @Test
    public void testFloor() {
        int[] a = new int[]{200, 50, 3000, 65, 44, 99, 1};

        BinarySearchTreeSymbolTable<Integer, Object> bstSt = new BinarySearchTreeSymbolTable<>();
        for (int x : a ) {
            bstSt.put(x, "");
        }

        int key = 100;
        int floor = bstSt.floor(key); // largest x <= key
        Assert.assertEquals(99, floor);
    }

    @Test
    public void testCeiling() {
        int[] a = new int[]{200, 50, 3000, 65, 44, 99, 1};

        BinarySearchTreeSymbolTable<Integer, Object> bstSt = new BinarySearchTreeSymbolTable<>();
        for (int x : a ) {
            bstSt.put(x, "");
        }

        int key = 100;
        int floor = bstSt.ceiling(key); // smallest x >= key
        Assert.assertEquals(200, floor);
    }
}
