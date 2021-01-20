package list;

import list.ReverseList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ListCycles {

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

        assertFalse(hasCycle(node1));
        node6.next = node3;
        assertTrue(hasCycle(node1));
    }

    boolean hasCycle(ListNode root) {

        ListNode slow = root;
        ListNode fast = root;

        while (slow != fast) {
            slow = slow.next;
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
        }

        return true;
    }

    boolean hasCycle(GraphNode root) {
return false;
    }


    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    class GraphNode {
        int val;
        List<GraphNode> neighbours = new ArrayList<>();

        public GraphNode(int val) {
            this.val = val;
        }
    }

}
