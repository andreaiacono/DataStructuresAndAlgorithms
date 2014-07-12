package datastructures;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 11/07/14
 * Time: 21.47
 */

/**
 * a list backed queue
 */
public class ListQueue<E> {

    private MyLinkedList<E> list;

    public ListQueue() {
        list = new MyLinkedList();
    }

    public void push(E item) {
        list.add(item, 0);
    }

    public E pop() {

        E item = list.get(list.size()-1);
        list.delete(list.size()-1);
        return item;
    }

}
