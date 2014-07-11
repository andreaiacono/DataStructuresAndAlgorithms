package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 11/07/14
 * Time: 21.47
 */

/**
 * an array backed queue
 */
public class ArrayQueue<E> {

    private Object[] data;
    int max;

    public ArrayQueue() {
        this(100);
    }
    public ArrayQueue(int capacity) {
        data = new Object[capacity];
        max = 0;
    }

    public void push(E item) {
        data[max++] = item;
    }

    public E pop() {
        if (max == 0) return null;

        E item = (E) data[0];
        for (int j=0; j<max-1; j++) {
            data[j]=data[j+1];
        }
        max--;
        return item;
    }

}
