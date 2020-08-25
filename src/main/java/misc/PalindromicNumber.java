package misc;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class PalindromicNumber {

    @Test
    public void test() {
        assertTrue(isPalindrome(121));
        assertTrue(isPalindrome(1221));
        assertTrue(isPalindrome(12421));
        assertTrue(isPalindrome(99));
        assertTrue(isPalindrome(5));
        assertTrue(isPalindrome(0));
        assertFalse(isPalindrome(987654567));
        assertFalse(isPalindrome(98));
        assertFalse(isPalindrome(988));
        assertFalse(isPalindrome(998));
        assertFalse(isPalindrome(1000));
    }

    boolean isPalindromeLazy(int n) {
        return ("" + Math.abs(n)).equals(new StringBuilder("" + Math.abs(n)).reverse().toString());
    }

    boolean isPalindrome(int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        int tmp = n;
        while (tmp != 0) {
            stack.push(tmp % 10);
            tmp /= 10;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != n % 10) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
