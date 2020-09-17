package tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricTree {

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.left = new Node(6);
        root.right.right = new Node(4);
        root.right.right.left = new Node(8);
        root.left.left.right = new Node(8);

        Printer.printNode(root);

        assertTrue(isSymmetric(root.right.right.left));
        assertFalse(isSymmetric(root.right));
        assertFalse(isSymmetric(root.left));
        assertTrue(isSymmetric(root));
    }

    boolean isSymmetric(Node root) {
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(Node leftNode, Node rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode != null && rightNode != null && leftNode.data == rightNode.data) {
            return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(rightNode.left, leftNode.right);
        }
        return false;
    }

}
