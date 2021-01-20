package misc;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class ListIntersection {

    /**
     * Given two singly linked lists that intersect at some point, find the intersecting node.
     * The lists are non-cyclical.
     * <p>
     * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
     * * In this example, assume nodes with the same value are the exact same node objects.
     * <p>
     * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
     * <p>
     * <p>
     * 1 -> 5 -> 3  \
     * >  7 -> 10
     * 4 -> 2 ->  /
     */

    @Test
    public void test() {

        Node intersection = new Node(8);
        intersection.next = new Node(10);
        intersection.next.next = new Node(101);

        Node node1 = new Node(3);
        node1.next = new Node(7);
        node1.next.next = intersection;

        Node node2 = new Node(99);
        node2.next = new Node(5);
        node2.next.next = new Node(17);
        node2.next.next.next = new Node(1);
        node2.next.next.next.next = intersection;

        assertEquals(intersection.val, getIntersection(node1, node2).val);
        assertEquals(intersection.val, getIntersection2(node1, node2).val);
    }

    /**
     * runtime complexity: O(n+m)
     * space complexity: O(1)
     */
    Node getIntersection(Node root1, Node root2) {
        int length1 = 0;
        Node node1 = root1;
        while (node1 != null) {
            length1++;
            node1 = node1.next;
        }

        int length2 = 0;
        Node node2 = root2;
        while (node2 != null) {
            length2++;
            node2 = node2.next;
        }
        int diff = Math.abs(length1 - length2);

        node1 = root1;
        node2 = root2;
        for (int i = 0; i < diff; i++) {
            if (length1 > length2) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
        }

        while (node1 != null) {
            if (node1.val == node2.val) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        return null;
    }

    /**
     * runtime complexity: O(n+m)
     * space complexity: O(n)
     */
    Node getIntersection2(Node node1, Node node2) {
        Set<Integer> present = new HashSet<>();

        while (node1 != null) {
            present.add(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            if (present.contains(node2.val)) {
                return node2;
            }
            node2 = node2.next;
        }

        return null;
    }

}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
