package misc;

import org.junit.Test;
import tree.Node;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TreeCousins {

    /**
     * Two nodes in a binary tree can be called cousins if they are on the same level of the tree
     * but have different parents. For example, in the following diagram 4 and 6 are cousins.
     *
     * 1
     * / \
     * 2   3
     * / \   \
     * 4   5   6
     *
     * Given a binary tree and a particular node, find all cousins of that node.
     */


    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);

        assertEquals(2, findNodeLevel(root, root.right, 1));
        assertEquals(3, findNodeLevel(root, root.right.left, 1));
        assertEquals(4, findNodeLevel(root, root.right.right.left, 1));
        assertEquals(2, findNodeLevelBfs(root, root.right));
        assertEquals(3, findNodeLevelBfs(root, root.right.left));
        assertEquals(4, findNodeLevelBfs(root, root.right.right.left));

        assertEquals(1, findNodesAtLevel(root, 1).size());
        assertEquals(2, findNodesAtLevel(root, 2).size());
        assertEquals(3, findNodesAtLevel(root, 3).size());
        assertEquals(1, findNodesAtLevel(root, 4).size());
        System.out.println(findNodesAtLevel(root, 1));
        System.out.println(findNodesAtLevel(root, 2));
        System.out.println(findNodesAtLevel(root, 3));
        System.out.println(findNodesAtLevel(root, 4));
    }

    int findNodeLevel(Node current, Node target, int level) {
        if (current == target) {
            return level;
        }

        if (current.left != null) {
            int result = findNodeLevel(current.left, target, level + 1);
            if (result != 0) {
                return result;
            }
        }
        if (current.right != null) {
            int result = findNodeLevel(current.right, target, level + 1);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    int findNodeLevelBfs(Node root, Node target) {
        LeveledNode lroot = new LeveledNode(root, 1);

        Deque<LeveledNode> queue = new ArrayDeque<>();
        queue.add(lroot);

        while (!queue.isEmpty()) {
            LeveledNode current = queue.poll();
            if (current.node.equals(target)) {
               return current.level;
            }
            if (current.node.left != null) {
                queue.add(new LeveledNode(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {
                queue.add(new LeveledNode(current.node.right, current.level + 1));
            }
        }

        // the target node is not part of the tree
        return -1;
    }

    List<Node> findNodesAtLevel(Node root, int level) {
        LeveledNode lroot = new LeveledNode(root, 1);

        Deque<LeveledNode> queue = new ArrayDeque<>();
        queue.add(lroot);

        List<Node> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            LeveledNode current = queue.poll();
            if (current.level == level) {
                result.add(current.node);
            }
            else {
                if (current.node.left != null) {
                    queue.add(new LeveledNode(current.node.left, current.level + 1));
                }
                if (current.node.right != null) {
                    queue.add(new LeveledNode(current.node.right, current.level + 1));
                }
            }
        }

        return result;
    }


    class LeveledNode {
        Node node;
        int level;

        public LeveledNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LeveledNode that = (LeveledNode) o;

            if (level != that.level) return false;
            return node != null ? node.equals(that.node) : that.node == null;
        }

        @Override
        public int hashCode() {
            int result = node != null ? node.hashCode() : 0;
            result = 31 * result + level;
            return result;
        }
    }

    class Node {
        int val;
        int level;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return val == node.val;
        }

        @Override
        public int hashCode() {
            return val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
}
