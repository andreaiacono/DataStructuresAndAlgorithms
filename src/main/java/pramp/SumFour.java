package pramp;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class SumFour {

    @Test
    public void test() {
        double[] vals = new double[]{-2.5, 0, 11.3, 41, 0.5, 1.7, 3.14, 2.1727, -3.7};
        int sum = 11;
        int[] result = new int[]{0, 2, 4, 5};
        assertTrue(Arrays.equals(result, findSums(vals, sum)));
//        assertTrue(Arrays.equals(result, quadCombination(vals, sum)));


        vals = new double[]{1, 2, 3, 4, 1, 2};
        sum = 6;
        result = new int[]{0, 1, 4, 5};
        assertTrue(Arrays.equals(result, findSums(vals, sum)));
//        assertTrue(Arrays.equals(result, quadCombination(vals, sum)));

        vals = new double[]{1, 2, 3, 4, 5, 6};
        sum = 14;
        result = new int[]{0, 1, 2, 5};
//        assertTrue(Arrays.equals(result, findSums(vals, sum)));
        System.out.println(Arrays.toString(quadCombination(vals, sum)));
        assertTrue(Arrays.equals(result, quadCombination(vals, sum)));

        vals = new double[]{1, 2, 3, 4};
        sum = 10;
        result = new int[]{0, 1, 2, 3};
        assertTrue(Arrays.equals(result, findSums(vals, sum)));
        assertTrue(Arrays.equals(result, quadCombination(vals, sum)));
    }

    public int[] quadCombination(double[] arr, int S) {
        if(arr == null || arr.length < 4) {
            return null;
        }

        HashMap<Double, Integer[]> map = new HashMap<>();

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                map.put(arr[i] + arr[j], new Integer[]{i, j});
            }
        }

        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                double complementSum = S - (arr[i] + arr[j]);
                Integer[] indices = map.get(complementSum);
                if(map.containsKey(complementSum) && indices[0] != i && indices[0] != j && indices[1] != i && indices[1] != j) {
                    return new int[]{i, j, indices[0], indices[1]};
                }
            }
        }
        return null;
    }

    class Pair {

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int[] findSums(double[] vals, int sum) {
        int n = vals.length;
        Map<Double, List<Pair>> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double partialSum = vals[i] + vals[j];
                if (!map.containsKey(partialSum)) {
                    map.put(partialSum, new ArrayList<>());
                }
                map.get(partialSum).add(new Pair(i, j));
            }
        }

        for (Double partialSum : map.keySet()) {
            if (map.containsKey(sum - partialSum)) {
                List<Pair> firstPairs = map.get(partialSum);
                List<Pair> secondPairs = map.get(sum - partialSum);
                int[] result = getUniqueIndices(firstPairs, secondPairs);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    int[] getUniqueIndices(List<Pair> firstPairs, List<Pair> secondPairs) {

        for (int i = 0; i < firstPairs.size(); i++) {
            for (int j = 0; j < secondPairs.size(); j++) {
                Pair firstPair = firstPairs.get(i);
                Pair secondPair = secondPairs.get(j);
                if (firstPair.first != secondPair.first && firstPair.first != secondPair.second &&
                        firstPair.second != secondPair.first && firstPair.second != secondPair.second) {
                    int[] result = new int[]{firstPair.first, firstPair.second, secondPair.first, secondPair.second};
                    Arrays.sort(result);
                    return result;
                }
            }
        }
        return null;
    }
}
