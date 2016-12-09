package pramp;

public class LargerSmallerBST {

    class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }


    Integer getLargerSmaller(Node node, int x) {

        if (node.key < x) {
            return node.key;
        }

        Integer result = null;
        while (node != null) {

            if (node.key < x) {
                result = node.key;
                node = node.right;
            }
            else {
                node = node.left;
            }
        }

        return result;
    }

}
