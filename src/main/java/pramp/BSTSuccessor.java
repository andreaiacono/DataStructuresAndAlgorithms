package pramp;

import org.junit.Test;

public class BSTSuccessor {

    @Test
    public void test() {

        String tree = "10<5<3<1,4>,8<6,9>>,15<13<11,14>,18<16,19>>>";
        Node root = treeify(tree);
    }

    public Node treeify(String tree) {

        String[] tokens = tree.split("[<>,]");
        for (String token: tokens) {
            System.out.println("TOKEN=" + token);
        }

        return null;
    }

    class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        public Node(int key) {
            this.key = key;
        }
    }

    int getSuccessor(Node node) {
        if (node.right != null) {
            return getLeftMost(node.right);
        }

        if (node.parent.left == node) {
            return node.parent.key;
        }

        Node current = node;
        while (current.parent != null) {
            Node parent = current.parent;
            if (parent.left == current) {
                return parent.key;
            }
            current = parent;
        }

        return current.key;
    }

    int getLeftMost(Node node) {

        while (node.left != null) {
            node = node.left;
        }
        return node.key;
    }

}
