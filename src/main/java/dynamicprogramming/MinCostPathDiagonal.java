package dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

// Dynamic programming for coding interviews
// Example 8.1
public class MinCostPathDiagonal {

    @Test
    public void test() {
        int[][] cost = new int[][]
            {
                {1, 3, 5, 8},
                {4, 2, 1, 7},
                {4, 3, 2, 3}
            };
        int minCost = minCostPathDP(cost);
        Assert.assertEquals(7, minCost);
    }

    int minCostPathDP(int[][] cost) {
        for (int i=0; i<cost.length; i++) {
            for (int j=0; j<cost[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int up = (i > 0) ? cost[i - 1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? cost[i][j - 1] : Integer.MAX_VALUE;
                int diag = (i > 0 && j > 0) ? cost[i - 1][j - 1] : Integer.MAX_VALUE;
                cost[i][j] = Math.min(up, Math.min(left, diag)) + cost[i][j];
            }
        }
        System.out.println(Arrays.deepToString(cost));
        return cost[cost.length-1][cost[0].length-1];
    }
}
