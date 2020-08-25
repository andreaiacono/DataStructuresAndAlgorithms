package dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

// Dynamic programming for coding interviews
// Example 8.1
public class MinCostPath {

    @Test
    public void test() {
        int[][] cost = new int[][]
            {
                {1, 3, 5, 8},
                {4, 2, 1, 7},
                {4, 3, 2, 3}
            };
        int minCost = minCostPathDP(cost);
//        int minCost = minCostPath(cost, cost.length-1, cost[0].length-1);
//        int minCost = minCostPathFromTopLeft(cost, 0, 0);
        System.out.println("Cost: " + minCost + " - Calls: " + counter + " - Calls without cache: " + cache_counter);
        Assert.assertEquals(12, minCost);
    }

    int counter = 0;
    int cache_counter = 0;
    int[][] cache = new int[3][4];

    int minCostPathDP(int[][] cost) {
        for (int i=0; i<cost.length; i++) {
            for (int j=0; j<cost[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int up = (i > 0) ? cost[i - 1][j] : Integer.MAX_VALUE;
                int left = (j > 0) ? cost[i][j - 1] : Integer.MAX_VALUE;
                System.out.println("i="+i+", j="+j+" up="+up+" left=" +left);
                cost[i][j] = Math.min(up, left) + cost[i][j];
            }
        }
        System.out.println(Arrays.deepToString(cost));
        return cost[cost.length-1][cost[0].length-1];
    }

    int minCostPath(int[][] cost, int row, int col) {
        cache_counter++;
        if (cache[row][col] > 0) {
            return cache[row][col];
        }
        counter++;
        if (row == 0 && col == 0) {
            return cost[row][col];
        }

        int minDown = row > 0 ? minCostPath(cost, row - 1, col) + cost[row][col] : Integer.MAX_VALUE;
        int minRight = col > 0 ? minCostPath(cost, row, col - 1) + cost[row][col] : Integer.MAX_VALUE;
        cache[row][col] = Math.min(minRight, minDown);
        return cache[row][col];
    }

    // this is without cache (but it can work with cache)
    int minCostPathFromBottomRight(int[][] cost, int row, int col) {
        if (row == 0 && col == 0) {
            return cost[row][col];
        }
        int minDown = row > 0 ? minCostPathFromBottomRight(cost, row - 1, col) + cost[row][col] : Integer.MAX_VALUE;
        int minRight = col > 0 ? minCostPathFromBottomRight(cost, row, col - 1) + cost[row][col] : Integer.MAX_VALUE;
        return Math.min(minRight, minDown);
    }

    // this one cannot work with cache
    int minCostPathFromTopLeft(int[][] cost, int row, int col) {
        if (row == cost.length - 1 && col == cost[0].length - 1) {
            return cost[row][col];
        }
        int minDown = row < cost.length - 1 ? minCostPathFromTopLeft(cost, row + 1, col) + cost[row][col] : Integer.MAX_VALUE;
        int minRight = col < cost[0].length - 1 ? minCostPathFromTopLeft(cost, row, col + 1) + cost[row][col] : Integer.MAX_VALUE;
        return Math.min(minRight, minDown);
    }
}
