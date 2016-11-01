package recursion;

import datastructures.BinaryTree;
import datastructures.node.BinaryTreeNode;

public class TreeAlgo {

    public static int nodeSum(BinaryTreeNode node) {
        if (node == null) return 0;
        int sum = node.getKey();
        return sum + nodeSum(node.getLeft()) + nodeSum(node.getRight());
    }

    public static int treeSum(BinaryTree tree) {
        return nodeSum(tree.getRoot());
    }

}
