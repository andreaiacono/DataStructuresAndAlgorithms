package matrix;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.assertEquals;

public class MaxRectangle {



    @Test
    public void test() {

        /**
         * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
         */

        int[][] rect = new int[][]{
                {1, 1, 1},
                {0, 1, 1},
                {1, 0, 0}
        };

        assertEquals(4, maxRectangle(rect));
    }

    private int maxRectangle(int[][] rect) {

        int max = 0;
        for (int i = 0; i < rect.length; i++) {
            for (int j = 0; i < rect[i].length; j++) {
                if (rect[i][j] == 1) {
                    max = Math.max(max, getMaxRectangle(rect, i, j));
                }
            }
        }
        return max;
    }

    int getMaxRectangle(int[][] rect, int row, int col) {

        int maxWidth = 0;
        while (col < rect[row].length && rect[row][col] == 1) {
            col ++;
        }
        return 0;
    }

}
