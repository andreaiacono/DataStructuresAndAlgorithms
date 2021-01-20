package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTree {

    @Test
    public void test() {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(12);

        Printer.printNode(root);
        assertTrue(isBST(root));
        assertTrue(isBST2(root));

        root.right.left.right = new Node(11);
        Printer.printNode(root);
        assertFalse(isBST(root));
        assertFalse(isBST2(root));
    }

    boolean isBST(Node node) {

        if (node == null) {
            return false;
        }

        return (node.left == null || node.data > node.left.data)
                && isBST(node.left, Integer.MIN_VALUE, node.data)
                && (node.right == null || node.data <= node.right.data)
                && isBST(node.right, node.data, Integer.MAX_VALUE);
    }


    boolean isBST(Node node, int leftValue, int rightValue) {
        if (node == null) {
            return true;
        }
        return  node.data >= leftValue
                && node.data < rightValue
                && isBST(node.left, leftValue, node.data)
                && isBST(node.right, node.data, rightValue);
    }

    boolean isBST2(Node root) {
        List<Integer> inorderValues = readTree(root, new ArrayList<Integer>());
        for (int i=1;i<inorderValues.size(); i++) {
            if (inorderValues.get(i) <= inorderValues.get(i-1)) {
                return false;
            }
        }
        return true;
    }

    List<Integer> readTree(Node current, ArrayList<Integer> values) {
        if (current == null) {
            return values;
        }

        readTree(current.left, values);
        values.add(current.data);
        readTree(current.right, values);

        return values;
    }

}
