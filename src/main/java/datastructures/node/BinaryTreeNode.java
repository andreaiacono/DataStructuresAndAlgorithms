package datastructures.node;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/07/14
 * Time: 14.20
 */
public class BinaryTreeNode<E> extends BasicNode {

    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(Integer key, String value) {
        super(key, value);
    }

    public BinaryTreeNode(Integer key) {
        super(key, "" + key);
    }


    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

}
