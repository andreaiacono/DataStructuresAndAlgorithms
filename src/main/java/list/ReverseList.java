package list;

import org.junit.Test;
import org.w3c.dom.NodeList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static com.google.common.collect.Iterables.isEmpty;
import static junit.framework.TestCase.assertEquals;

public class ReverseList {

    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        assertEquals("6, 5, 4, 3, 2, 1", toString(reverseList(node1)));

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        assertEquals("6, 5, 4, 3, 2, 1", toString(reverseListNoStack(node1)));

    }

    private ListNode reverseList(ListNode head) {

        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        head = stack.pop();

        current = head;
        while (!isEmpty(stack)) {
            current.next = stack.pop();
            current = current.next;
        }
        current.next = null;
        return head;
    }

    private ListNode reverseListNoStack(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode succ = null;

        while (current != null) {
            succ = current.next;
            current.next = prev;
            prev = current;
            current = succ;
        }

        return prev;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    String toString(ListNode node) {
        StringBuilder result = new StringBuilder("" + node.val);
        ListNode current = node.next;
        while (current != null) {
            result.append(", ").append(current.val);
            current = current.next;
        }
        return result.toString();
    }
}
