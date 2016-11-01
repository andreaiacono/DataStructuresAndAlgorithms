package datastructures.node;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 12/07/14
 * Time: 9.46
 */
public class Node234<E> {

    enum Type {
        TWO, THREE, FOUR;
    }

    Type type;
    E value;
    Node234 left;
    Node234 middle;
    Node234 right;

    public Node234(E value) {
        this.type = Type.TWO;
        this.value = value;
    }

    public E getValue() {
        return value;
    }

//    public
}
