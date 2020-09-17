package recursion;

import org.junit.Test;
import tree.Node;
import tree.Printer;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BinarySearchTree {

    @Test
    public void test() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(18);
        root.right.right.left = new Node(16);
        root.left.left.right = new Node(4);

        Printer.printNode(root);
        assertTrue(isBinarySearchTree(root, root.data));
        root.right.data = 1;
        Printer.printNode(root);
        assertFalse(isBinarySearchTree(root, root.data));

        root.right.data = 15;
        root.data = 20;
        Printer.printNode(root);
        assertFalse(isBinarySearchTree(root, root.data));
    }

    Integer last = null;
    boolean isBinarySearchTree(Node node, Integer last) {
        if (node == null) {
            return true;
        }
        System.out.println(node.data);

        boolean result = isBinarySearchTree(node.left, last);

        if (last != null && node.data < last) {
            return false;
        }
        last = node.data;

        return result && isBinarySearchTree(node.right, last);
    }
}
