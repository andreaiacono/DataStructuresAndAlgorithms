package quiz;

import datastructures.node.BinaryTreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 27/02/16
 * Time: 17.45
 */
public class Amazon {

    public static void main(String[] args) {

        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode leftBranch = new BinaryTreeNode(5);
        root.setLeft(leftBranch);
        BinaryTreeNode rightBranch = new BinaryTreeNode(5);
        root.setRight(rightBranch);

        leftBranch.setLeft(new BinaryTreeNode(3));
        rightBranch.setLeft(new BinaryTreeNode(3));
        System.err.println("Symmetric: " + isTreeSymmetric(root));
    }

    public static boolean isTreeSymmetric(BinaryTreeNode actualNode) {

        String leftBranch = traverse(actualNode.getLeft());
        String rightBranch = traverse(actualNode.getRight());
        System.err.println("right=" + rightBranch);
        System.err.println("leftt=" + leftBranch);

        return leftBranch.equals(rightBranch);
    }

    public static String traverse(BinaryTreeNode node) {

        if (node == null) return "";

        return "L"+traverse(node.getLeft()) + "-" +node.getKey() + "-R" + traverse(node.getRight());
    }



}
