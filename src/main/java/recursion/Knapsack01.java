package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Knapsack01 {


    /**
     * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum
     * total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which
     * represent values and weights associated with n items respectively. Also given an integer W which represents
     * knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset
     * is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t
     * pick it (0-1 property).
     */

    @Test
    public void test() {

        int[] v = new int[]{60, 100, 120};
        int[] w = new int[]{10, 20, 30};
        int capacity = 50;

        assertEquals(220, knapsack01(v, w, capacity));

    }

    int knapsack01(int[] v, int[] w, int capacity) {

        // checks for null, equals size of arrays, values, weights and capacity > 0
        return knapsack01(v, w, capacity, 0, 0);
    }

    int knapsack01(int[] v, int[] w, int capacity, int amount, int index) {
        if (capacity == 0) {
            return amount;
        }

        int max = 0;
        for (int i = index; i < v.length; i++) {
            if (capacity >= w[i]) {
                max = Math.max(max, knapsack01(v, w, capacity - w[i], amount + v[i], i + 1));
            }
        }
        return max;
    }


}
