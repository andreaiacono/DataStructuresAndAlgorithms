package elements;

import elements.MergeLists.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static junit.framework.TestCase.assertEquals;

public class MergeKLists {

    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * <p>
     * Merge all the linked-lists into one sorted linked-list and return it.
     */
    @Test
    public void test() {
        ListNode l1 = fromArray(new int[]{1, 4, 5});
        ListNode l2 = fromArray(new int[]{1, 3, 4});
        ListNode l3 = fromArray(new int[]{2, 6});

        ListNode merged = mergeKLists(new ListNode[]{l1, l2, l3});
        String expected = "1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> []";
        assertEquals(expected, MergeLists.traverse(merged));
    }

    private ListNode fromArray(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0 || (lists.length == 1 && lists[0] == null)) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparing(node -> node.val));
        for (ListNode head : lists) {
            if (head != null) {
                heap.add(head);
            }
        }
        ListNode head = heap.poll();
        if (head != null && head.next != null) {
            heap.add(head.next);
        }
        ListNode current = head;
        while (!heap.isEmpty()) {
            current.next = heap.poll();
            current = current.next;
            if (current.next != null) {
                heap.add(current.next);
            }
        }

        return head;
    }
}
