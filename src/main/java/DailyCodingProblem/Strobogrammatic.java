package DailyCodingProblem;

import java.sql.*;
import java.util.*;

public class Strobogrammatic {

    /**
     * A strobogrammatic number is a positive number that appears the same after being rotated 180 degrees.
     * For example, 16891 is strobogrammatic.
     *
     * Create a program that finds all strobogrammatic numbers with N digits.
     */

    static Map<Integer, Integer> strobo = new HashMap<>() {{
        put(0, 0);
        put(1, 1);
        put(2, -1);
        put(3, -1);
        put(4, -1);
        put(5, -1);
        put(6, 9);
        put(7, -1);
        put(8, 8);
        put(9, 6);
    }};

    public static void main(String[] args) {
        /**
         * Result:
         * strobo[2]= 4
         * strobo[3]= 12
         * strobo[4]= 20
         * strobo[5]= 60
         * strobo[6]= 100
         * strobo[7]= 300
         * strobo[8]= 500
         * strobo[9]= 1500
         */
        int n = 9;
        for (int k=2; k<n; k++) {
            int count = 0;
            for (int i = (int) Math.pow(10, k - 1); i < (int) Math.pow(10, k); i++) {
                if (isStrobo(i, k)) {
                    count ++;
//                    System.out.println(i);
                }
            }
            System.out.println("strobo[" + k + "]= " + count);
        }
    }

    private static boolean isStrobo(int n, int size) {
        int[] digits = new int[size];
        int index = size-1;
        while (n>0) {
            digits[index--] = n % 10;
            n = n / 10;
        }

        for (int i=0; i<size/2+1; i++) {
            if (digits[i] != strobo.get(digits[size-1-i]) || strobo.get(digits[i]) == -1 ) {
                return false;
            }
        }
        return true;
    }
}
