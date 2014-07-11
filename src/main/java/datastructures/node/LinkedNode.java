package datastructures.node;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 11/07/14
 * Time: 22.02
 */
public class LinkedNode<E> {

    protected final E value;
    protected LinkedNode next;

    public LinkedNode(E value) {
        this.value = value;
    }

    public E getValue() {
        return this.value;
    }

    public void setNext(LinkedNode node) {
        this.next = node;
    }

    public LinkedNode getNext() {
        return next;
    }

    @Override
    public String toString() {
        return (String) value;
    }
}
