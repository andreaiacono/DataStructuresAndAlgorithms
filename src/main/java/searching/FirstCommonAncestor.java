package searching;

public class FirstCommonAncestor {

    static Node ancestor = null;

    private static int commonAncestor(Node currentNode, Node n1, Node n2) {

        if (currentNode == null) {
            return 0;
        }

        int found = 0;

        if (currentNode.equals(n1) || currentNode.equals(n2)) {
            found++;
        }
        found += commonAncestor(currentNode.left, n1, n2);
        found += commonAncestor(currentNode.right, n1, n2);

        if (found == 2) {
            ancestor = currentNode;
            found = 0;
        }

        return found;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);

        node1.left = node2;
        node1.right = node6;
        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node6.left = node7;
        node6.right = node8;
        node7.left = node14;
        node7.right = node10;
        node10.left = node11;
        node11.left = node12;
        node11.right = node13;
        node8.right = node9;

        // node not in tree
        Node node15 = new Node(15);

        Node n1 = node12;
        Node n2 = node7;
        commonAncestor(node1, n1, n2);
        System.out.println("First Common Ancestor of (" + n1.key + "," + n2.key + ") is " + (ancestor!= null ? ancestor.key : "not present"));
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
