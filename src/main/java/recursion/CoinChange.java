package recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoinChange {

    @Test
    public void test() {

        int[] den = new int[]{1, 3, 5};
        assertEquals(3, coinChange(11, den));

        den = new int[]{1, 7, 13, 19};
        assertEquals(14, coinChange(206, den));

        den = new int[]{1, 7, 13, 19};
        int[] expected = new int[]{7, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19};
        assertTrue(Arrays.equals(expected, coinChangeWithResult(216, den)));
    }


    /**
     * returns the minimum number of coins for reaching the sum
     *
     * @param sum
     * @param v
     * @return
     */
    public int coinChange(int sum, int[] v) {

        int[] min = new int[sum + 1];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < v.length; j++) {
                if (v[j] <= i && min[i - v[j]] + 1 < min[i]) {
                    min[i] = min[i - v[j]] + 1;
                }
            }
        }

        return min[sum];
    }

    public int[] coinChangeWithResult(int value, int[] coins) {

        int[][] results = new int[value + 1][value];
        Arrays.fill(results, new int[] {Integer.MAX_VALUE});
        results[0] = new int[]{};

        for (int j = 1; j <= value; j++) {
            for (int c = 0; c < coins.length; c++) {
                if (coins[c] <= j && sum(results[j - coins[c]]) + 1 < sum(results[j])) {
                    int[] subResult = results[j - coins[c]];
                    int[] newResult = new int[subResult.length+1];
                    System.arraycopy(subResult, 0, newResult, 0, subResult.length);
                    newResult[subResult.length] = coins[c];
                    results[j] = newResult;
                }
            }
        }

        return results[value];
    }

    private int sum(int[] a) {
        return Arrays.stream(a).sum();
    }

}
