package org.simplesoft.datastructures;

/**
 *
 * @param <Key> Assume keys are Comparable
 * @param <Value>
 */
public interface SymbolTable<Key, Value>
{
    /**
     * Put key value par into tthe table. Remove key from table f value == null
     */
    public void put(Key key, Value val);

    /**
     * Fetch value paire with given key. Returns null if key is absent
     */
    public Value get(Key key);

    /**
     * Remove key and associated value from table
     */
    public void delete(Key key);

    /**
     * Is there a value paired with they key
     */
    public boolean contains(Key key);

    /**
     * is the tabel empty
     */
    public boolean isEmpty();

    /**
     * Number of entries in table
     */
    public int size();

    /**
     * Fetch all keys in the table
     */
    Iterable<Key> keys();


}
