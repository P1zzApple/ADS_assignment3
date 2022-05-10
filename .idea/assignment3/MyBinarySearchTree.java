package assignment3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MyBinarySearchTree<K extends Comparable<K>, V> {
    private Node root;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public  Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key) {
            this.key = key;
        }
    }

    public void put(K key, V value) {
        root = putting(key, value);
    }

    private Node putting(K key, V value) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = putting(key, (V) root.left);
        }

        else if (key.compareTo(root.key) > 0) {
            root.right = putting(key, (V) root.right);
        }

        return root;
    }


    public V get(K key) {
        return get(root, key);
    }

    private V getting(Node root, K key) {
        if (root == null) {return null;}
        if (key.compareTo(root.key) < 0) {return getting(root.left, key);}
        else if (key.compareTo(root.key) > 0) {return getting(root.right, key);}
        return root.value;
    }

    public Node delete(K key) {
        return null;
    }

    public Iterable<K> iterator() {
        return null;
    }
}
