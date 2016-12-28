package interviewbit;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/reorder-list/
 */
public class ReOrderList {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(node1);

        assertEquals(1, node1.val);
        assertEquals(4, node1.next.val);
        assertEquals(2, node1.next.next.val);
        assertEquals(3, node1.next.next.next.val);
    }

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reorderList(ListNode a) {

        if (a.next == null || a.next.next == null) {
            return a;
        }

        ListNode start = a;

        int size = getSize(a);

        ListNode reversed = reverseAndCut(a, size/2);
        //print(reversed);
        ListNode original = a;

        while (original.next != null) {

            if (reversed == null) {
                break;
            }
            ListNode tmp = reversed.next;
            reversed.next = original.next;
            original.next = reversed;

            reversed = tmp;
            original = original.next.next;
        }

        return start;
    }

    void print(ListNode node) {
        System.out.print("Reversed: ");
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }

    private ListNode reverseAndCut(ListNode current, int start) {

        int index = 0;
        while (current.next != null && index <= start-1) {
            current = current.next;
            index++;
        }

        ListNode reverseStart = current.next;
        current.next = null;

        Deque<ListNode> stack = new ArrayDeque<>();
        while (reverseStart.next != null) {
            stack.push(reverseStart);
            reverseStart = reverseStart.next;
        }
        stack.push(reverseStart);

        ListNode first = stack.pop();
        ListNode beforeLast = first;
        while (!stack.isEmpty()) {
            ListNode last = stack.pop();
            beforeLast.next = last;
            beforeLast = beforeLast.next;
        }
        beforeLast.next = null;

        return first;
    }


    private int getSize(ListNode current) {
        int counter = 1;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }


    public ListNode reorderListNotEfficient(ListNode a) {

        if (a.next == null || a.next.next == null) {
            return a;
        }


        ListNode start = a;
        ListNode currentNode = a;

        while (currentNode != null) {

            ListNode nodeBeforeLast = getNodeBeforeLast(currentNode);
            if (nodeBeforeLast == null || nodeBeforeLast == currentNode) {
                break;
            }
            nodeBeforeLast.next.next = currentNode.next;
            currentNode.next = nodeBeforeLast.next;
            nodeBeforeLast.next = null;
            currentNode = currentNode.next.next;
        }

        return start;
    }

    private ListNode getNodeBeforeLast(ListNode current) {
        if (current.next == null) {
            return null;
        }
        while (current.next != null && current.next.next != null) {
            current = current.next;
        }
        return current;
    }
}
