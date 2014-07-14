package misc;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 14/07/14
 * Time: 17.12
 */

import java.util.Arrays;

/**
 * Write a program that given 4 coin denominations and a dollar amount finds the best way to express that amount
 * using the coins given. I.e. you have coins with denominations of 1c, 7c, 13c,19c and you have to express $2.12
 * with the least number of coins. There is always a 1c coin but the other 3 are arbitrary.
 */
public class CurrencyDenominations {

    static int min  = Integer.MAX_VALUE;
    static int[] minValues;

    public static void main(String[] args) {

        int[] den = new int[]{1, 7, 13, 19};
        int[] values = new int[den.length];
        int amount = 212;

        printAll(0, den, amount, values);
        System.out.println(Arrays.toString(minValues));
    }

    public static void printAll(int index, int[] denominations, int amount, int[] vals) {

        if (amount == 0) {
            int sum =0;
            for (int j=0; j<vals.length; j++) {
                sum+=vals[j];
            }
            if (sum < min) {
                min = sum;
                minValues = Arrays.copyOf(vals, vals.length);
            }
            return;
        }

        if (index == denominations.length) return;

        int currentDenomination = denominations[index];
        for (int i = 0; i <= (amount / currentDenomination); i++) {
            vals[index] = i;
            printAll(index + 1, denominations, amount - i * currentDenomination, vals);
        }
    }
}
