package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

        int[] coins = new int[]{10, 50, 100, 500};
        int[] qty = new int[]{5, 3, 2, 2};

        Set<Long> result = new HashSet<Long>() {{
            add(0L);
            add(1280L);
            add(770L);
            add(260L);
            add(1030L);
            add(520L);
            add(10L);
            add(1290L);
            add(780L);
            add(270L);
            add(1040L);
            add(530L);
            add(20L);
            add(1300L);
            add(790L);
            add(280L);
            add(1050L);
            add(540L);
            add(30L);
            add(1310L);
            add(800L);
            add(290L);
            add(1060L);
            add(550L);
            add(40L);
            add(1320L);
            add(810L);
            add(300L);
            add(1070L);
            add(560L);
            add(50L);
            add(1330L);
            add(820L);
            add(310L);
            add(1080L);
            add(570L);
            add(60L);
            add(1340L);
            add(830L);
            add(320L);
            add(1090L);
            add(580L);
            add(70L);
            add(1350L);
            add(840L);
            add(330L);
            add(1100L);
            add(590L);
            add(80L);
            add(1360L);
            add(850L);
            add(340L);
            add(1110L);
            add(600L);
            add(90L);
            add(1370L);
            add(860L);
            add(350L);
            add(1120L);
            add(610L);
            add(100L);
            add(1380L);
            add(870L);
            add(360L);
            add(1130L);
            add(620L);
            add(110L);
            add(1390L);
            add(880L);
            add(370L);
            add(1140L);
            add(630L);
            add(120L);
            add(1400L);
            add(890L);
            add(380L);
            add(1150L);
            add(640L);
            add(130L);
            add(900L);
            add(390L);
            add(1160L);
            add(650L);
            add(140L);
            add(400L);
            add(1170L);
            add(660L);
            add(150L);
            add(1180L);
            add(670L);
            add(160L);
            add(1190L);
            add(680L);
            add(170L);
            add(1200L);
            add(690L);
            add(180L);
            add(1210L);
            add(700L);
            add(190L);
            add(1220L);
            add(710L);
            add(200L);
            add(1230L);
            add(720L);
            add(210L);
            add(1240L);
            add(730L);
            add(220L);
            add(1250L);
            add(740L);
            add(230L);
            add(1000L);
            add(1260L);
            add(750L);
            add(240L);
            add(1010L);
            add(500L);
            add(1270L);
            add(760L);
            add(250L);
            add(1020L);
            add(510L);
        }};
        assertEquals(result, allCoinChanges(coins, qty));
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
        Arrays.fill(results, new int[]{Integer.MAX_VALUE});
        results[0] = new int[]{};

        for (int j = 1; j <= value; j++) {
            for (int c = 0; c < coins.length; c++) {
                if (coins[c] <= j && sum(results[j - coins[c]]) + 1 < sum(results[j])) {
                    int[] subResult = results[j - coins[c]];
                    int[] newResult = new int[subResult.length + 1];
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

    static Set<Long> allCoinChanges(int[] coins, int[] qty) {

        int n = Arrays.stream(qty).sum();
        int[] flattedCoins = new int[n + 1];
        int index = 0;

        for (int i = 0; i < qty.length; i++) {
            for (int j = 0; j < qty[i]; j++) {
                flattedCoins[index++] = coins[i];
            }
        }

        Set<Long> result = new HashSet<>();
        for (int i = 0; i < (1 << n); i++) {

            long sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += flattedCoins[j];
                }
            }

            result.add(sum);
        }

        return result;
    }

}
