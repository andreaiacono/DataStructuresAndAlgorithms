package misc;

import java.util.HashMap;
import java.util.Map;

public class TwoSquaresSum {

    /**
     * Given an array A of 􏰅 elements. Find three elements i, j and k 􏰢 in the array
     * such that A[i]􏰪^2 + A[j]^2􏰪 = A[k]􏰪^2?
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] items = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] result = twoSumSquare(items);
        if (result == null) {
            System.out.println("Impossible");
        }
        else {
            System.out.println(items[result[0]] + "^2 + " + items[result[1]] + "^2 = " + items[result[2]] + "^2");
        }
    }

    private static int[] twoSumSquare(int[] items) {
        int counter = items.length-1;

        while (counter > 0) {

            int k = items[counter] * items[counter];
            int[] local = twoSumSquare(k, counter, items);
            if (local != null) {
                return new int[] {local[0], local[1], counter};
            }
            counter --;
        }

        return null;
    }

    private static int[] twoSumSquare(int k, int idxK, int[] items) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<items.length; i++) {
            if (i == idxK) {
                break;
            }
            if (map.containsKey(items[i]*items[i])) {
                return new int[] { map.get(items[i]*items[i]), i};
            }
            else {
                map.put(k-items[i]*items[i], i);
            }
        }
        return null;
    }
}
