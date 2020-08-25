package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemsWarmUp {

    @Test
    public void test() throws Exception {
        assertEquals(120, factorial(5));

        assertEquals(13, digitSum(157));
        assertEquals(1, digitSum(10000));
        assertEquals(1, digitSum(0000001));
        assertEquals(44, digitSum(386431784));

        assertEquals("cba", reverse("abc"));
        assertEquals("", reverse(""));
        assertEquals("wxyz", reverse("zyxw"));

        assertFalse(palindrome("abc"));
        assertFalse(palindrome("abcb"));
        assertFalse(palindrome("abcba "));
        assertTrue(palindrome("abcba"));
        assertTrue(palindrome(""));
        assertTrue(palindrome("a"));
        assertTrue(palindrome("bb"));
        assertTrue(palindrome("bbbb"));
        assertTrue(palindrome("bbbbb"));

        Node root = new Node(10);
        Node l1 = new Node(5);
        Node l1l2 = new Node(3);
        Node l1r2 = new Node(7);
        Node r1 = new Node(20);
        Node r1l2 = new Node(17);
        Node r1r2 = new Node(23);
        root.left = l1;
        root.right = r1;
        l1.left = l1l2;
        l1.right = l1r2;
        r1.left = r1l2;
        r1.right = r1r2;
        assertEquals("3, 5, 7, 10, 17, 20, 23, ", sortedBST(root));

        assertTrue(isSubsequence("hat", "cathartic"));
        assertFalse(isSubsequence("bat", "table"));
        assertTrue(iterativeIsSubsequence("hat", "cathartic"));
        assertFalse(iterativeIsSubsequence("bat", "table"));
    }

    long factorial(int n) {
        if (n == 2) {
            return 2;
        }
        return n * factorial(n-1);
    }

    long digitSum(int n) throws Exception {
        return digitSum("" + n);
    }

    long digitSum(String n) throws Exception {
        if (n.length() == 1) {
            return Long.parseLong("" + n.charAt(0));
        }
        return Long.parseLong("" + n.charAt(0)) + digitSum(n.substring(1));
    }

    String reverse(String s) {
        if (s.length() == 0) {
            return "";
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    boolean palindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        else if (s.length() == 0) {
            return true;
        }

        if (s.charAt(0) != s.charAt(s.length()-1)) {
            return false;
        }
        else {
            return palindrome(s.substring(1, s.length()-1));
        }
    }

    String sortedBST(Node current) {
        if (current == null) {
            return "";
        }
        return sortedBST(current.left) + (current.val + ", ") + sortedBST(current.right);
    }


    boolean isSubsequence(String s1, String s2) {
        if (s1.length() == 0) {
            return true;
        }
        int index = 0;
        while (index < s2.length() && s2.charAt(index) != s1.charAt(0)) {
            index ++;
        }
        if (index == s2.length()) {
            return false;
        }
        return isSubsequence(s1.substring(1), s2.substring(index+1));
    }

    boolean iterativeIsSubsequence(String s1, String s2) {
        int index = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(index)) {
                index ++;
            }
            else {
                while (index < s2.length() && s2.charAt(index) != s1.charAt(i)) {
                    index ++;
                }
                if (index == s2.length()) {
                    return false;
                }
            }
        }
        return true;
    }

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}

