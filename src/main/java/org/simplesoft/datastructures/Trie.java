package org.simplesoft.datastructures;


public class Trie<Value> {

    private static int R = 256; // Radix
    private Node root;          // Root of trie

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if( x==null ) { return null; }
        return (Value)x.val;
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    /**
     * All the keys having s as prefix
     * @param s
     * @return
     */
    public Iterable<String> keysWithPrefix(String s) {
        //TODO
        return null;
    }

    /**
     * All keys that match s (where . matches any character)
     * @param s
     * @return
     */
    public Iterable<String> keysThatMatch(String s) {
        //TODO
        return null;
    }

    /**
     * Return value associated with key in the subtrie
     * rooted at x
     */
    private Node get( Node x, String key, int d ){
        if(x==null) { return null; }
        if(d==key.length()) { return x; }
        char c = key.charAt(d); // Use dth key char ro identify subtrie
        return get(x.next[c], key, d+1);
    }

    /**
     * Change value associated with key if in a subtrie
     * rooted at x.
     */
    private Node put(Node x, String key, Value val, int d){
        if(x==null) { x = new Node(); }
        if(d==key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char ro identify subtrie
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
}
