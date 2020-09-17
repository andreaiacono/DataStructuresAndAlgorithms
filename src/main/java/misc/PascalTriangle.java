package misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PascalTriangle {

    @Test
    public void test() {
        int[][] pascal = pascal(10);
        assertEquals(10, pascal.length);
        assertTrue(Arrays.equals(pascal[5], new int[] {1, 5, 10, 10, 5, 1 } ));
        System.out.println(Arrays.deepToString(pascal));
    }

    int[][] pascal(int n) {

        int[][] result = new int[n][];
        result[0] = new int[]{1};

        for (int i = 1; i < n; i++) {
            result[i] = new int[i+1];
            for (int j = 0; j < i + 1; j++) {
                result[i][j] = (j>0 ? result[i - 1][j-1] : 0) + (j < i ? result[i - 1][j] : 0);
            }
        }

        return result;
    }
}
