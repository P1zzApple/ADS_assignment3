package assignment3;
// search
// insert
// delete
// inorder traversal
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
        root = insert(key, value);
    }

    private Node insert(K key, V value) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insert(key, (V) root.left);
        }

        else if (key.compareTo(root.key) > 0) {
            root.right = insert(key, (V) root.right);
        }

        return root;
    }


    public V get(K key) {
        return get(root, key);
    }

    public Node delete(K key) {
        return null;
    }

    public Iterable<K> iterator() {
        return null;
    }
}
