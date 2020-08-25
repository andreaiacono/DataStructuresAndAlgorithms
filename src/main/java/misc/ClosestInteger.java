package misc;

import org.junit.Test;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import static org.junit.Assert.*;

public class ClosestInteger {

    @Test
    public void test() {

        int high = 2100000000;
        int low = 2000000000;
        System.out.println("mid using >> 1 = " + ((low + high) >> 1));
        System.out.println("mid using >>> 1 = " + ((low + high) >>> 1));
        System.out.println("mid using / 2   = " + ((low + high) / 2));
        System.out.println("mid using (high-low)/ 2   = " + ((low + (high-low) / 2)));

        System.out.println("121: " + Integer.toBinaryString(121));
        System.out.println("121 >> 1: " + Integer.toBinaryString(121 >> 1));
        System.out.println("121 >>> 1: " + Integer.toBinaryString(121 >>> 1));
        System.out.println("121: " + Integer.toBinaryString(121));
        System.out.println("121 >> 1: " + Integer.toBinaryString(121 >> 1));
        System.out.println("121 >>> 1: " + Integer.toBinaryString(121 >>> 1));
        System.out.println("MIN:       " + Integer.toBinaryString(Integer.MIN_VALUE) + " " + (Integer.MIN_VALUE ));
        System.out.println("MIN >> 1:  " + Integer.toBinaryString(Integer.MIN_VALUE >> 1) + " " + (Integer.MIN_VALUE >> 1));
        System.out.println("MIN >>> 1: " + Integer.toBinaryString(Integer.MIN_VALUE >>> 1) + " " + (Integer.MIN_VALUE >>> 1));

        double e = 0.0000001;
        Random r = new Random(1024);
        for (long i=0; i< 100_000_000_000l; i++) {
            double val = r.nextDouble();
            if (val == 1.0d) {
                System.out.println("["+i+"] " + val + " == 1 !!!!");
                break;
            }
//            if (1 - val < e ) {
//                System.out.println("["+i+"] " + val + " - Diff: " + (1-val));
//            }
        }

        assertTrue(isPair(0));
        assertTrue(isPair(2));
        assertTrue(isPair(4));
        assertTrue(isPair(6));
        assertTrue(isPair(8));
        assertTrue(isPair(10));
        assertFalse(isPair(1));
        assertFalse(isPair(3));
        assertFalse(isPair(5));
        assertFalse(isPair(7));
        assertFalse(isPair(9));

        assertEquals(5, closestInteger(3));
        assertEquals(6, closestInteger(5));
        assertEquals(5, closestInteger(6));
        assertEquals(1, closestInteger(0));
        assertEquals(2, closestInteger(1));


    }

    boolean isPair(int n) {
        return (1 & n) == 0;
    }

    int closestInteger(int n) {

        if (n ==0) {
            return 1;
        }

        // LSB is 0
        if ( (1 & n) == 0 ) {
            int k = 1;
            while ( k < 32 && ((1 << k) & n) == 0 ) {
                k++;
            }
            // k is on 1 bit
            // unset k-th bit
            n = n & ~(1 << k);
            // set the k-1th bit
            n = n | (1 << k-1);
        }
        // LSB is 1
        else {
            int k = 1;
            while ( k < 32 && ((1 << k) & n) != 0 ) {
                k++;
            }
            // k is on 0 bit
            // unset k-1th bit
            n = n & ~(1 << k-1);
            // set the k-th bit
            n = n | (1 << k);
        }
//
//        // checks if two consecutive bits are different
//        int k = 0;
//        while ( k < 32 && (((1 << k) & n) == 0) != (( ((1 << k+1) & n) != 0) )) {
//            k++;
//        }
//
//        // all 0s or 1s!
//        if (k==32) {
//            return -1;
//        }
//
//        // and flips them
//        n = n ^ (1 << k);
//        n = n ^ (1 << k-1);

        // in one row
        // n = n ^ ( (1 << k) | (1 << k-1) )

        return n;
    }
}
