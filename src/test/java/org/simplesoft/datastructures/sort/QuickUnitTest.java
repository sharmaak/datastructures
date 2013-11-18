package org.simplesoft.datastructures.sort;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickUnitTest
{
    Logger logger = Logger.getLogger(QuickUnitTest.class.getName());

    public Comparable[] createArray(int count) {
        Integer[] a = new Integer[count];
        Random rand = new Random();
        for(int i=0; i<count; i++){
            a[i] = rand.nextInt();
        }
        return a;
    }

    public void assertSorted(Comparable[] a){
        for(int i=0; i<a.length-1; i++) {
            //noinspection unchecked
            Assert.assertTrue(a[i].compareTo(a[i+1]) <= 0);
        }
    }

    @Test
    public void testSort100(){ testSortN(100); }

    @Test
    public void testSort10_000(){ testSortN(10_000); }

    @Test
    public void testSort50_000(){ testSortN(50_000); }

    @Test
    public void testSort100_000(){ testSortN(100_000); }

    @Test
    public void testSort1_000_000(){ testSortN(1_000_000); }

    public void testSortN(int count) {
        Comparable[] a = createArray(count);
        long startTime = System.currentTimeMillis();
        Quick.sort(a);
        long endTime = System.currentTimeMillis();
        assertSorted(a);
        logger.log(Level.INFO, "****** Sorted {0} elements in {1} ms", new Object[]{count, endTime-startTime});

    }
}
