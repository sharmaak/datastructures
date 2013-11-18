package org.simplesoft.datastructures;

import org.simplesoft.datastructures.impl.BinarySearchTree;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static junit.framework.Assert.*;

public class BinarySearchTreeUnitTest {

   /* Should be able to add data to BST without any errors */
    @Test
    public void testPut() {

        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
        bst.put("abraham", 100);
        bst.put("johnny", 251);
        bst.put("wilson", 300);
    }

    /* Should be able to retrieve values that were put in the BST */
    @Test
    public void testGet() {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
        bst.put("abraham", 100);
        bst.put("johnny", 251);
        bst.put("wilson", 300);

        assertEquals(100, (int)bst.get("abraham"));
        assertEquals(251, (int)bst.get("johnny"));
        assertEquals(300, (int)bst.get("wilson"));
    }

    /* Ensure duplicate values are not maintained */
    @Test
    public void testGetWithDuplicateKeys() {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
        bst.put("abraham", 100);
        assertEquals(100, (int)bst.get("abraham"));

        bst.put("abraham", 251);
        assertEquals(251, (int)bst.get("abraham"));
    }

    /* Ensure in-order traversal works */
    @Test
    public void testInOrder() {

        // create test keys with no duplicate
        List<Integer> keys = generateThousandInts();

        // put this data in bst
        BinarySearchTree<Integer, Object> bst = new BinarySearchTree<>();
        for(int key : keys ) {
            bst.put(key, "");
        }

        // perform in-order traversal
        List<Integer> sortedKeys = bst.inOrder();
        assertNotNull(sortedKeys);
        assertEquals(keys.size(), sortedKeys.size());
        for (int i=0; i<sortedKeys.size()-1; i++) {
            assertTrue(sortedKeys.get(i)<sortedKeys.get(i+1));
        }
    }

    /* Check if size is reported correctly */
    @Test
    public void testSize() {
        BinarySearchTree<Integer, Object> bst = new BinarySearchTree<>();

        // Get one thousand unique random integers
        List<Integer> keys = generateThousandInts();
        for(int key : keys ) {
            bst.put(key, "");
        }

        assertEquals(keys.size(), bst.size());
    }

    /**
     * Generates a List containing unsorted thousand random integers
     */
    private List<Integer> generateThousandInts() {
        // create test keys with no duplicate
        Set<Integer> oneK = new HashSet<>();
        Random rand = new Random();
        while (oneK.size() < 1_000) {
            oneK.add(rand.nextInt());
        }
        return new ArrayList<>(oneK);
    }
}
