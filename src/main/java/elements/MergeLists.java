package elements;

public class MergeLists {

    public static void main(String args[]) {

        ListNode root1 = new ListNode(1, new ListNode(5, new ListNode(10, null)));
        ListNode root2 = new ListNode(0, new ListNode(2, new ListNode(3, new ListNode(7, new ListNode(10, new ListNode(11, null))))));

        System.out.println(traverse(root1));
        System.out.println(traverse(root2));
        System.out.println(traverse(merge(root1, root2)));
    }

    static ListNode merge(ListNode node1, ListNode node2) {

        ListNode root = null;
        if (node1.val < node2.val) {
            root = node1;
            node1 = node1.next;
        } else {
            root = node2;
            node2 = node2.next;
        }
        ListNode current = root;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            } else {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }
        }

        ListNode remaining = node1 != null ? node1 : node2;

        while (remaining != null) {
            current.next = remaining;
            remaining = remaining.next;
        }

        return root;
    }

    static String traverse(ListNode node) {

        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(" -> ");
            node = node.next;
        }
        builder.append("[]");
        return builder.toString();
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
