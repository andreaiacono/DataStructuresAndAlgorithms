package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreePathSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(1000);
        root.left= new TreeNode(200);

        assertEquals(0, hasPathSum(root, 1000));
    }

    public int hasPathSum(TreeNode a, int b) {

        return hasSum(a, 0, b) ? 1 : 0;
    }

    boolean hasSum(TreeNode node, int acc, int sum) {

        if (node.left == null && node.right == null) {
            return acc + node.val == sum;
        }

        boolean leftSum = node.left == null ? false : hasSum(node.left, acc + node.val, sum);
        boolean rightSum = node.right== null ? false : hasSum(node.right, acc + node.val, sum);

        return leftSum || rightSum;
    }
}
