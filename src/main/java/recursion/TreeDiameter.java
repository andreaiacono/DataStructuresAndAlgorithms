package recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TreeDiameter {


    @Test
    public void test() {
        Node root = new Node(0);
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

        root.addChildren(node1, node2, node3);
        node1.addChildren(node4);
        node2.addChildren(node5, node6, node7);
        node3.addChildren(node8, node9);
        node6.addChildren(node10);

        assertEquals(node10, getDeepestNode(root));

        assertEquals(4, getHeight(root));
        assertEquals(6, getDiameter(root));
    }

    public int getDiameter(Node node) {
        if (node == null) {
            return 0;
        }

        int maxHeight = 0;
        int secondHeight = 0;
        for (Node child: node.children) {
            int childHeight = getHeight(child);
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
            else if (childHeight > secondHeight) {
                secondHeight = childHeight;
            }
        }

        int height = maxHeight + secondHeight + 1;

        int maxDiameter = 0;
        for (Node child: node.children) {
            int childDiameter = getDiameter(child);
            if (maxDiameter < childDiameter) {
                maxDiameter = childDiameter;
            }
        }

        return Math.max(maxDiameter, height);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        for (Node child: node.children) {
            int childMax = getHeight(child);
            if (childMax > max) {
                max = childMax;
            }
        }
        return 1 + max;
    }

    public Node getDeepestNode(Node root) {
        return getDeepestNode(root, 1).node;
    }

    private Result getDeepestNode(Node node, int level) {
        int max = level;
        Node deepestNode = node;

        for (Node child: node.children) {
            Result result = getDeepestNode(child, level+1);
            if (result.level > max) {
                max = result.level;
                deepestNode = result.node;
            }
        }
        return new Result(max, deepestNode);
    }

    class Result {

        int level;
        Node node;

        public Result(int level, Node node) {
            this.level = level;
            this.node = node;
        }
    }

    class Node {

        Set<Node> children = new LinkedHashSet<>();
        int value;

        public Node(int value) {
            this.value = value;
        }

        public void addChildren(Node... child) {
            children.addAll(Arrays.asList(child));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
