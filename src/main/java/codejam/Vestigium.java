package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Vestigium {

    static String input = "3\n" +
            "4\n" +
            "1 2 3 4\n" +
            "2 1 4 3\n" +
            "3 4 1 2\n" +
            "4 3 2 1\n" +
            "4\n" +
            "2 2 2 2\n" +
            "2 3 2 3\n" +
            "2 2 2 3\n" +
            "2 2 2 2\n" +
            "3\n" +
            "2 1 3\n" +
            "1 3 2\n" +
            "1 2 3\n";


    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            String result = vestigium(matrix, size);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String vestigium(int[][] matrix, int size) {
        int trace = trace(matrix);
        int rows = 0;
        int cols = 0;

        for (int i = 0; i < size; i++) {
            Set<Integer> map = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!map.contains(matrix[i][j])) {
                    map.add(matrix[i][j]);
                }
                else {
                    rows ++;
                    break;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            Set<Integer> map = new HashSet<>();
            for (int j = 0; j < size; j++) {
                if (!map.contains(matrix[j][i])) {
                    map.add(matrix[j][i]);
                }
                else {
                    cols ++;
                    break;
                }
            }
        }
        return "" + trace + " " + rows + " " + cols;
    }

    private static int trace(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }


}
