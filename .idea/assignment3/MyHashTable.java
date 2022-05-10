package assignment3;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[11];
    }

    public MyHashTable(int M) {
        chainArray = new HashNode[M];
    }

    private char[] s;
    public int hashCode() { // might need a fix
        int hash = 0;
        for (int i = 0; i < size; i++) {
            hash = s[i] + (31 * hash);
        }
        return hash;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void put(K key, V value) {

    }
    public V get(K key) {
        V _value;
        _value = chainArray[hash(key)].value;
        return _value;
    }

    public V remove(K key) {
        return null;
    }

    public boolean contains(V value) {
        return true;
    }

    public K getKey(V value) {
        return null;
    }
}
