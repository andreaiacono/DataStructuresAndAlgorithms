package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    @Test
    public void test() {

        List<Character> r1 = Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.');
        List<Character> r2 = Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.');
        List<Character> r3 = Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.');
        List<Character> r4 = Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3');
        List<Character> r5 = Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1');
        List<Character> r6 = Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6');
        List<Character> r7 = Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.');
        List<Character> r8 = Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5');
        List<Character> r9 = Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9');

        ArrayList<List<Character>> a = new ArrayList<>();
        a.add(r1);
        a.add(r2);
        a.add(r3);
        a.add(r4);
        a.add(r5);
        a.add(r6);
        a.add(r7);
        a.add(r8);
        a.add(r9);

        solveSudoku(a);
        System.out.println(a);
    }

    public void solveSudoku(ArrayList<List<Character>> a) {
        sudoku(a, 0);
    }

    boolean sudoku(ArrayList<List<Character>> a, int position) {

//        System.err.println(a);

        if (position == 81) {
            return true;
        }

        int row = position / 9;
        int col = position % 9;

        if (a.get(row).get(col) == '.') {
            List<Character> legalMoves = getLegalMoves(a, row, col);
            for (Character c : legalMoves) {
                a.get(row).set(col, c);
                // System.out.println("i=" + i + " j=" + j + " c=" + c + " pos= " + position);
                // System.out.println(a);
                if (sudoku(a, position + 1)) {
                    return true;
                }
            }
            a.get(row).set(col, '.');

            return false;
        }

        return sudoku(a, position +1);
    }

    List<Character> getLegalMoves(ArrayList<List<Character>> a, int row, int col) {

        List<Character> moves = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if ((char) (i + 1) != a.get(row).get(col)) {
                moves.add((char) (49 + i));
            }
        }

        for (int i = 0; i < 9; i++) {
            Character c = (char) (a.get(i).get(col));
            if (c != '.') {
                moves.remove(c);
            }
            c = (char) (a.get(row).get(i));
            if (c != '.') {
                moves.remove(c);
            }
        }

        removeSquareMoves(a, row, col, moves);

        return moves;
    }

    void removeSquareMoves(ArrayList<List<Character>> a, int row, int col, List<Character> moves) {
        int centerX = (row / 3) * 3 + 1;
        int centerY = (col / 3) * 3 + 1;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                Character c = a.get(centerX + i).get(centerY + j);
                if (c != '.') {
                    moves.remove(c);
                }
            }
        }
    }

}
