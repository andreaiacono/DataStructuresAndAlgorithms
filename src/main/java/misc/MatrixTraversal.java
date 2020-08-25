package misc;

import org.junit.Test;
import util.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MatrixTraversal {

    /**
     * given a matrix, return minimum cost from [0,0] to [n - 1, m - 1], for each point
     * you can move 4 directions(up, down, left, right) and if the value of two adjacent
     * is same, cost is 0, otherwise cost is 1
     */

    /**
     * my notes
     * - why also up and left? Min number of steps is only using right and down, so using the
     *   other two will be equal or worse (since we have positive costs)
     * - model it as a graph using dijkstra algorithm
     * - make recursive approach
     * - add memoization
     * - DP approach
     */
    @Test
    public void test() {
        int[][] m = new int[][] { {1, 2, 3}, {2, 4, 3}, {1, 4, 3}  };
        int[][] cache = new int[m.length][m[0].length];
        assertEquals(2, minCostPath(m, 2, 2, cache));
        assertEquals(2, minCostPathDP(m));
    }

    int minCostPath(int[][] m, int x, int y, int[][] cache) {

        if (x == 0 && y == 0) {
            return 0;
        }

        if (cache[x][y] != 0) {
            return cache[x][y];
        }
        int result = Integer.MAX_VALUE;
        if (x > 0) {
            result = Math.min(result, (m[x][y] != m[x-1][y] ? 1 : 0) + minCostPath(m, x-1, y, cache));
        }
        if (y > 0) {
            result = Math.min(result, (m[x][y] != m[x][y-1] ? 1 : 0) + minCostPath(m, x, y-1, cache));
        }
        cache[x][y] = result;
        return result;
    }

    int minCostPathDP(int[][] m) {
        int[][] costs = new int[m.length][m[0].length];
        for (int i=0; i< m.length; i++) {
            for (int j=0; j<m[0].length; j++) {
                if (i==0 && j==0) {
                    continue;
                }
                if (i==0) {
                    costs[0][j] = costs[0][j-1] + (m[0][j-1] == m[0][j] ? 0 : 1);
                }
                else if (j==0) {
                    costs[i][0] = costs[i-1][0] + (m[i-1][0] == m[i][0] ? 0 : 1);
                }
                else {
                    int fromLeft = costs[i][j-1] + (m[i][j-1] == m[i][j] ? 0 : 1);
                    int fromUp =  costs[i-1][j] + (m[i-1][j] == m[i][j] ? 0 : 1);
                    costs[i][j] = Math.min(fromLeft, fromUp);
                }
            }
        }
        return costs[m.length-1][m[0].length-1];
    }

    /**
     * +----+----+----+
     * |  1 |  2 | 3  |
     * +----+----+----+
     * |  4 |  2 | 3  |
     * +----+----+----+
     * |  1 |  4 | 3  |
     * +----+----+----+
     *
     *      * +----+----+----+
     *      * |  0 |  1 | 2  |
     *      * +----+----+----+
     *      * |  1 |  1 | 2  |
     *      * +----+----+----+
     *      * |  2 |  2 | 2  |
     *      * +----+----+----+
     */
}