package org.simplesoft.datastructures.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Binary Search Tree implementation
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    private static final Logger logger = Logger.getLogger(BinarySearchTree.class.getName());
    public class Node {
        private K key;          // the key for the data
        private V value;        // the data
        private Node right;     // left child
        private Node left;      // right child
        private int nodeCount;  // number of nodes in subtree

        Node(K key, V value, int nodeCount) {
            this.key = key;
            this.value = value;
            this.nodeCount = nodeCount;
        }
    }

    private Node root;

    public BinarySearchTree() {
    }

    /**********************************************************
     * Top Level Basic Operations
     **********************************************************/
    public void put(K key, V value) {
        if(value == null) { delete(key); return; }
        Node newNode = new Node(key, value, 1);
        root = put(root, newNode);
    }

    public V get(K key) {
        if (root == null) return null;
        return get(root, key);
    }

    public int size() {
        return size(root);
    }

    public void delete(K key) {
        // TODO: implementation
    }

    /**********************************************************
     * Basic Operations: Recursive implementations
     **********************************************************/

    private Node put(Node current, Node newNode) {
        if(current == null) return newNode;
        int compare = newNode.key.compareTo(current.key);
        if      (compare < 0) current.left  = put(current.left, newNode);
        else if (compare > 0) current.right = put(current.right, newNode);
        else                  current.value = newNode.value;

        // update the number of nodes in the subtree
        current.nodeCount = 1 + size(current.left) + size(current.right);
        return current;
    }

    private V get(Node current, K key) {
        // matching value not found. return null.
        if (current == null)  return null;
        int compare = key.compareTo(current.key);

        if      (compare < 0)   return get(current.left, key);
        else if (compare > 0)   return get(current.right, key);
        else                    return current.value;
    }

    private int size(Node current) {
        if(current == null) return 0;
        else return current.nodeCount;
    }

    /**********************************************************
     * Tree Traversal
     * ===============
     * The two types of tree traversals are :
     * (a) Depth First Traversal
     *     1) in-order
     *     2) pre-order
     *     3) post-order
     * (b) Breadth First Traversal
     *     (also called level order traversal)
     **********************************************************/
    public List<K> inOrder(){
        List<K> keys = new LinkedList<K>();
        inOrder(root, keys);
        return keys;
    }

    public void inOrder(Node current, List<K> list){
        if (current == null) return;

        // left-current-right
        inOrder(current.left, list);
        list.add(current.key);
        inOrder(current.right, list);
    }
    public void preOrder(Node current, List<K> list){
        if (current == null) return;

        // current-left-right
        inOrder(current.left, list);
        list.add(current.key);
        inOrder(current.right, list);
    }
    public void postOrder(Node current, List<K> list){
        if (current == null) return;

        // current-left-right
        inOrder(current.left, list);
        list.add(current.key);
        inOrder(current.right, list);
    }



    // TODO: height of tree

/*
iterativeInorder(node)
  parentStack = empty stack
    while not parentStack.isEmpty() or node ≠ null
     if node ≠ null then
       parentStack.push(node)
       node = node.left
     else
       node = parentStack.pop()
       visit(node)
       node = node.right
*/
}
