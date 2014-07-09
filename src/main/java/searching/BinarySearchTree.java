package searching;

import datastructures.BinaryTree;
import datastructures.node.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 26/06/14
 * Time: 13.54
 */
public class BinarySearchTree extends BinaryTree {


    public BinaryTreeNode getNode(Integer key) {

        BinaryTreeNode browsingNode = root;
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
            root = new BinaryTreeNode(key, value);
        }
        else {

            BinaryTreeNode node = root;
            while (node != null) {

                if (key < node.getKey()) {
                    if (node.getLeft() == null) {
                        BinaryTreeNode newNode = new BinaryTreeNode(key, value);
                        node.setLeft(newNode);
                        return;
                    }
                    else {
                        node = node.getLeft();
                    }
                }
                else if (key > node.getKey()) {
                    if (node.getRight() == null) {
                        BinaryTreeNode newNode = new BinaryTreeNode(key, value);
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



    public static boolean validateTree(BinaryTreeNode node, int min, int max) {

        if (node == null) {
            return true;
        }

        return (node.getKey() > min && node.getKey() <= max && validateTree(node.getLeft(), min, node.getKey()) && validateTree(node.getRight(), node.getKey(), max));
    }

}
