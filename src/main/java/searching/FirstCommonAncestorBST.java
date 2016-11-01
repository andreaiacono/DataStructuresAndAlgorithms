package searching;

public class FirstCommonAncestorBST {

    private static Node recurse(Node currentNode, Node n1, Node n2) {

        if (currentNode == null) {
            return null;
        }

        if (currentNode.key >= n1.key && currentNode.key < n2.key) {
            return currentNode;
        }

        Node foundNode = recurse(currentNode.left, n1, n2);
        if (foundNode != null) {
            return foundNode;
        }
        foundNode = recurse(currentNode.right, n1, n2);
        if (foundNode != null) {
            return foundNode;
        }

        return null;
    }

    private static Node commonAncestorBST(Node currentNode, Node n1, Node n2) {
        if (n1.key < n2.key) {
            return recurse(currentNode, n1, n2);
        }
        else {
            return recurse(currentNode, n2, n1);
        }
    }



        public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node12 = new Node(12);

        node5.left = node3;
        node3.left= node2;
        node2.left = node1;
        node3.right = node4;
        node5.right = node8;
        node8.left = node6;
        node8.right = node10;
        node10.left = node9;
        node10.right = node12;

        // node not in tree
        Node node15 = new Node(15);

        Node n1 = node8;
        Node n2 = node9;
        Node ancestor = commonAncestorBST(node5, n1, n2);
        System.out.println("First Common Ancestor BST of (" + n1.key + "," + n2.key + ") is " + (ancestor!= null ? ancestor.key : "not present"));
    }

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}
