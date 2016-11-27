package misc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PalindromeNumbers {

    @Test
    public void test() {
        System.out.println(Arrays.toString(palindromes(1000)));
        assertTrue(Arrays.equals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11}, palindromes(12)));
    }

    boolean isPalindrome(int number) {
        int n = number;
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + (n % 10);
            n /= 10;
        }

        return reverse == number;
    }

    boolean isPalindrome2(String s) {
        for (int j = 0; j < s.length() / 2; j++) {
            if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                return false;
            }
        }

        return true;
        // or
        // return new StringBuilder(s).reverse().toString().equals(s);
    }

    int[] palindromes(int k) {

        int[] result = new int[k];
        int counter = 0;
        for (int j = 1; j <= k; j++) {
            if (isPalindrome(j)) {
                result[counter++] = j;
            }
        }
        return Arrays.copyOf(result, counter);
    }
}
