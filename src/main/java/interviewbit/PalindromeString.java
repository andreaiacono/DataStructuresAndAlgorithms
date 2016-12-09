package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeString {


    @Test
    public void test() {
        assertEquals(1, isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(0, isPalindrome("1a2"));
        assertEquals(1, isPalindrome(".,"));
    }

    public int isPalindrome(String a) {

        a = a.toLowerCase();
        int right = a.length() - 1;
        int left = 0;

        do {
            while (!isAlphaNumeric(a.charAt(left)) && left < right) {
                left++;
            }
            while (!isAlphaNumeric(a.charAt(right)) && right > left) {
                right--;
            }
            if (a.charAt(left) != a.charAt(right)) {
                return 0;
            }
            left++;
            right--;
        }
        while (left < right);

        return 1;
    }

    boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
