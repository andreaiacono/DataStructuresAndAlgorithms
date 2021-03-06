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
        leftBranch.setRight(new BinaryTreeNode(1));
        rightBranch.setRight(new BinaryTreeNode(3));
        rightBranch.setLeft(new BinaryTreeNode(1));
        System.err.println("Symmetric: " + isSymmetricRecursive(root, root));
    }

    public static boolean isSymmetricRecursive(BinaryTreeNode node1, BinaryTreeNode node2) {
        System.out.println("node node1 " + node1 + " node2=" + node2);
        if (node1 == null && node2 == null) {
            System.out.println("boht nulls");
            return true;
        }

        if (node1 == null || node2 == null) {
            System.out.println("one null node1=" + node1 + " node2= "+ node2);
            return false;
        }

        return node1.getKey().equals(node2.getKey())
                && isSymmetricRecursive(node2.getLeft(), node1.getRight())
                && isSymmetricRecursive(node1.getLeft(), node2.getRight());
    }

//    public static boolean isTreeSymmetric(BinaryTreeNode actualNode) {
//
//        String leftBranch = traverse(actualNode.getLeft());
//        String rightBranch = traverse(actualNode.getRight());
//        System.err.println("right=" + rightBranch);
//        System.err.println("leftt=" + leftBranch);
//
//        return leftBranch.equals(rightBranch);
//    }
//
//    public static String traverse(BinaryTreeNode node) {
//
//        if (node == null) return "";
//
//        return "L"+traverse(node.getLeft()) + "-" +node.getKey() + "-R" + traverse(node.getRight());
//    }



}
