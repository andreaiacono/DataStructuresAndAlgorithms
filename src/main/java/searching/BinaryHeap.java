package searching;

/**
 * Min heap for relative numbers ( n >= 0)
 */
public class BinaryHeap {

    static final int NOT_ASSIGNED = -1;
    final int ROOT = 1;
    int[] heap;
    int last = NOT_ASSIGNED;

    public BinaryHeap(int size) {
        this.heap = new int[size];
        for (int j = ROOT; j < size; j++) {
            heap[j] = NOT_ASSIGNED;
        }
    }

    public static void main(String[] args) {

        BinaryHeap heap = new BinaryHeap(10);
        assert (heap.get() == NOT_ASSIGNED);

        heap.insert(5);
        assert (5 == heap.get());

        assert (heap.insert(5));
        assert (heap.insert(2));
        assert (2 == heap.get());
        assert (5 == heap.get());

        assert (heap.insert(5));
        assert (heap.insert(2));
        assert (heap.insert(7));
        assert (2 == heap.get());
        assert (5 == heap.get());
        assert (7 == heap.get());

        heap = new BinaryHeap(2);
        assert (heap.insert(1));
        assert (!heap.insert(2));
    }

    private int get() {

        if (last == NOT_ASSIGNED) {
            return NOT_ASSIGNED;
        }

        // gets the min element
        int value = heap[ROOT];

        heap[ROOT] = heap[last];
        heap[last] = NOT_ASSIGNED;
        last --;

        int current = ROOT;
        while (true) {

            if (!exists(getLeftChild(current))) {
                break;
            }
            if (!exists(getRightChild(current)) && heap[current] > heap[getLeftChild(current)]) {
                swap(current, getLeftChild(current));
                break;
            }

            if (heap[getLeftChild(current)] > heap[getRightChild(current)]) {
                swap(current, getRightChild(current));
                current = getRightChild(current);
            }
            else {
                swap(current, getLeftChild(current));
                current = getLeftChild(current);
            }
        }

        return value;
    }

    private boolean insert(int item) {

        if (last == heap.length-1) {
            return false;
        }

        if (last == NOT_ASSIGNED) {
            last = ROOT;
            heap[last] = item;
            return true;
        }

        // sets the new value as the last
        last++;
        heap[last] = item;

        // now bubbles up the item till its level
        int current = last;
        while (current > 1 && heap[current] < heap[current / 2]) {
            swap(current, current / 2);
            current /= 2;
        }

        return true;
    }

    private void swap(int index1, int index2) {
        int tmp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = tmp;
    }

    private boolean exists(int index) {
        return index <= last;
    }

    private int getLeftChild(int index) {
        return index << 1;
    }

    private int getRightChild(int index) {
        return index << 1 + 1;
    }
}
