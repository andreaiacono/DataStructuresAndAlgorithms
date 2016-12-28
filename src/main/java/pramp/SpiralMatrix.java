package pramp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SpiralMatrix {

    @Test
    public void test() {

        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        int[] result = new int[]{1, 2, 4, 3};
        assertTrue(Arrays.equals(result, spiral(matrix)));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
        result = new int[]{1, 2, 3, 6, 5, 4};
        assertTrue(Arrays.equals(result, spiral(matrix)));

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        result = new int[]{1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7};
        assertTrue(Arrays.equals(result, spiral(matrix)));
    }

    int[] spiral(int[][] m) {

        int[] result = new int[m.length * m[0].length];
        int resultIndex = 0;

        int cols = m[0].length;
        int rows = m.length;

        int topRow = 0;
        int bottomRow = rows-1;
        int leftCol = 0;
        int rightCol = cols-1;

        while (leftCol <= rightCol && topRow <= bottomRow) {

            // left -> right
            for (int i = leftCol; i <= rightCol; i++) {
                result[resultIndex++] = m[topRow][i];
            }
            topRow++;

            // top -> bottom
            for (int i = topRow; i <= bottomRow; i++) {
                result[resultIndex++] = m[i][rightCol];
            }
            rightCol--;

            // right -> left
            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    result[resultIndex++] = m[bottomRow][i];
                }
                bottomRow--;
            }

            // bottom -> top
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    result[resultIndex++] = m[i][leftCol];
                }
                leftCol++;
            }
        }

        System.out.println("Matrix: " + Arrays.deepToString(m) + "\nResult: " + Arrays.toString(result) + "\n");
        return result;
    }
}
