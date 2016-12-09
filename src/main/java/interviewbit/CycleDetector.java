package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CycleDetector {

    class Node {
        Node next;
    }

    @Test
    public void test() {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.next = n2;
        n2.next = n3;

        assertNull(detectCycle(n1));

        n3.next = n2;
        assertEquals(n2, detectCycle(n1));
    }


    public Node detectCycle(Node a) {

        if (a.next == null) {
            return null;
        }

        if (a.next == a) {
            return a;
        }

        Node start = a;

        Node slow = a;
        Node fast = a;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                int length = getCycleLength(slow);
                return getCycleHead(start, length);
            }
        }

        return null;
    }

    int getCycleLength(Node current) {
        Node marker = current;
        int counter = 0;
        do {
            current = current.next;
            counter++;
        }
        while (current != marker);

        return counter;
    }

    Node getCycleHead(Node start, int length) {
        Node current = start;
        Node forward = start;
        for (int i=0; i<length; i++) {
            forward = forward.next;
        }

        while (current != forward) {
            current = current.next;
            forward = forward.next;
        }

        return current;
    }
}
