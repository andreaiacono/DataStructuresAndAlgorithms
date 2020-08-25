package hackerrank;

import java.math.BigInteger;

public class SquaredFibonacci {


    public static void main(String[] args) {
        System.out.println(fibonacciModified(1, 2, 10));
    }

    static String fibonacciModified(int t1, int t2, int n) {

        BigInteger first = new BigInteger("" + t1);
        BigInteger secondSquared;
        BigInteger second = new BigInteger("" + t2);
        BigInteger result = new BigInteger(first.toString()).add(second.multiply(second));
        int current = 1;
        while (current < n - 2) {
            System.out.println("first: " + first.toString() + " - second: " + second.toString() + " - result: "
                    + result.toString());
            first = second;
            second = result;
            secondSquared = result.multiply(result);
            result = new BigInteger(first.toString()).add(secondSquared);
            current++;
        }

        return result.toString();
    }

}
