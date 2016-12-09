package pramp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Sudoku {

    @Test
    public void test() {
        int[][] s = new int[][]{
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        assertTrue(sudokuCheck(s));
        assertTrue(solveSudoku(s, 0));
    }

    public boolean check(int[][]board, int value, int x, int y){
        for(int i = 0; i < 9; i++){
            if(board[i][x] == value){
                return false;
            }
            if(board[y][i] == value){
                return false;
            }
        }

        for(int i = x / 3 * 3; i < (x / 3 + 1) * 3; i++){
            for(int j = y / 3* 3; j < (y / 3 + 1) * 3; j++){
                if(x != i && y != j && board[i][j] == value){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solveSudoku(int[][] board, int position) {
        boolean result = true;
        int x = position / 9;
        int y = position % 9;
        for(int i = x; i < 9; i++){
            int start = i == x ? y : 0;
            for(int j = start; j < 9; j++){
                if(board[i][j] == 0){
                    for(int val = 1; val <= 9; val++){
                        if (check(board, val, i, j)) {
                            board[i][j] = val;
                            if (solveSudoku(board, i * 9 + j + 1)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }



    public boolean sudokuCheck(int[][] s) {
        return check(s, 0);
    }

    private boolean check(int[][] s, int index) {

        if (index > 80) {
            return true;
        }
        int row = index / 9;
        int col = index % 9;

        if (s[row][col] == 0) {

            int[] legalValues = getLegalValues(s, row, col);
            for (int value : legalValues) {
                s[row][col] = value;
                if (check(s, index + 1)) {
                    return true;
                }
            }
            s[row][col] = 0;
            return false;
        }

        return check(s, index + 1);
    }

    private int[] getLegalValues(int[][] s, int row, int col) {
        int[] values = new int[9];
        int counter = 0;
        int subrow = (row / 3) * 3 + 1;
        int subcol = (col / 3) * 3 + 1;

        // tries all the values
        for (int value = 1; value < 10; value++) {
            boolean isPresent = false;
            for (int j = 0; j < 9; j++) {
                if (s[row][j] == value) {
                    isPresent = true;
                    break;
                }
                if (s[j][col] == value) {
                    isPresent = true;
                    break;
                }
                int sx = j % 3 - 1;
                int sy = j / 3 - 1;

                if (s[subrow + sx][subcol + sy] == value) {
                    isPresent = true;
                    break;
                }
            }

            if (!isPresent) {
                values[counter++] = value;
            }
        }

        if (counter == 0) {
            return new int[0];
        }

        return Arrays.copyOf(values, counter);
    }

//    void print(int[][]s) {
//        for (int j=0; j<9; j++) {
//            for (int i=0; i<9; i++) {
//                System.out.print(s[j][i] + "|");
//                if (i % 3 == 2) {
//                    System.out.print(" ");
//                }
//            }
//            if (j % 3 == 2) {
//                System.out.println("\n--------------------");
//            }
//            else {
//                System.out.println();
//            }
//        }
////        System.out.println();
//    }
}
