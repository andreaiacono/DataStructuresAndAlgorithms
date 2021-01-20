package misc;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

import tree.Node;
import tree.Printer;

import java.util.List;

public class TreeBoundaries {

    @Test
    public void test() {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(2);
        root.left.right = new Node(7);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(8);
        root.right.left = new Node(12);
        root.right.left.left = new Node(11);
        root.right.left.right = new Node(6);
        root.right.right = new Node(18);
        root.right.right.left = new Node(18);
        root.right.right.right = new Node(13);
        String expected = "10, 5, 3, 4, 2, 1, 8, 11, 6, 18, 13, 18, 15";
        Printer.printNode(root);
        System.out.println(getBoundaries(root));
        assertEquals(expected, getBoundaries(root));
    }

    String getBoundaries(Node root) {
        String right = rightBorder(root);
        return leftBorder(root) + lastRow(root) + right.substring(0, right.lastIndexOf(","));
    }

    private String leftBorder(Node root) {

        if (root.left == null) {
            return "";
        }
        return root.data + ", " + leftBorder(root.left);
    }

    private String lastRow(Node root) {

        if (root != null && root.left == null && root.right == null) {
            return "" + root.data;
        }
        return lastRow(root.left) + ", " + lastRow(root.right);
    }

    private String rightBorder(Node root) {

        if (root.left == null) {
            return "";
        }
        return rightBorder(root.right) + ", " + root.data;
    }
}
