package topcoder;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Knapsack {

    @Test
    public void test() {

        int capacity = 165;
        int[] weights = new int[]{23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int[] values = new int[]{92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        int[] result = new int[]{1, 1, 1, 1, 0, 1, 0, 0, 0, 0};

        assertTrue(Arrays.equals(result, knapsack(capacity, weights, values)));

        capacity = 26;
        weights = new int[]{12, 7, 11, 8, 9};
        values = new int[]{24, 13, 23, 15, 16};
        result = new int[]{0, 1, 1, 1, 0};

        assertTrue(Arrays.equals(result, knapsack(capacity, weights, values)));

        capacity = 190;
        weights = new int[]{56, 59, 80, 64, 75, 17};
        values = new int[]{50, 50, 64, 46, 50, 5};
        result = new int[]{1, 1, 0, 0, 1, 0};

        assertTrue(Arrays.equals(result, knapsack(capacity, weights, values)));
    }

    private int[] knapsack(int capacity, int[] weights, int[] values) {

        return null;

    }
}
