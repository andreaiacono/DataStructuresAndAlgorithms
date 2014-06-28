package searching;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.20
 */
public class EnhancedBinarySearchTree extends BinarySearchTree {

    private Node parent;

    @Override
    public void inOrderTraversal(StringBuilder builder) {

        Node node = root;
        Deque<Node> stack = new ArrayDeque<>();

        do {

            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                builder.append(node.getValue() + " ");
                node = node.getRight();
            }

        }
        while (node != null || !stack.isEmpty());

    }
}
