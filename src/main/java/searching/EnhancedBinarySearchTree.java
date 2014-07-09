package searching;

import datastructures.node.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.20
 */
public class EnhancedBinarySearchTree extends BinarySearchTree {

    private BinaryTreeNode parent;

    @Override
    public void insert(Integer key, String value) {
        super.insert(key, value);
    }

    @Override
    public void inOrderTraversal(StringBuilder builder) {

        BinaryTreeNode node = root;
        Deque<BinaryTreeNode> stack = new ArrayDeque<>();

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
