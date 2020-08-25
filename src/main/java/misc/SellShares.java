package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SellShares {

    @Test
    public void test() {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(8, sellShares(values));

        values = new int[]{9, 5, 3, 1};
        assertEquals(0, sellShares(values));

        values = new int[]{5, 15, 3};
        assertEquals(10, sellShares(values));

        values = new int[]{5, 15, 3, 20};
        assertEquals(17, sellShares(values));

        values = new int[]{15, 3, 20};
        assertEquals(17, sellShares(values));

        values = new int[]{7, 1, 5, 3, 6, 4};
        assertEquals(5, sellShares(values));
    }

    int sellShares(int[] prices) {

        // check length

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int price: prices) {
            min = Math.min(price, min);
            max = Math.max(max, price - min);
        }

        return max;
//
//        // kadane
//        int max = 0;
//        int current = 0;
//        int index = 0;
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] - prices[index] > current) {
//                current = prices[i] - prices[index];
//            } else {
////                current = 0;
//                index = i;
//            }
//            max = Math.max(max, current);
//        }
//
//        return max;


    }
}
