package misc;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class WordInGrid {

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cell,
     * where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     * <p>
     * Example:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     */

    @Test
    public void test() {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";
//        assertTrue(exist(board, word));

        word = "ABCB";
//        assertFalse(exist(board, word));

       
        board = new char[][]{
            {'A', 'A'}
        };
        word = "AAA";
//        assertFalse(exist(board, word)); 
        
        board = new char[][]{
                {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
        };
        word = "ABCESEEEFS";
//        assertTrue(exist(board, word));

        board = new char[][]{
                {'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}
        };
        word = "AAAAAAAAAAAA";
        assertTrue(exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0)) {
                    if (exist(board, word, row, col)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (row != pair.row) return false;
            return col == pair.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    class Pos {
        int row;
        int col;
        int index;
        List<Pair> used = new ArrayList<>();

        public Pos(int row, int col, int index, List<Pair> used) {
            this.row = row;
            this.col = col;
            this.index = index;
            this.used = used;
        }
    }

    public boolean exist(char[][] board, String word, int row, int col) {

        Deque<Pos> stack = new ArrayDeque<>();
        stack.push(new Pos(row, col, 1, new ArrayList<>() {{ add(new Pair(row, col)); }}));

        while (!stack.isEmpty()) {
            Pos cur = stack.pop();
             System.out.println("row="+cur.row+" col="+cur.col+" index="+cur.index);

            if (cur.index == word.length()) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = cur.row + dx[i];
                int newCol = cur.col + dy[i];
                if (isValid(newRow, newCol, board) && !cur.used.contains(new Pair(newRow, newCol)) && board[newRow][newCol] == word.charAt(cur.index)) {
                    cur.used.add(new Pair(newRow, newCol));
                    stack.push(new Pos(newRow, newCol, cur.index + 1, cur.used));
                }
            }
        }


        return false;
    }

    boolean isValid(int row, int col, char[][] board) {
        return row >= 0 && row < board.length &&
                col >= 0 && col < board[row].length;
    }


    public boolean exist(char[][] board, String word, int index, int row, int col, List<String> used) {

        if (index == word.length()) {
            return true;
        }

        used.add(pair(row, col));
        char c = word.charAt(index);
        boolean result = false;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (isValid(newRow, newCol, board) && board[newRow][newCol] == c && !used.contains(pair(newRow, newCol))) {
                result |= exist(board, word, index + 1, row - 1, col, used);
            }
        }
        used.remove(pair(row, col));
        return result;
    }

    String pair(int row, int col) {
        return row + "," + col;
    }


}
