package tree;

import org.junit.Test;
import recursion.PrintAllPaths;

import static org.junit.Assert.assertEquals;

public class LeastCommonAncestor {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     */


    @Test
    public void test() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node1.left = node2;
        node1.right = node6;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node6.left = node7;
        node6.right = node8;
        node7.right = node10;
        node8.right = node9;

        Printer.printNode(node1);

        assertEquals(node2, lca(node1, node4, node5));

    }

    Node lca(Node current, Node p, Node q) {

        if (current == null) {
            return null;
        }
        if (current.data == p.data || current.data == q.data) {
            return current;
        }

        Node left = lca(current.left, p, q);
        Node right = lca(current.right, p, q);


        // If we get left and right not null, this node is lca for a and b
        if (left != null && right != null) {
            return current;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

}
