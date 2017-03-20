package misc;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class PalindromeList {

    class Node {
        int key;
        Node next;
        Node previous;

        public Node(int key) {
            this.key = key;
        }
        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
        void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    @Test
    public void test() {

        Node fourth = new Node(4);
        Node third = new Node(3, fourth);
        Node second = new Node(2, third);
        Node root = new Node(1, second);
        assertFalse(isPalindrome(root));
        assertFalse(isPalindromeWithStack(root));

        Node fifth = new Node(1);
        fourth = new Node(2, fifth);
        third = new Node(3, fourth);
        second = new Node(2, third);
        root = new Node(1, second);
        assertTrue(isPalindrome(root));
        assertTrue(isPalindromeWithStack(root));

        fourth = new Node(1);
        third = new Node(2, fourth);
        second = new Node(2, third);
        root = new Node(1, second);
        assertTrue(isPalindrome(root));
        assertTrue(isPalindromeWithStack(root));

        fifth = new Node(1);
        fourth = new Node(2, fifth);
        third = new Node(3, fourth);
        second = new Node(2, third);
        root = new Node(1, second);
        fifth.setPrevious(fourth);
        fourth.setPrevious(third);
        third.setPrevious(second);
        second.setPrevious(root);
        assertTrue(isDoublyPalindrome(root));

        fourth = new Node(2);
        third = new Node(3, fourth);
        second = new Node(2, third);
        root = new Node(1, second);
        fourth.setPrevious(third);
        third.setPrevious(second);
        second.setPrevious(root);
        assertFalse(isDoublyPalindrome(root));
    }

    private boolean isDoublyPalindrome(Node root) {
        Node left = root;
        Node right = getLast(root);

        while (left != right && left.next != right && right.next != left) {
            if (left.key != right.key) {
                return false;
            }
            left = left.next;
            right = right.previous;
        }

        return true;
    }
    private Node getLast(Node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    private boolean isPalindromeWithStack(Node root) {

        Node slow = root;
        Node fast = root;
        Deque<Node> stack = new ArrayDeque<>();
        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd case
        if (fast != null) {
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().key != slow.key) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    private boolean isPalindrome(Node root) {
        int length = getLength(root);
        for (int i=0; i<length/2; i++) {
            if (get(root, i).key != get(root, length-i-1).key) {
                return false;
            }
        }
        return true;
    }

    private int getLength(Node node) {
        int counter = 0;
        while (node != null) {
            node = node.next;
            counter ++;
        }
        return counter;
    }

    private Node get(Node node, int index) {
        int counter = 0;
        while (counter < index) {
            node = node.next;
            counter ++;
        }
        return node;
    }
}
