package org.simplesoft.datastructures;

/**
 *
 * @param <K> Assume keys are Comparable
 * @param <V>
 */
public interface SymbolTable<K extends Comparable<K>, V>
{
    /**
     * Put key value par into tthe table. Remove key from table f value == null
     */
    public void put(K key, V val);

    /**
     * Fetch value pair with given key. Returns null if key is absent
     */
    public V get(K key);

    /**
     * Remove key and associated value from table
     */
    public void delete(K key);

    /**
     * Is there a value paired with they key
     */
    public boolean contains(K key);

    /**
     * is the table empty
     */
    public boolean isEmpty();

    /**
     * Number of entries in table
     */
    public int size();

    /**
     * Fetch all keys in the table
     */
    public Iterable<K> keys();

    /**
     * Find the largest key less than or equal to the given key
     */
    public K floor(K key);

    /**
     * Find the smallest key greater than or equal to the given key
     */
    public K ceiling(K key);


}
