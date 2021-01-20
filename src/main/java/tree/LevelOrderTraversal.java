package tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class LevelOrderTraversal {

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
        System.out.println(getLevelOrderTraversal(root));
        assertEquals("10 5 15 3 7 12 18 4 16", getLevelOrderTraversal(root));
    }

    String getLevelOrderTraversal(Node root) {

        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.append(current.data).append(" ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return result.toString().trim();
    }
}
