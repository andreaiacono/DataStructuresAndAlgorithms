package datastructures;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 12/07/14
 * Time: 9.24
 */
public class ArrayStack<E> {

    private Object[] data;
    int max;

    public ArrayStack() {
        this(5);
    }

    public ArrayStack(int capacity) {
        data = new Object[capacity];
        max = 0;
    }

    public void push(E item) {
        data[max++] = item;
    }

    public E pop() {

        if (max == 0) return null;
        return (E) data[--max];
    }


}
