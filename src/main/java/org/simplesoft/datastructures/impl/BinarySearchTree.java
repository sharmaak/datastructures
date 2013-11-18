package org.simplesoft.datastructures.impl;

import org.simplesoft.datastructures.SymbolTable;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Binary Search Tree implementation
 * @param <K>
 * @param <V>
 */
    public class BinarySearchTree<K extends Comparable<K>, V> {

    private static final Logger logger = Logger.getLogger(BinarySearchTree.class.getName());
    protected class Node {
        protected K key;          // the key for the data
        protected V value;        // the data
        protected Node right;     // left child
        protected Node left;      // right child
        protected int nodeCount;  // number of nodes in subtree

        Node(K key, V value, int nodeCount) {
            this.key = key;
            this.value = value;
            this.nodeCount = nodeCount;
        }
    }

    protected Node root;

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

    public Iterable<K> keys() {
        return null;  //todo
    }

    public void delete(K key) {
        // TODO: implementation
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return root==null;
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
        list.add(current.key);
        preOrder(current.left, list);
        preOrder(current.right, list);
    }

    public void postOrder(Node current, List<K> list){
        if (current == null) return;

        // left-right-current
        postOrder(current.left, list);
        postOrder(current.right, list);
        list.add(current.key);
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
