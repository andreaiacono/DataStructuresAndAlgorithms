package searching;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeCompare {


    @Test
    public void test() {

        Node root1 = new Node(0);
        Node node11 = new Node(1);
        Node node12 = new Node(2);
        Node node13 = new Node(3);
        Node node14 = new Node(4);
        Node node15 = new Node(5);
        Node node16 = new Node(6);
        root1.left = node11;
        root1.right = node12;
        node11.left = node13;
        node11.right = node14;
        node12.left = node15;
        node15.left = node16;

        Node root2 = new Node(0);
        Node node21 = new Node(1);
        Node node22 = new Node(2);
        Node node23 = new Node(3);
        Node node24 = new Node(4);
        Node node25 = new Node(5);
        Node node26 = new Node(6);
        root2.left = node21;
        root2.right = node22;
        node21.left = node23;
        node21.right = node24;
        node22.left = node25;
        node25.left = node26;

        assertTrue(treeCompare(root1, root2));

        node22.left = null;

        assertFalse(treeCompare(root1, root2));
    }

    boolean treeCompare(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        if (!treeCompare(node1.left, node2.left) || !treeCompare(node1.right, node2.right)) {
            return false;
        }
        return node1.key == node2.key;
    }


    class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

}
