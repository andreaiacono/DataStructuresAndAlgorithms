package interviewbit;

import org.junit.Test;

/**
 * https://www.interviewbit.com/problems/sort-list/
 */
public class MergeLists {

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    @Test
    public void test() {
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(21);
        ListNode node3 = new ListNode(-3);
        ListNode node4 = new ListNode(-14);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(-10);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        print("BEFORE: ", node1);
        ListNode merged = sortList(node1);
        print("AFTER: ", merged);


//        assertEquals(1, node1.val);
//        assertEquals(4, node1.next.val);
//        assertEquals(2, node1.next.next.val);
//        assertEquals(3, node1.next.next.next.val);
    }

    public ListNode sortList(ListNode a) {

        if (a.next == null) {
            return a;
        }
        return mergeSort(a);
    }

    void print(String msg, ListNode node) {
        System.out.print(msg + ": ");
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }


    ListNode mergeSort(ListNode firstStart) {

        int size = getSize(firstStart);
        if (size == 1) {
            return firstStart;
        }
        if (size == 2) {
            if (firstStart.val < firstStart.next.val) {
                return firstStart;
            }
            else {
                ListNode second = firstStart.next;
                second.next = firstStart;
                firstStart.next = null;
                return second;
            }
        }

        int index = 0;
        ListNode current = firstStart;
        while (current.next != null && index < size/2) {
            current = current.next;
            index++;
        }

        ListNode secondStart = current.next;
        current.next = null;

        ListNode first = mergeSort(firstStart);
        ListNode second = mergeSort(secondStart);
        print("first" , firstStart);
        print("second" , secondStart);

        ListNode merged = mergeList(first, second);
        print("merged" , merged);
        return merged;
    }


    private int getSize(ListNode current) {
        int counter = 1;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    ListNode mergeList(ListNode a, ListNode b) {

        ListNode result;

        if (a.val < b.val) {
            result = a;
            a = a.next;
        }
        else {
            result = b;
            b = b.next;
        }
        ListNode resultStart = result;


        while (a != null && b != null) {
            if (a.val < b.val) {
                result.next = a;
                a = a.next;
            }
            else {
                result.next = b;
                b = b.next;
            }
            result = result.next;
        }

        if (a == null) {
            result.next = b;
        }
        else {
            result.next = a;
        }

        return resultStart;
    }
}
