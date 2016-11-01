package misc;

import java.util.BitSet;

public class BinaryOps {
    public static void main(String[] args) {

        int n = 13;
        System.out.println("Ones of " + n + "=" + getOnesNumber(n));
        System.out.println("BinaryOnes of " + n + "=" + binaryGetOnesNumber(n));
        BitSet bitSet = new BitSet(64);
//        bitSet.
    }

    public static int  getOnesNumber(int n) {
        int counter = 0;
        while (n> 0) {
            if (n%2 != 0) counter++;
            n/=2; // or n >> 2
        }
        return counter;
    }

    public static int binaryGetOnesNumber(int n) {
        int counter = 0;
        for (int j=0; j<32; j++) {
            if (((n>>j) & 1) == 1) counter++;
        }
        return counter;
    }
}
