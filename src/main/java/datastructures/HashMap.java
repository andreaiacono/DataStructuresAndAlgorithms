package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HashMap<T> {

    final List<T>[] buckets;
    int index = 0;
    int size = 0;

    public HashMap(int capacity) {
        buckets = new ArrayList[capacity];
        for (int j = 0; j < capacity; j++) {
            buckets[j] = new ArrayList<>();
        }
        size = capacity;
    }

    public HashMap() {
        this(100);
    }

    private int hash(T item) {
        return item.hashCode();
    }

    public boolean insert(T item) {
        int bucket = hash(item) % size;

        if (buckets[bucket].contains(item)) {
            return false;
        }
        buckets[bucket].add(item);
        return true;
    }

    public boolean remove(T item) {
        int bucket = hash(item) % size;
        if (buckets[bucket].contains(item)) {
            buckets[bucket].remove(item);
            return true;
        }
        return false;
    }

    public T search(T item) {
        int bucket = hash(item) % size;
        if (buckets[bucket].contains(item)) {
            for (T itemInBucket : buckets[bucket]) {
                if (itemInBucket.equals(item)) {
                    return item;
                }
            }
        }
        return null;
    }

    public T getRandom() {
        Random random = new Random();
        int bucket = random.nextInt(size);
        int index = random.nextInt(buckets[bucket].size());
        return buckets[bucket].get(index);
    }

}
