package misc;

import org.junit.Test;
import tree.Node;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class BinaryTreeRangeSum {

    /**
     * Given a binary search tree and a range [a, b] (inclusive), return
     * the sum of the elements of the binary search tree within the range.
     */

    @Test
    public void test() {
         /* Construct below tree
	          1
	       /     \
	      2       3
	     / \     / \
	    4   5   6   7
	               / \
	              10  8
	    */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(8);

        assertEquals(13, binaryRangeSum(root, 3, 6));
        assertEquals(13, iterativeBinaryRangeSum(root, 3, 6));
    }

//    int binaryRangeSum(Node current, int min, int max) {
//
//        if (current == null) {
//            return 0;
//        }
//
//        return (current.data <= max && current.data >= min ? current.data : 0) +
//            binaryRangeSum(current.left, min, max) +
//            binaryRangeSum(current.right, min, max);
//    }

    int binaryRangeSum(Node current, int min, int max) {

        int result = current.data <= max && current.data >= min ? current.data : 0;
        if (current.left != null) {
            result += binaryRangeSum(current.left, min, max);
        }
        if (current.right != null) {
            result += binaryRangeSum(current.right, min, max);
        }
        return result;
    }

    int iterativeBinaryRangeSum(Node root, int min, int max) {

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        int result = 0;

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result += current.data <= max && current.data >= min ? current.data : 0;
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return result;
    }

}
