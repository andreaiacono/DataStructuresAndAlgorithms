package dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTravel {


    @Test
    public void test() {
        char mat[][] = new char[][]
                {
                        {'P', 'P', 'P'},
                        {'P', 'P', 'P'},
                        {'P', 'P', 'P'}
                };
        assertEquals(6, countRobotPaths(mat));

        mat = new char[][]
                {
                        {'P', 'P', 'P'},
                        {'P', 'W', 'P'},
                        {'P', 'P', 'P'}
                };
        assertEquals(2, countRobotPaths(mat));

        mat = new char[][]
                {
                        {'P', 'P', 'P'},
                        {'P', 'P', 'P'},
                        {'P', 'W', 'P'}
                };
        assertEquals(3, countRobotPaths(mat));
    }

    int countRobotPaths(char[][] mat) {

        int[][] counts = new int[mat.length][mat[0].length];
        counts[0][0] = 1;
        for (int r=0; r<mat.length; r++) {
            for (int c=0; c<mat[0].length; c++) {
                if (r > 0 && c > 0) {
                    counts[r][c] = (mat[r-1][c] == 'P' ? counts[r-1][c] : 0) + (mat[r][c-1] == 'P' ? counts[r][c-1] : 0);
                }
                else if (c > 0) {
                    counts[r][c] = mat[r][c-1] == 'P' ? counts[r][c-1] : 0;
                }
                else if (r > 0) {
                    counts[r][c] = mat[r-1][c] == 'P' ? counts[r-1][c] : 0;
                }
            }
        }

        return counts[mat.length-1][mat[0].length-1];
    }

}
