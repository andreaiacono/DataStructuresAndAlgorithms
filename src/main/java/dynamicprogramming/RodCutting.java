package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RodCutting {

    @Test
    public void test() {
        System.out.println(waysToSum(5, new ArrayList<>(), 1));
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20};
        assertEquals(10, rodCutting(prices, 4));
        assertEquals(595, rodCutting(prices, 210)); //taking XXX minutes
        assertEquals(10, rodCuttingWithIndex(prices, 4, 1));
        assertEquals(595, rodCuttingWithIndex(prices, 210, 1)); // takes around 18s
        assertEquals(10, rodCuttingMemo(prices, 4, new int[5]));
        assertEquals(595, rodCuttingMemo(prices, 210, new int[211]));
    }

    int rodCutting(int[] prices, int l) {

        if (l == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (l - i >= 0) {
                result = Math.max(result, prices[i] + rodCutting(prices, l - i));
            }
        }

        return result;
    }

    int rodCuttingWithIndex(int[] prices, int l, int index) {

        if (l == 0) {
            return 0;
        }

        int result = 0;
        for (int i = index; i < prices.length; i++) {
            if (l - i >= 0) {
                result = Math.max(result, prices[i] + rodCuttingWithIndex(prices, l - i, i));
            }
        }

        return result;
    }


    int rodCuttingMemo(int[] prices, int l, int[] cache) {
        if (cache[l] != 0) {
            return cache[l];
        }

        if (l == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (l - i >= 0) {
                result = Math.max(result, prices[i] + rodCuttingMemo(prices, l - i, cache));
            }
        }
        cache[l] = result;
        return result;
    }

//    int rodCuttingDP(int[] prices, int l) {
//
//        // 1, 5, 8, 9, 10, 17, 17, 20
//        // 1 (1) = 1
//        // 2 (1+1, 2) = r[1] + p[2]
//        // 3 (1+1+1, 2+1, 3) = r[2] + r[1] + p[3]
//        // 4 (1+1+1+1, 1+1+2, 1+3, 2+2, 4) = r[3] + 1
//        // 5 (1+1+1+1, 4+1, 3+2, 3+1+1, 2+1+1+1) =
//    }

    List<List<Integer>> waysToSum(int n, List<Integer> partial, int index) {
        if (n == 0) {
            return List.of(new ArrayList<>(partial));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = index; i <= n; i++) {
            if (n - i >= 0) {
                partial.add(i);
                result.addAll(waysToSum(n - i, partial, i));
                partial.remove(partial.size() - 1);
            }
        }
        return result;
    }

}
