package datastructures;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 14/07/14
 * Time: 11.31
 */
public class Heap<E extends Comparable> {

    Object[] data;
    int size = 1;

    public Heap(E[] input) {

        data = new Object[input.length+1];
        for (int j = 0; j < input.length; j++) {
            insert(input[j]);
            heapify(j+1);
        }
        System.out.println(printHeap());
    }

    public void insert(E value) {
        data = Arrays.copyOfRange(data, 1, size);
        printHeap();
        data[0] = value;
    }

    public void heapify(int index) {

        System.out.println("Heapifying: " + printHeap() + " - index=" + index + " size=" + size);

        int largest;
        int left = left(index);
        int right = right(index);

        if (left < size-1 && ((Comparable) data[left]).compareTo((data[right])) > 0) {
            largest = left;
        }
        else {
            largest = index;
        }

        if (right < size-1 && ((Comparable) data[right]).compareTo((data[largest])) > 0) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    public void swap(int index1, int index2) {
        E tmp = (E) data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

    public int left(int index) {
        return 2 * index;
    }

    public int right(int index) {
        return 2 * index + 1;
    }

    public int parent(int index) {
        return index / 2;
    }

    public String printHeap() {

        return "Heap: " + Arrays.toString(data);
    }

}
