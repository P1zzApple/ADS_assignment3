package assignment3;

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
        return getting(root, key);
    }

    private V getting(Node root, K key) {
        if (root == null) {return null;}
        if (key.compareTo(root.key) < 0) {return getting(root.left, key);}
        else if (key.compareTo(root.key) > 0) {return getting(root.right, key);}
        return root.value;
    }

    private V getting(Node root, K key) {
        if (root == null) {return null;}
        if (key.compareTo(root.key) < 0) {return getting(root.left, key);}
        else if (key.compareTo(root.key) > 0) {return getting(root.right, key);}
        return root.value;
    }

    public Node delete(K key) {
        root = deleting(root, key);
    }

    private Node deleting(Node root, K key) {
        if (root == null) {return null;}
        if (key.compareTo(root.key) < 0) {root.left = deleting(root.left, key);}
        else if (key.compareTo(root.key) > 0) {root.right = deleting(root.right, key);}
        else {
            if (root.right == null) {return root.left;}
            if (root.left == null) {return root.right;}
            Node r = root;
            root = getMin(r.right);
            root.left = r.left;
        }

        return root;
    }

    public void deleteMin() {
        root = deletingMin(root);
    }

    private Node deletingMin(Node root) {
        if (root.left == null) {return root.right;}
        root.left = deletingMin(root.left);
        return root;
    }

    public K min() {
        return getMin(root).key;
    }

    private Node getMin(Node root) {
        if (root.left == null) {
            return root;
        }
        return root.left;
    }

    public K max() {
        return getMax(root).key;
    }

    private Node getMax(Node root) {
        if (root.right == null) {
            return root;
        }
        return root.right;
    }

    public Iterable<K> iterator() {
        return iterating(min(), max());
    }

    public Iterable<K> iterating(K l, K h) {
        Queue<K> q = new Queue<K>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<K> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(K k) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends K> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(K k) {
                return false;
            }

            @Override
            public K remove() {
                return null;
            }

            @Override
            public K poll() {
                return null;
            }

            @Override
            public K element() {
                return null;
            }

            @Override
            public K peek() {
                return null;
            }
        };
        iterating(root, q, l, h);
        return q;
    }

    private void iterating(Node root, Queue<K> q, K l, K h) {
        int l_comp = l.compareTo(root.key);
        int h_comp = h.compareTo(root.key);
        if (l_comp < 0) {
            iterating(root.left, q, l, h);
        }
        if (l_comp <= 0 && h_comp >= 0) {
            q.add(root.key);
        }
        if (h_comp > 0) {
            iterating(root.right, q, l, h);
        }
    }
}
