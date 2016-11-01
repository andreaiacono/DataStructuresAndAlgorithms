package misc;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;


public class MatrixRotation {

    public static int[][] rotate(int[][] m) {
        int n = m.length;
        int[][] result = new int[n][n];
        for (int j = 0; j < n; j++) {
            int col = n - j - 1;
            for (int i = 0; i < n; i++) {
                result[i][col] = m[j][i];
            }
        }
        return result;
    }

    static void print(int[][] m) {
        int n = m.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print(m[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Test
    public void test() {
        int[][] m = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
//        print(m);
//        print(rotate(m));
//        print(res);
        assertTrue(Arrays.deepEquals(res, rotate(m)));

    }
}
