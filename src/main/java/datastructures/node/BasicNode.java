package datastructures.node;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/07/14
 * Time: 14.19
 */
public class BasicNode<E> {

    protected Integer key;
    protected E value;

    public BasicNode(Integer key, E value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }
}