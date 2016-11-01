package searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeTraversalTest {

    @Test
    public void traverse() {
        Node root = new Node(0);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        root.addChild(node2);
        node2.addChildren(node3, node4, node6);
        node3.addChild(node7);
        node4.addChildren(node8, node9);
        node7.addChildren(node10, node11);
        assertEquals("[0[2[3[7[10][11]]][4[8][9]][6]]]", TreeTraversal.stringify(root));
    }

}