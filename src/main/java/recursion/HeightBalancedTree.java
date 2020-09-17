package recursion;

import org.junit.Test;
import tree.Node;

public class HeightBalancedTree {

    /**
     * Given a binary tree, determine whether or not it is height-balanced.
     * A height-balanced binary tree can be defined as one in which the heights
     * of the two subtrees of any node never differ by more than one.
     */
    @Test
    public void test() {

    }

    boolean isBalanced(Node node) {
        return heightDifference(node) > 1;
    }

    int heightDifference(Node node) {

        if (node == null) {
            return 0;
        }

        return Math.max(1 + heightDifference(node.left), 1 + heightDifference(node.left));
    }


}

