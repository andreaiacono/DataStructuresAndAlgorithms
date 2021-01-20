package codejam;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumCoins {

    static String input = "2\n" +
            "3\n" +
            "1 2 5\n" +
            "3 6 -1\n" +
            "12 2 7\n" +
            "5\n" +
            "0 0 0 0 0\n" +
            "1 1 1 1 0\n" +
            "2 2 2 8 0\n" +
            "1 1 1 0 0\n" +
            "0 0 0 0 0";

    public static void main(String[] args) {
//      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[][] cells = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    cells[j][k] = in.nextInt();
                }
            }
            int result = maxCoins(cells);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static int maxCoins(int[][] cells) {
        int n = cells.length;
        int max = readDiagonal(0, 0, cells, n);

        for (int i = 0; i < n; i++) {
            max = Math.max(max, readDiagonal(0, i, cells, n));
            max = Math.max(max, readDiagonal(i, 0, cells, n));
        }

        return max;
    }


    private static int readDiagonal(int row, int col, int[][] cells, int n) {
        int tmpMax = 0;
        int max = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int i = 0;

        while (row+i < n && col+i < n) {
            tmpMax += cells[row + i][col + i];
            tmpMax = Math.max(0, tmpMax);
            max = Math.max(tmpMax, max);
            maxValue = Math.max(maxValue, cells[row + i][col + i]);
            i++;
        }

        if (maxValue < 0) {
            return maxValue;
        }
        return max;
    }


}
