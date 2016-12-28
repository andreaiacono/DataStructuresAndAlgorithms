package misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CountIslands {

    @Test
    public void test() {

        char[][] map = new char[][]{
                {'o', 'o', 'x', 'o', 'x', 'x'},
                {'o', 'o', 'o', 'x', 'o', 'o'},
                {'o', 'x', 'x', 'o', 'o', 'x'},
                {'o', 'o', 'x', 'x', 'o', 'o'},
                {'o', 'o', 'o', 'o', 'o', 'o'}
        };

        assertEquals(5, countIslands(map));


        ArrayList<String> a = new ArrayList<>(Arrays.asList("OOOXOOO", "OOXXOXO", "OXOOOXO"));
        assertEquals(3, black(a));
    }

    int[][] directions = new int[][]{
            {1, 0}, // left
            {-1, 0},// right
            {0, 1}, // up
            {0, -1} // down
    };

    final char WATER = '0';
    final char ISLAND = 'x';
    final char VISITED_ISLAND = '-';

    int countIslands(char[][] map) {

        int foundIslands = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == ISLAND) {
                    findIsland(i, j, map);
                    foundIslands++;
                }
            }
        }

        return foundIslands;
    }

    void findIsland(int x, int y, char[][] map) {
        map[x][y] = VISITED_ISLAND;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (isLegal(newX, newY, map) && map[newX][newY] == ISLAND) {
                findIsland(newX, newY, map);
            }
        }
    }

    boolean isLegal(int x, int y, char[][] map) {
        return x >= 0 && x < map.length && y >= 0 && y< map[0].length;
    }


    public int black(ArrayList<String> a) {

        if (a == null) {
            return -1;
        }


        int counter = 0;

        for (int i=0; i<a.size(); i++) {
            for (int j=0; j<a.get(0).length(); j++) {
                if (a.get(i).charAt(j) == 'X') {
                    markObject(a, i, j);
                    counter ++;
                }
            }
        }

        return counter;
    }

    int[][] dirs = new int[][] {
            {-1,  0}, // left
            { 1,  0}, // right
            { 0, -1}, // up
            { 0,  1}  // down
    };

    void markObject(ArrayList<String> a, int i, int j) {

        StringBuilder newPos = new StringBuilder(a.get(i));
        newPos.setCharAt(j, 'M');
        a.set(i, newPos.toString());
        System.err.println("A=" + a);
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (isLegal(a, x, y) && a.get(x).charAt(y) == 'X') {
                markObject(a, x, y);
            }
        }
    }

    boolean isLegal(ArrayList<String> a, int x, int y) {
        return x >= 0 && x < a.size() && y >= 0 && y < a.get(0).length();
    }
}
