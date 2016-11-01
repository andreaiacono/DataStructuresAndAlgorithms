package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Bit {

    @Test
    public void test() {
        assertEquals(3, getOnes(13));
        assertEquals(2, getOnes(9));
        assertEquals(1, getOnes(16));
        assertEquals(3, getOnesVersion2(13));
        assertEquals(2, getOnesVersion2(9));
        assertEquals(1, getOnesVersion2(16));

        assertTrue(isBinaryPalindrome(9));
        assertFalse(isBinaryPalindrome(10));
    }

    public int getOnes(int n) {
        int count = 0;
        while (n > 0) {
            if (n%2 == 1) {
                count ++;
            }
            n /= 2;
        }
        return count;
    }

    public int getOnesVersion2(int n) {
        int count = 0;
        for (int j=0; j<32; j++) {
            count += n & 1;
            n = n >> 1;
        }

        return count;
    }

    public boolean isBinaryPalindrome(int a) {
        return Integer.toBinaryString(a).equals(reverse(Integer.toBinaryString(a)));
    }

    public String reverse(String s) {
        StringBuilder builder = new StringBuilder();
        for (int j=s.length()-1; j>=0; j--) {
            builder.append(s.charAt(j));
        }

        return builder.toString();
    }

}
