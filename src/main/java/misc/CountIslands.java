package misc;

import org.junit.Test;

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

}
