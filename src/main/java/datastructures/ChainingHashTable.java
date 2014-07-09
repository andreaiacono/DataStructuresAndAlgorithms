package datastructures;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/07/14
 * Time: 22.07
 */
public class ChainingHashTable<K, V> {

    private int capacity;
    private ChainingList[] table;

    public ChainingHashTable(int capacity) {
        this.capacity = capacity;
        table = (ChainingList[]) Array.newInstance(ChainingList.class, 100);
    }

    public V get(K key) {

        int hash = getHash(key);

        if (table[hash] != null) {
            return table[hash].get(key);
        }

        return null;
    }

    public void put(K key, V value) {

        int hash = getHash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (table[hash] == null) {
            table[hash] = new ChainingList();
            table[hash].add(newNode);
            return;
        }

        if (table[hash].get(key) != null) {

            table[hash].put(key, value);
        }

        table[hash].add(newNode);
    }

    public void remove(K key) {
        int hash = getHash(key);
        if (table[hash] != null) {
            table[hash].removeKey(key);
        }
    }

    private int getHash(K key) {
        return key.hashCode() % capacity;
    }


    class HashNode<K, V> {

        private K key;
        private V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    class ChainingList extends MyArrayList<HashNode<K, V>> {

        ChainingList() {
            super();
        }

        public void removeKey(K key) {

            int index = 0;
            for (int j = 0; j < pointer; j++) {
                HashNode<K, V> node = (HashNode<K, V>) data[j];
                if (node.getKey().equals(key)) {
                    index = j;
                }
            }

            for (int j = index; j < pointer - 1; j++) {
                data[j] = data[j + 1];
            }

        }

        public V get(K key) {

            for (int j = 0; j < pointer; j++) {
                HashNode<K, V> node = (HashNode<K, V>) data[j];
                if (node.getKey().equals(key)) {
                    return node.getValue();
                }
            }
            return null;
        }

        public void put(K key, V value) {

            for (int j = 0; j < pointer; j++) {
                HashNode<K, V> node = (HashNode<K, V>) data[j];
                if (node.getKey().equals(key)) {
                    data[j] = new HashNode<>(key, value);
                }
            }
        }
    }
}
