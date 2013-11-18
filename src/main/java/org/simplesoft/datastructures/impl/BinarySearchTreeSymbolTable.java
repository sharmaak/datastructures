package org.simplesoft.datastructures.impl;

import org.simplesoft.datastructures.SymbolTable;

public class BinarySearchTreeSymbolTable<K extends Comparable<K>, V>
        extends BinarySearchTree<K, V> implements SymbolTable<K, V>
{
    @Override
    public K floor(K key) {
        Node result =  floor(key, root);
        if (result == null) return null;
        else return result.key;
    }

    private Node floor(K key, Node current) {
        if(current == null) return null;

        int compare = key.compareTo(current.key);

        // if key matches current node's key, return it
        if(compare == 0) return current;

        // since key is smaller than current node's key, search in left subtree
        if(compare < 0) return floor(key, current.left);

        // if execution reaches this point, it implies that key > current node's key
        // Also, since this is the first node whose key is smaller than given key,
        // the right subtree of current node will contain the floor value.
        Node t = floor(key, current.right);
        if (t != null) return t;
        else return current;
    }

    @Override
    public K ceiling(K key) {
        Node result =  ceiling(key, root);
        if (result == null) return null;
        else return result.key;
    }

    private Node ceiling(K key, Node current) {
        if(current == null) return null;

        int compare = key.compareTo(current.key);

        // if key matches current node's key, return it
        if(compare == 0) return current;

        // since key is greater than current node's key, search in right subtree
        if(compare > 0) return ceiling(key, current.right);

        // if execution reaches this point, it implies that key < current node's key
        // Also, since this is the first node whose key is greater than given key,
        // the left subtree of current node will contain the floor value.
        Node t = ceiling(key, current.left);
        if (t != null) return t;
        else return current;
    }
}
