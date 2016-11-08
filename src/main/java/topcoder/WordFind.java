package topcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class WordFind {

    @Test
    public void test() {

        String[] grid = new String[]{"TEST", "GOAT", "BOAT"};
        String[] words = new String[]{"GOAT", "BOAT", "TEST"};
        String[] expected = new String[]{"1 0", "2 0", "0 0"};
        Arrays.sort(expected);
        String[] result = findWords(grid, words);
        Arrays.sort(result);
        assertTrue(Arrays.equals(expected, result));

        grid = new String[]{"SXXX", "XQXM", "XXLA", "XXXR"};
        words = new String[]{"SQL", "RAM"};
        expected = new String[]{"0 0", "3 3"};
        Arrays.sort(expected);
        result = findWords(grid, words);
        Arrays.sort(result);
        assertTrue(Arrays.equals(expected, result));

        grid = new String[]{"EASYTOFINDEAGSRVHOTCJYG", "FLVENKDHCESOXXXXFAGJKEO", "YHEDYNAIRQGIZECGXQLKDBI", "DEIJFKABAQSIHSNDLOMYJIN", "CKXINIMMNGRNSNRGIWQLWOG", "VOFQDROQGCWDKOUYRAFUCDO", "PFLXWTYKOITSURQJGEUSPGG"};
        words = new String[]{"EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE"};
        expected = new String[]{"", "0 0", "1 6", "0 22"};
        Arrays.sort(expected);
        result = findWords(grid, words);
        Arrays.sort(result);
        assertTrue(Arrays.equals(expected, result));
    }

    class Cell {
        char c;
        int x;
        int y;

        public Cell(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    private boolean checkWord(Cell[][] g, Cell cell, String word) {
        int n = word.length();
        boolean[] dirs = new boolean[8];
        Arrays.fill(dirs, true);
        for (int j=0; j<n; j++) {
            char c = word.charAt(j);
            if (dirs[0]) { dirs[0] = checkCell(g, cell.x,     cell.y - j, c);} // UP
            if (dirs[1]) { dirs[1] = checkCell(g, cell.x,     cell.y + j, c);} // DOWN

            if (dirs[2]) { dirs[2] = checkCell(g, cell.x + j, cell.y    , c);} // RIGHT
            if (dirs[3]) { dirs[3] = checkCell(g, cell.x - j, cell.y    , c);} // LEFT

            if (dirs[4]) { dirs[4] = checkCell(g, cell.x - j, cell.y-j  , c);} // UP-LEFT
            if (dirs[5]) { dirs[5] = checkCell(g, cell.x + j, cell.y-j  , c);} // UP-RIGHT
            if (dirs[6]) { dirs[6] = checkCell(g, cell.x - j, cell.y+j  , c);} // DOWN-LEFT
            if (dirs[7]) { dirs[7] = checkCell(g, cell.x + j, cell.y+j  , c);} // DOWN-RIGHT
        }

        for (int j=0; j<8; j++) {
            if (dirs[j]) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCell(Cell[][] g, int x, int y, char c) {
        return x>=0 && x < g.length && y >= 0 && y< g[0].length && g[x][y].c == c;
    }


    public String[] findWords(String[] grid, String[] wordList) {
        Cell[][] g = new Cell[grid.length][grid[0].length()];
        for (int j=0; j<grid.length; j++) {
            for (int i=0; i<grid[0].length(); i++) {
                g[j][i] = new Cell(j, i, grid[j].charAt(i));
            }
        }

        List<String> result = new LinkedList<>();
        for (String word: wordList) {
            boolean found = false;
            for (int j=0; j<g.length; j++) {
                for (int i = 0; i < g[0].length; i++) {
                    if (checkWord(g, g[j][i], word)) {
                        result.add(g[j][i].x + " " + g[j][i].y);
                        found = true;
                    }
                }
            }
            if (!found) {
                result.add("");
            }
        }

        return result.stream().toArray(String[]::new);
    }
}
