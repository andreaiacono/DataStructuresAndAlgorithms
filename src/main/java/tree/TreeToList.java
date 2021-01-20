package tree;

import com.google.common.base.Objects;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TreeToList {

    /**
     * Convert a binary tree to a doubly linked list so that the order of the doubly linked list is the same
     * as an in-order traversal of the binary tree.
     * After conversion, the left pointer of the node should be pointing to the previous node in the doubly
     * linked list, and the right pointer should be pointing to the next node in the doubly linked list.
     */

    @Test
    public void test() {

        Node root = new Node(100);
        root.left = new Node(50);
        root.left.left = new Node(25);
        root.left.left.right = new Node(30);
//        root.left.right = new Node(75);
//        root.left.right.left = new Node(60);
        root.right = new Node(200);
//        root.right.left = new Node(125);
//        root.right.right = new Node(350);

        Printer.printNode(root);

        ListNode expectedListRoot = new ListNode(25);
        ListNode preceding = expectedListRoot;
        List<Integer> values = List.of(30, 50, 100, 200);
        for (int val : values) {
            preceding.next = new ListNode(val);
            preceding.next.prev = preceding;
            preceding = preceding.next;
        }
        System.out.println(listToString(expectedListRoot));

        ListNode rootList = treeToList(root);
        System.out.println(rootList);

        assertEquals(listToString(expectedListRoot), listToString(treeToList(root)));
    }

    ListNode concatenateList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode tail1 = head1.prev;
        ListNode tail2 = head2.prev;

        tail1.next = head2;
        head2.prev = tail1;

        head1.prev = tail2;
        tail2.next = head1;

        return head1;
    }

    ListNode treeToList(Node current) {

        if (current == null) {
            return null;
        }

        ListNode leftNode = treeToList(current.left);
        ListNode rightNode = treeToList(current.right);

        ListNode currentListNode = new ListNode(current.data);

        ListNode result = concatenateList(leftNode, currentListNode);
        result = concatenateList(result, rightNode);

        return result;
    }

    String listToString(ListNode root) {
        StringBuilder str = new StringBuilder("List: ").append(root.val);
        while (root.next != null) {
            root = root.next;
            str.append(" -> ").append(root.val);
        }

        return str.toString();
    }

    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("val", val)
                    .toString();
        }
    }

}
