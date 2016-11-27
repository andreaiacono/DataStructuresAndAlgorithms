package misc;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Position)) {
                return false;
            }

            Position other = (Position) o;
            return other.x == x && other.y == y;
        }

        public int hashCode() {
            return 17 * x + y;
        }
    }

    int countIslands(char[][] map) {

        Set<Position> islands = new HashSet<>();
        int foundIslands = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'x' && !islands.contains(new Position(i, j))) {
                    findIsland(i, j, map, islands);
                    foundIslands++;
                }
            }
        }

        return foundIslands;
    }

    void findIsland(int x, int y, char[][] map, Set<Position> islands) {
        islands.add(new Position(x, y));

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (isLegal(newX, newY, map) && map[newX][newY] == 'x' && !islands.contains(new Position(newX, newY))) {
                findIsland(newX, newY, map, islands);
            }
        }
    }

    boolean isLegal(int x, int y, char[][] map) {
        return x >= 0 && x < map.length && y >= 0 && y< map[0].length;
    }

}
