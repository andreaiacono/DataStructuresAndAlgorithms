package datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 29/06/14
 * Time: 15.32
 */
public class BinaryTree {

    protected enum TraversalType {
        INORDER, PREORDER, POSTORDER, LEVELORDER;
    }

    protected Node root;

    public Node getNode(Node node, Integer key) {

        if (node != null) {
            System.out.println("getNode(" + node.getKey() + ")");

            if (node.getKey().equals(key)) {
                System.out.println("Found");
                return node;
            }
            else {
                Node foundNode = getNode(node.getLeft(), key);
                if (foundNode == null) {
                    foundNode = getNode(node.getRight(), key);
                }

                return foundNode;
            }
        }

        return null;
    }

    public void recursiveTraversal(TraversalType type, Node browsingNode, StringBuilder builder) {

        if (browsingNode != null) {
            if (type == TraversalType.PREORDER) {
                builder.append(browsingNode.toString());
            }

            preOrderRecursiveTraversal(browsingNode.getLeft(), builder);
            if (type == TraversalType.INORDER) {
                builder.append(browsingNode.toString());
            }

            preOrderRecursiveTraversal(browsingNode.getRight(), builder);
            if (type == TraversalType.POSTORDER) {
                builder.append(browsingNode.toString());
            }

        }
    }

    public void preOrderRecursiveTraversal(Node browsingNode, StringBuilder builder) {

        recursiveTraversal(TraversalType.PREORDER, browsingNode, builder);
    }

    public void inOrderRecursiveTraversal(Node browsingNode, StringBuilder builder) {

        recursiveTraversal(TraversalType.INORDER, browsingNode, builder);
    }

    public void postOrderRecursiveTraversal(Node browsingNode, StringBuilder builder) {

        recursiveTraversal(TraversalType.POSTORDER, browsingNode, builder);
    }

    public void inOrderTraversal(StringBuilder builder) {

        iterativeTraversal(TraversalType.INORDER, builder);
    }

    public void preOrderTraversal(StringBuilder builder) {

        iterativeTraversal(TraversalType.PREORDER, builder);
    }



    public void iterativeTraversal(TraversalType traversalType, StringBuilder builder) {

        Deque<Node> stack = new ArrayDeque<>();

        Node browsingNode = root;

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



    public Node insert(Integer key, String value, Node parent) {

        Node node = new Node(key, value);

        boolean insertOnLeft = Math.random() > 0.5;

        if (parent == null) {
            root = node;
        }
        else if (parent.getLeft() == null && parent.getRight() == null) {
            if (insertOnLeft) {
                parent.setLeft(node);
            }
            else {
                parent.setRight(node);
            }
        }
        else if (parent.getLeft() == null) {
            parent.setLeft(node);
            return node;
        }
        else if (parent.getRight() == null) {
            parent.setRight(node);
            return node;
        }
        else if (insertOnLeft) {
            node.setLeft(parent.getLeft());
            parent.setLeft(node);
        }
        else {
            node.setRight(parent.getRight());
            parent.setRight(node);
        }

        return node;
    }

    public String getValue(Integer key) {

        Node node = getNode(getRoot(), key);
        return node == null ? null : node.getValue();
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        int maxHeight = getHeigth();
        int level = 0;

        BinaryTree.Node browsingNode = root;
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

    public int getHeigth() {
        return -1;
    }



    public class Node {

        private Integer key;
        private String value;
        private Node left;
        private Node right;

        public Node(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value + " ";
        }
    }
}
