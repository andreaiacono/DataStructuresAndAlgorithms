package tree;

import org.junit.Test;

import java.util.List;

public class LeftView {

    /**
     * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from left side.
     */

    @Test
    public void test() {
        Node root = new Node(4);
        root.left = new Node(5);
        root.right = new Node(2);
        root.right.left = new Node(3);
        root.right.left.left = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right = new Node(1);

        printLeftView(root, true);
    }

    private void printLeftView(Node current, boolean toPrint) {

        if (current != null) {

            if (toPrint) {
                System.out.println(current);
            }

            printLeftView(current.left, true);
            printLeftView(current.right, false);
        }
    }

}
