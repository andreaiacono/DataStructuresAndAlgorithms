package datastructures;

import datastructures.node.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 29/06/14
 * Time: 15.32
 */
public class BinaryTree {

    protected enum TraversalType {
        INORDER, PREORDER, POSTORDER;
    }

    protected BinaryTreeNode root;

    public BinaryTreeNode getNode(BinaryTreeNode node, Integer key) {

        if (node != null) {

            if (node.getKey().equals(key)) {
                return node;
            }
            else {
                BinaryTreeNode childNode = getNode(node.getLeft(), key);
                if (childNode == null) {
                    childNode = getNode(node.getRight(), key);
                }

                return childNode;
            }
        }

        return null;
    }

    public void recursiveTraversal(TraversalType type, BinaryTreeNode browsingNode, StringBuilder builder) {

        if (browsingNode != null) {
            if (type == TraversalType.PREORDER) {
                builder.append(browsingNode.toString());
            }

            recursiveTraversal(type, browsingNode.getLeft(), builder);
            if (type == TraversalType.INORDER) {
                builder.append(browsingNode.toString());
            }

            recursiveTraversal(type, browsingNode.getRight(), builder);
            if (type == TraversalType.POSTORDER) {
                builder.append(browsingNode.toString());
            }

        }
    }

    public void preOrderRecursiveTraversal(BinaryTreeNode browsingNode, StringBuilder builder) {

        recursiveTraversal(TraversalType.PREORDER, browsingNode, builder);
    }

    public void inOrderRecursiveTraversal(BinaryTreeNode browsingNode, StringBuilder builder) {

        recursiveTraversal(TraversalType.INORDER, browsingNode, builder);
    }

    public void postOrderRecursiveTraversal(BinaryTreeNode browsingNode, StringBuilder builder) {

        recursiveTraversal(TraversalType.POSTORDER, browsingNode, builder);
    }

    public void inOrderTraversal(StringBuilder builder) {

        iterativeTraversal(TraversalType.INORDER, builder);
    }

    public void preOrderTraversal(StringBuilder builder) {

        iterativeTraversal(TraversalType.PREORDER, builder);
    }


    public void iterativeTraversal(TraversalType traversalType, StringBuilder builder) {

        Deque<BinaryTreeNode> stack = new ArrayDeque<>();

        BinaryTreeNode browsingNode = root;

        do {

            while (browsingNode != null) {
                stack.push(browsingNode);
                if (traversalType == TraversalType.PREORDER) {
                    builder.append(browsingNode.toString());
                }
                browsingNode = browsingNode.getLeft();
            }

            if (!stack.isEmpty()) {
                browsingNode = stack.pop();
                if (traversalType == TraversalType.INORDER) {
                    builder.append(browsingNode.toString());
                }
                browsingNode = browsingNode.getRight();
            }
        }
        while (!stack.isEmpty() || browsingNode != null);
    }

    public void levelOrderTraversal(StringBuilder builder) {

        Queue<BinaryTreeNode> queue = new ArrayBlockingQueue<>(100);
        BinaryTreeNode node = getRoot();

        while (node != null) {

            builder.append(node);

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

            if (!queue.isEmpty()) {
                node = queue.remove();
            }
            else {
                node = null;
            }
        }
    }


    public BinaryTreeNode insert(Integer key, String value, BinaryTreeNode parent) {

        BinaryTreeNode node = new BinaryTreeNode(key, value);

        if (parent == null) {
            root = node;
        }
        else if (parent.getLeft() == null && parent.getRight() == null) {

            // by default inserts a node on the left
            parent.setLeft(node);
        }
        else if (parent.getRight() == null) {
            parent.setRight(node);
            return node;
        }
        else if (parent.getLeft() == null) {
            parent.setLeft(node);
            return node;
        }
        else {
            node.setLeft(parent.getLeft());
            parent.setLeft(node);
        }

        return node;
    }

    public String getValue(Integer key) {

        BinaryTreeNode node = getNode(getRoot(), key);
        return node == null ? null : node.getValue();
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    @Override
    public String toString() {

        int width = (int) Math.pow(2, getHeight());

        StringBuilder builder = new StringBuilder();
        int maxHeight = getHeight();
        int level = 0;

        BinaryTreeNode browsingNode = root;
        while (browsingNode != null) {

//
//            if (key < browsingNode.getKey()) {
//                browsingNode = browsingNode.getLeft();
//                level ++;
//            }
//            else if (key > browsingNode.getKey()) {
//                browsingNode = browsingNode.getRight();
//            }
//            else {
//                return browsingNode;
//            }
        }

        return null;

    }

    public String printTree() {


        return printTree(root, new StringBuilder());
    }

    private String printTree(BinaryTreeNode node, StringBuilder builder) {

        if (node != null) {
            builder.append(node.toString() + "\n");
            printTree(node.getLeft(), builder);
            printTree(node.getRight(), builder);
        }

        return builder.toString();
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(BinaryTreeNode node) {

        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1;
    }



}
