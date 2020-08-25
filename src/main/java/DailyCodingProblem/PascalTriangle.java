package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        getPascalTriangle2(10);
    }

    static List<List<Integer>> getPascalTriangle(int n) {
        // basic checks
        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        rows.add(first);
        for (int i=1; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> previousRow = rows.get(i-1);
            for (int j=1; j<previousRow.size(); j++) {
                int left = previousRow.get(j-1);
                int right = previousRow.get(j);
                int val = left + right;
                row.add(val);
            }
            row.add(1);
            rows.add(row);
            System.out.println(row);
        }
        return rows;
    }
    static int[][] getPascalTriangle2(int n) {
        // basic checks
        int[][] triangle = new int[n][n+1];
        triangle[0] = new int[1];
        triangle[0][0] = 1;
        for (int i=1; i<n; i++) {
            triangle[i] = new int[i+1];
            triangle[i][0] = 1;
            for (int j=1; j<i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
            triangle[i][i] = 1;
            System.out.println(Arrays.toString(triangle[n]));
        }
        return triangle;
    }
}
