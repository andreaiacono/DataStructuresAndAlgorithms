package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MergeTwoSortedLists {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        Node n1 = new Node(1);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n2 = new Node(2);
        Node n4 = new Node(4);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.next = n3;
        n3.next = n5;

        n2.next = n4;
        n4.next = n6;
        n6.next = n7;

        Node current = mergeTwoLists(n1, n2);

        while (current.next != null) {
            assertTrue(current.val <= current.next.val);
            current = current.next;
        }
    }


    public Node mergeTwoLists(Node a, Node b) {

        Node first = a.val <= b.val ? a : b;
        Node second = a.val > b.val ? a : b;
        Node start = first;

        while (first.next != null) {
            if (first.next.val >= second.val) {
                second = insertNodeAfter(first, second);
                if (second == null) {
                    break;
                }
            }
            first = first.next;
        }

        if (second != null) {
            first.next = second;
        }

        return start;
    }

    Node insertNodeAfter(Node a, Node b) {

        Node prevBNext = b.next;

        b.next = a.next;
        a.next = b;

        return prevBNext;
    }
}
