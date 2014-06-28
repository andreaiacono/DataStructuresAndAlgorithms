package searching;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 26/06/14
 * Time: 13.54
 */
public class BinarySearchTree {

    enum TraversalType {
        INORDER, PREORDER;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(8, "8");
        tree.insert(3, "3");
        tree.insert(1, "1");
        tree.insert(6, "6");
        tree.insert(4, "4");
        tree.insert(7, "7");
        tree.insert(10, "10");
        tree.insert(14, "14");
        tree.insert(13, "13");
        System.out.println("Created tree.");

        StringBuilder builder = new StringBuilder();
        tree.preOrderRecursiveTraversal(tree.root, builder);
        System.out.println("Tree rec preorder: " + builder.toString());

        builder = new StringBuilder();
        tree.preOrderTraversal(builder);
        System.out.println("Tree     preorder: " + builder.toString());

        builder = new StringBuilder();
        tree.inOrderRecursiveTraversal(tree.root, builder);
        System.out.println("Tree rec inorder: " + builder.toString());

        builder = new StringBuilder();
        tree.inOrderTraversal(builder);
        System.out.println("Tree     inorder: " + builder.toString());

        builder = new StringBuilder();
        tree.postOrderRecursiveTraversal(tree.root, builder);
        System.out.println("Tree rec postord: " + builder.toString());

    }

    protected Node root;

    public String getValue(Integer key) {

        Node node = getNode(key);
        return node == null ? null : node.getValue();
    }

    public Node getNode(Integer key) {

        Node browsingNode = root;
        while (browsingNode != null) {

            if (key < browsingNode.getKey()) {
                browsingNode = browsingNode.getLeft();
            }
            else if (key > browsingNode.getKey()) {
                browsingNode = browsingNode.getRight();
            }
            else {
                return browsingNode;
            }
        }

        return null;
    }


    public void insert(Integer key, String value) {

        if (root == null) {
            root = new Node(key, value);
        }
        else {

            Node browsingNode = root;
            while (browsingNode != null) {

                if (key < browsingNode.getKey()) {
                    if (browsingNode.getLeft() == null) {
                        Node newNode = new Node(key, value);
                        browsingNode.setLeft(newNode);
                        return;
                    }
                    else {
                        browsingNode = browsingNode.getLeft();
                    }
                }
                else if (key > browsingNode.getKey()) {
                    if (browsingNode.getRight() == null) {
                        Node newNode = new Node(key, value);
                        browsingNode.setRight(newNode);
                        return;
                    }
                    else {
                        browsingNode = browsingNode.getRight();
                    }
                }
                else {
                    browsingNode.setValue(value);
                }
            }
        }
    }

    public void preOrderRecursiveTraversal(Node browsingNode, StringBuilder builder) {

        if (browsingNode != null) {
            builder.append(browsingNode.toString());
            preOrderRecursiveTraversal(browsingNode.getLeft(), builder);
            preOrderRecursiveTraversal(browsingNode.getRight(), builder);
        }
    }

    public void inOrderRecursiveTraversal(Node browsingNode, StringBuilder builder) {

        if (browsingNode != null) {
            builder.append("\n");
            inOrderRecursiveTraversal(browsingNode.getLeft(), builder);
            builder.append(browsingNode.toString());
            inOrderRecursiveTraversal(browsingNode.getRight(), builder);
        }
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


    public void postOrderRecursiveTraversal(Node browsingNode, StringBuilder builder) {

        if (browsingNode != null) {
            postOrderRecursiveTraversal(browsingNode.getLeft(), builder);
            postOrderRecursiveTraversal(browsingNode.getRight(), builder);
            builder.append(browsingNode.toString());
        }
    }

    public void remove(Integer value) {

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        int maxHeight = getHeigth();
        int level = 0;

        Node browsingNode = root;
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

    class Node {

        private Integer key;
        private String value;
        private Node left;
        private Node right;

        Node(Integer key, String value) {
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
