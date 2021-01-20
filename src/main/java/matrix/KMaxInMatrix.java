package matrix;

import org.junit.Test;

import java.util.PriorityQueue;

import static junit.framework.TestCase.assertEquals;

public class KMaxInMatrix {

    /**
     * Given an N * N matrix where each row and column is sorted in ascending order, find the K-th smallest
     * element in the matrix.
     */

    @Test
    public void test() {
        int[][] m = new int[][]{
                {2, 6, 8},
                {3, 7, 10},
                {5, 8, 11}
        };

        assertEquals(7, topKBruteForce(m, 5));
        assertEquals(7, topK(m, 5));
    }

    // O(nk + k log(n))
    int topK(int[][] m, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int maxCol = Math.min(k, m.length);
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<maxCol; j++) {
                heap.add(m[i][j]);
            }
        }

        int result = 0;
        for (int i=0; i<k; i++) {
            result = heap.poll();
        }

        return result;
    }

    // O(n^2 + k log(n))
    int topKBruteForce(int[][] m, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[i].length; j++) {
                heap.add(m[i][j]);
            }
        }

        int result = 0;
        for (int i=0; i<k; i++) {
            result = heap.poll();
        }

        return result;
    }

}
