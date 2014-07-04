package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 03/07/14
 * Time: 10.49
 */
public class MyArrayList<E> {

    private Object[] data;
    private int capacity;
    private int pointer;

    public MyArrayList() {
        this(1000);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        pointer = 0;
        data = new Object[capacity];
    }

    public E get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= pointer || index <0 ) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    public void add(E item) throws ArrayIndexOutOfBoundsException {

        if (pointer >= capacity) {
            throw new ArrayIndexOutOfBoundsException("Max capacity excedeed.");
        }
        data[pointer] = item;
        pointer ++;
    }

    public E remove(int index) throws ArrayIndexOutOfBoundsException {

        E item = get(index);

        for (int j=index; j<pointer-1; j++) {
            data[j] = data[j+1];
        }
        pointer --;

        return item;
    }

    public int size() {
        return pointer;
    }
}
