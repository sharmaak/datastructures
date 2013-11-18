package org.simplesoft.datastructures.sort;

public class SortUtils
{
    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    public static boolean lessThanEquals(Comparable v, Comparable w)
    {
        return v.compareTo(w) <= 0;
    }

    public static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
