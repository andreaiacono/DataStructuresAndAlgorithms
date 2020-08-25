package dynamicprogramming;

import org.junit.Test;

// Dynamic programming for coding interviews
// Example 9.2
public class TotalPathCount {

    @Test
    public void test() {
        int row = 20;
        int col = 30;
        long tot = totalPathCount(row, col, new long[row+1][col+1]);
        System.out.println("total=" + tot);
        assert tot == 11541847896480L;

        tot = totalPathCountDp(row, col);
        assert tot == 11541847896480L;
    }

    long totalPathCount(int row, int col) {

        if (row == 1 && col == 1) {
            return 1;
        }

        long up = row == 1 ? 0 : totalPathCount(row - 1, col);
        long left = col == 1 ? 0 : totalPathCount(row, col - 1);

        return up + left;
    }

    long totalPathCount(int row, int col, long[][] cache) {

        if (cache[row][col] > 0) {
            return cache[row][col];
        }

        if (row == 1 && col == 1) {
            return 1;
        }

        long up = row == 1 ? 0 : totalPathCount(row - 1, col, cache);
        long left = col == 1 ? 0 : totalPathCount(row, col - 1, cache);

        cache[row][col] = up + left;
        return cache[row][col];
    }


    long totalPathCountDp(int row, int col) {
        long[][] grid = new long[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i ==0 || j == 0) {
                    grid[i][j] = 1;
                }
                else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[row-1][col-1];
    }

}
