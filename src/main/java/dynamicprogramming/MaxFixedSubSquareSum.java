package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MaxFixedSubSquareSum {

    /**
     * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1301
     * which translates to:
     * Given a 2D array with positive integer values, find the subsquare of size k
     * which has the maximum value given by the sum of all its elements.
     */

    @Test
    public void test() {

        int[][] grid = new int[][]{
            { 1,  2,  1 , 4,  20, 5  },
            { 8,  3,  4 , 2,  1,  10 },
            { 3,  8,  10, 1,  11, 1  },
            { 4,  1,  1 , 7,  8,  5  },
            { 7,  1,  2 , 11, 9,  1  },
            { 5,  1,  0 , 3,  2,  1  }
        };
        int k = 3;
        assertEquals(60, maxSquare(grid, k));
        assertEquals(60, maxSquareOpt(grid, k));
    }

    private int maxSquareOpt(int[][] grid, int k) {

        int[][] rowSum = new int[grid.length][grid[0].length];
        int[][] colSum = new int[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            int row = 0;
            for (int j=0; j<grid[i].length; j++) {
                row += grid[i][j];
                if (j>=k) {
                    row -= grid[i][j-k];
                }
                rowSum[i][k] = row;
            }
        }

        for (int i=0; i<grid.length; i++) {
            int row = 0;
            for (int j=0; j<grid[i].length; j++) {
                row += grid[i][j];
                if (j>=k) {
                    row -= grid[i][j-k];
                }
                rowSum[i][k] = row;
            }
        }

//        int max = 0;
//        for (int i=0; i<grid[0].length-k; i++) {
//            for (int j=0; j<grid.length-k; j++) {
//                max += rows
//                if (i>=k) {
//                    col -= grid[j][i-k];
//                }
//                colSum[i][j] = col;
//            }
//        }

        int max = 0;
        for (int i=0; i<grid.length-k; i++) {
            for (int j=0; j<grid[i].length-k; j++) {
                //row += grid[i][j];
            }
        }


        return max;
    }


    private int maxSquare(int[][] grid, int k) {

        int max = 0;
        for (int i=0; i<grid.length-k; i++) {
            for (int j=0; j<grid[i].length-k; j++) {
                max = Math.max(max, squareSum(i, j, k, grid));
            }
        }

        return max;
    }

    private int squareSum(int row, int col, int k, int[][] grid) {
        int sum = 0;
        for (int i=0; i<k; i++) {
            for (int j=0; j<k; j++) {
                sum += grid[row+i][col+j];
            }
        }
        return sum;
    }
}
