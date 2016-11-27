package topcoder;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Maze {

    @Test
    public void test() {
        char[][] maze = new char[][]{
                {'*', '*', '*', '*', '*', ' ', ' ', ' '},
                {'*', ' ', ' ', ' ', '*', ' ', ' ', ' '},
                {'*', 'S', '*', '*', '*', ' ', ' ', ' '},
                {'*', ' ', ' ', ' ', '*', '*', '*', '*'},
                {'*', ' ', '*', ' ', ' ', ' ', ' ', '*'},
                {'*', ' ', ' ', ' ', '*', ' ', ' ', '*'},
                {'*', '*', '*', '*', '*', ' ', 'E', '*'},
                {' ', ' ', ' ', ' ', '*', '*', '*', '*'}
        };

        assertTrue(solveMaze(maze));

        maze = new char[][]{
                {'*', '*', '*', '*', '*', ' ', ' ', ' '},
                {'*', ' ', ' ', ' ', '*', ' ', ' ', ' '},
                {'*', 'S', '*', '*', '*', ' ', ' ', ' '},
                {'*', ' ', ' ', ' ', '*', '*', '*', '*'},
                {'*', ' ', '*', ' ', '*', ' ', ' ', '*'},
                {'*', ' ', ' ', ' ', '*', ' ', ' ', '*'},
                {'*', '*', '*', '*', '*', ' ', 'E', '*'},
                {' ', ' ', ' ', ' ', '*', '*', '*', '*'}
        };

        assertFalse(solveMaze(maze));
    }

    static int[][] dirs = new int[][]{
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    Set<Position> visited = new HashSet<>();

    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Set<Position> getLegalMoves(char[][] maze) {

            Set<Position> result = new HashSet<>();

            for (int j = 0; j < dirs.length; j++) {
                int newX = x + dirs[j][0];
                int newY = y + dirs[j][1];
                Position move = new Position(newX, newY);
                if (isLegal(newX, newY, maze) && maze[newX][newY] != '*') {
                    result.add(move);
                }
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null || !(o instanceof Position)) {
                return false;
            }

            Position other = (Position) o;
            return x == other.x && y == other.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }
    }

    boolean isLegal(int x, int y, char[][] maze) {
        return x >= 0 && x < maze[0].length && y >= 0 && y < maze.length;
    }

    private boolean solveMaze(char[][] maze) {
        Integer.toBinaryString(20);
        Position start = find(maze, 'S');
        return solve(maze, start);
    }

    private boolean solve(char[][] maze, Position current) {
        if (maze[current.x][current.y] == 'E') {
            return true;
        }

        for (Position move : current.getLegalMoves(maze)) {
            if (!visited.contains(move)) {
                visited.add(move);

                if (solve(maze, move)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Position find(char[][] maze, char searched) {

        for (int j = 0; j < maze.length; j++) {
            for (int i = 0; i < maze[0].length; i++) {
                if (maze[j][i] == searched) {
                    return new Position(j, i);
                }
            }
        }

        return null;
    }
}
