package misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTree {
    
    @Test
    public void test() {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(12);

        assertTrue(isBST(root));
        root.right.right.right = new Node(1);
        assertFalse(isBST(root));
    }
    
    boolean isBST(Node node) {
        
        if (node == null) {
            return true;
        }
        
        boolean isNodeBst = (node.left == null || node.val > node.left.val) &&
                (node.right == null || node.val <= node.right.val);
        
        return isNodeBst && isBST(node.left) && isBST(node.right);
    }
    
    class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }



}
