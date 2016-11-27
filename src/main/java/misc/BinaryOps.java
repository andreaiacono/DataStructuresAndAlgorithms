package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryOps {

    @Test
    public void test(){
        int n = 13;
        int result = 3;
        assertEquals(result, getOnesNumber(n));
        assertEquals(result, binaryGetOnesNumber(n));
        assertEquals(result, stringGetOnesNumber(n));

        // 13 = 0b1101
        assertEquals(1, getBit(n, 3));
        assertEquals(1, getBit(n, 2));
        assertEquals(0, getBit(n, 1));
        assertEquals(1, getBit(n, 0));

        // 13 = 0b1101
        // 5 =  0b0101
        int newResult = 5;
        assertEquals(newResult, unsetBit(n, 3));
        assertEquals(newResult, flipBit(n, 3));
        assertEquals(n, setBit(newResult, 3));
    }

    /**
     * gets the k-th bit value
     */
    int getBit(int n, int k) {
        return (n >> k) & 1;
    }

    /**
     * sets the k-th bit value
     */
    int setBit(int n, int k) {
        return n | (1 << k);
    }

    /**
     * unsets the k-th bit value
     */
    int unsetBit(int n, int k) {
        return n & ~ (1 << k);
    }

    /**
     * flips the k-th bit value
     */
    int flipBit(int n, int k) {
        return n ^ (1 << k);
    }


    public static int getOnesNumber(int n) {
        int counter = 0;
        while (n > 0) {
            if (n % 2 != 0) counter++;
            n /= 2; // or n >> 2
        }
        return counter;
    }

    public static int binaryGetOnesNumber(int n) {
        int counter = 0;
        for (int j = 0; j < 32; j++) {
            if (((n >> j) & 1) == 1) counter++;
        }
        return counter;
    }

    public static int stringGetOnesNumber(int n) {
        String binary = Integer.toBinaryString(n);
        int index = 0;
        int counter = 0;
        while (index < binary.length()) {
            counter += binary.charAt(index++) == '1' ? 1 : 0;
        }
        return counter;
    }
}
