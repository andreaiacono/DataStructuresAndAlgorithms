package tree;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TreeSerDe {

    @Test
    public void test() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(15);
        root.right.right.right.left = new Node(25);

        Printer.printNode(root);
        System.out.println(serializeTree(root));
        String expected = "1,2,3,4,,6,7,,,,,,,10,15,,,,,,,,,,,,,,,25,,,";
        assertEquals(expected, serializeTree(root));
        Printer.printNode(deserializeTree(serializeTree(root)));
    }

    String serializeTree(Node root) {
        int treeSize = (int) Math.pow(2, getMaxLevel(root));
        String[] nodes = new String[treeSize];
        fillNodes(root, nodes, 1);

        StringBuilder result = new StringBuilder();
        for (String current: nodes) {
            result.append(current == null ? "" : current).append(",");
        }
        return result.toString().trim();
    }

    void fillNodes(Node current, String[] nodes, int index) {

        if (current == null) {
            return;
        }

        nodes[index - 1] = "" + current.data;
        fillNodes(current.left, nodes, index * 2);
        fillNodes(current.right, nodes, index * 2 + 1);
    }

    int getMaxLevel(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + Math.max(getMaxLevel(current.left), getMaxLevel(current.right));
    }

    Node deserializeTree(String tree) {

        String[] nodeValues = tree.split(",");
        Node[] nodes = new Node[nodeValues.length];
        nodes[0] = nodeValues[0].equals("-") ? null : new Node(Integer.parseInt(nodeValues[0]));

        int index = 1;
        while (index < nodeValues.length) {
            Node current = nodeValues[index].equals("") ? null : new Node(Integer.parseInt(nodeValues[index]));
            nodes[index] = current;
            if (nodes[(index - 1) / 2] != null) {
                if ((index - 1) % 2 == 0) {
                    nodes[(index - 1) / 2].left = current;
                } else {
                    nodes[(index - 1) / 2].right = current;
                }
            }
            index++;
        }
        return nodes[0];
    }

}
