package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PalindromeNumber {


    @Test
    public void test() {
        assertTrue(isPalindrome(2147447412));
    }

    public boolean isPalindrome(int a) {
        int n = a;
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }

        return reverse == a;
    }


}
