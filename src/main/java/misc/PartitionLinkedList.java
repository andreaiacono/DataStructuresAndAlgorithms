package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andrea on 11/12/16.
 */
public class PartitionLinkedList {

    @Test
    public void test() {

        System.out.println("30/24 = " + gcd(24,30));
        System.out.println("30/24 = " + gcd2(24,30));

        Node node = new Node(3);
        Node root = node;

        node.next = new Node(-9);
        node = node.next;

        node.next = new Node(7);
        node = node.next;

        node.next = new Node(11);
        node = node.next;

        node.next = new Node(0);
        node = node.next;

        node.next = new Node(-3);
        node = node.next;

        node.next = new Node(5);
        node = node.next;

        node.next = new Node(6);
        node = node.next;

        node.next = new Node(-1);
        node = node.next;

        node.next = new Node(2);
        node = node.next;

        node.next = new Node(10);

        int x = 4;
        System.out.println(toString(root));
        int size = count(root);
        root = partitionList(root, x);
        System.out.println(toString(root));
        assertEquals(size, count(root));
        node = root;
        while (node != null && node.val <= x) {
            node = node.next;
        }

        while (node != null) {
            assertTrue(node.val > x);
            node = node.next;
        }
    }

    String toString(Node node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append(" -> ");
            node = node.next;
        }
        if (builder.length() > 4) {
            builder.delete(builder.length() -4, builder.length()-1);
        }
        return builder.toString();
    }

    int count(Node node) {
        int counter = 0;
        while (node != null) {
            counter++;
            node = node.next;
        }
        return counter;
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public String toString() {
            return "" +val;
        }
    }

    Node partitionList(Node node, int x) {

        Node lesser = null;
        Node rootLesser = null;
        Node greater = null;
        Node rootGreater = null;

        while (node != null) {
            if (node.val <= x) {
                if (rootLesser == null) {
                    lesser = node;
                    rootLesser = lesser;
                }
                else {
                    lesser.next = node;
                    lesser = node;
                }
            }
            else {
                if (rootGreater == null) {
                    greater = node;
                    rootGreater = greater;
                }
                else {
                    greater.next = node;
                    if (node.next != null) {
                        greater = node;
                    }
                }
            }
            node = node.next;
        }

        greater.next = null;

        node = rootLesser;
        while (node.next != null) {
            node = node.next;
        }

        node.next = rootGreater;
        return rootLesser;
    }


    int gcd2(int n1, int n2) {
        int r;
        while(n2 != 0)
        {
            r = n1 % n2;
            n1 = n2;
            n2 = r;
        }

        return n1;
    }
    int gcd(int p, int q) {

        if (q == 0) {
            return p;
        }

        return gcd(q, p%q);
    }

}
