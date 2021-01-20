package codejam;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        long t = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= t; ++i) {
            String result = sums(in.nextLong());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static String sums(long n) {
        long left = 1;
        long right = n - 1;

        while (left < right) {
            int leftDigit = contains4(left);
            int rightDigit = contains4(right);

            if (leftDigit == -1 && rightDigit == -1) {
                return (left + " " + right);
            }
            long skip = (long) Math.pow(10.0, Math.max(leftDigit, rightDigit));
            left +=  skip;
            right -= skip;
        }
        return "no value found";
    }

    static int contains4(long n) {
        int digitPos = 0;
        while (n > 0) {
            if (n % 10 == 4) {
                return digitPos;
            }
            n /= 10;
            digitPos++;
        }
        return -1;
    }
}