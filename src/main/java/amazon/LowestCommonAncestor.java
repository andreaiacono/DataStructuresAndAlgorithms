package amazon;

import misc.Educative;
import org.junit.Test;
import tree.Node;
import tree.Printer;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestor {

    /**
     * Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program
     * to find the least common ancestor.
     */

    @Test
    public void test2() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        assertEquals(3, getMiddle(head));

        head.next.next.next.next.next = new ListNode(6);
        assertEquals(4, getMiddle(head));
    }

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int val) {
            this.data = val;
        }

    }

    int getMiddle(ListNode head) {
        // Your code here.

        int count = 0;
        ListNode current = head;
        while (current != null) {
            count ++;
            current = current.next;
        }

        int mid = count / 2 + 1;

        current = head;
        for (int i=0; i<mid-1; i++) {
            current = current.next;
        }

        return current.data;

    }
    @Test
    public void test() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.right = new Node(2);
        root.left.right = new Node(7);
        root.left.right.left = new Node(1);
        root.left.right.right = new Node(8);
        root.right.left = new Node(12);
        root.right.left.left = new Node(11);
        root.right.left.right = new Node(6);
        root.right.right = new Node(18);
        root.right.right.left = new Node(18);
        root.right.right.right = new Node(13);
        Printer.printNode(root);

        assertEquals(root, lca(root, root.left.left.left, root.right));
        assertEquals(root, lca(root, root, root.right));
        assertEquals(root.left, lca(root, root.left.left.left, root.left.right));
        assertEquals(root.right, lca(root, root.right.left, root.right.right));
    }

    Node lca(Node root, Node n1, Node n2) {
        List<Node> l1 = getPath(root, n1);
        List<Node> l2 = getPath(root, n2);

        int index = 0;
        while (index < l1.size() && index < l2.size() && l1.get(index).equals(l2.get(index))) {
            index ++;
        }
        return l1.get(index-1);
    }


    List<Node> getPath(Node root, Node searchedNode) {

        Deque<ParentNode> stack = new ArrayDeque<>();
        stack.push(new ParentNode(root, null));

        while (!stack.isEmpty()) {
            ParentNode current = stack.pop();

            if (current.node.equals(searchedNode)) {
                return getPath(current);
            }

            if (current.node.left != null) {
                stack.push(new ParentNode(current.node.left, current));
            }
            if (current.node.right != null) {
                stack.push(new ParentNode(current.node.right, current));
            }
        }

        return List.of();
    }

    private List<Node> getPath(ParentNode current) {

        List<Node> path = new ArrayList<>();
        path.add(current.node);

        while (current.parent != null) {
            current = current.parent;
            path.add(current.node);
        }

        Collections.reverse(path);

        return path;
    }

    class ParentNode {
        Node node;
        ParentNode parent;

        public ParentNode(Node node, ParentNode parent) {
            this.node = node;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ParentNode that = (ParentNode) o;
            return Objects.equals(node, that.node) && Objects.equals(parent, that.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, parent);
        }

        @Override
        public String toString() {
            return "node=" + node + ", parent=" + parent;
        }
    }
}
