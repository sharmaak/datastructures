package org.simplesoft.datastructures.sort;

import static org.simplesoft.datastructures.sort.SortUtils.*;

public class Quick
{
    public static void sort(Comparable[] a)
    {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi)
    {
        // Partition into a[lo ... i-1], a[i], a[i+1...hi]
        int i = lo, j = hi + 1; // left and right scan indices
        Comparable v = a[lo];   // partitioning item
        while (true)
        {  // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j;       // with a[lo...j-1] <= a[j] <= a[j+1...hi]
    }

}