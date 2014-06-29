package searching;

import datastructures.BinaryTree;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 26/06/14
 * Time: 13.54
 */
public class BinarySearchTree extends BinaryTree {


    public Node getNode(Integer key) {

        Node browsingNode = root;
        while (browsingNode != null) {

            if (key.compareTo(browsingNode.getKey()) < 0) {
                browsingNode = browsingNode.getLeft();
            }
            else if (key.compareTo(browsingNode.getKey()) > 0) {
                browsingNode = browsingNode.getRight();
            }
            else {
                return browsingNode;
            }
        }

        return null;
    }


    public void insert(Integer key, String value) {

        if (root == null) {
            root = new BinaryTree.Node(key, value);
        }
        else {

            Node node = root;
            while (node != null) {

                if (key < node.getKey()) {
                    if (node.getLeft() == null) {
                        Node newNode = new Node(key, value);
                        node.setLeft(newNode);
                        return;
                    }
                    else {
                        node = node.getLeft();
                    }
                }
                else if (key > node.getKey()) {
                    if (node.getRight() == null) {
                        Node newNode = new Node(key, value);
                        node.setRight(newNode);
                        return;
                    }
                    else {
                        node = node.getRight();
                    }
                }
                else {
                    node.setValue(value);
                }
            }
        }
    }

    public void remove(Integer value) {

    }


}
