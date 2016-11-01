package misc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 15/07/14
 * Time: 19.21
 */
public class Tree  {


    Node root;

    public static void main(String[] args) {
        Tree tree=new Tree();
        Node root = new Node(1);
        List<Node> nodes = new LinkedList<>();
        List<Node> nodes2 = new LinkedList<>();
        Node node2 = new Node(2);
        nodes2.add(new Node(5));
        nodes2.add(new Node(6));
        node2.children = nodes2;

        nodes.add(node2);
        nodes.add(new Node(3));
        nodes.add(new Node(4));
        root.children = nodes;
        tree.root = root;

        System.out.println("Stringify: " + tree.toString());
    }


    public String toString() {

        return stringify(root);
    }


    private String stringify(Node node) {

        if (node.children.size() == 0) {
            return node.getValue() + " ";
        }

        String result = "";
        result += node.getValue() + " ";

        Iterator it = node.children.listIterator();
        while (it.hasNext()) {
            Node n = (Node) it.next();
            result += stringify(n);
        }
        return result;
    }


    static class Node {

        private int value;
        public List<Node> children = new LinkedList<>();

        Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}