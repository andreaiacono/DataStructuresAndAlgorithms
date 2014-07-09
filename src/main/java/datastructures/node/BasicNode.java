package datastructures.node;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/07/14
 * Time: 14.19
 */
public class BasicNode {

    protected Integer key;
    protected String value;

    public BasicNode(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + " ";
    }
}