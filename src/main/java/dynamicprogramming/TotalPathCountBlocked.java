package dynamicprogramming;

import org.junit.Test;

import java.util.*;

// Dynamic programming for coding interviews
// Question 9.2
public class TotalPathCountBlocked {

    @Test
    public void test() {
        int row = 4;
        int col = 5;
        HashSet<Road> blockedRoads = new HashSet<>();
        blockedRoads.add(new Road(0, 2, 0, 1));
        blockedRoads.add(new Road(2, 3, 1, 3));
        blockedRoads.add(new Road(3, 1, 2, 1));
        blockedRoads.add(new Road(3, 3, 3, 2));
        long tot = totalPathCountDp(row, col, blockedRoads);
        assert tot == 12;
    }

    long totalPathCountDp(int row, int col, HashSet<Road> blockedRoads) {
        long[][] grid = new long[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = blockedRoads.contains(new Road(i, j, i, j-1)) ? 0 : j == 1 ? 1: grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] = blockedRoads.contains(new Road(i, j, i-1, j)) ? 0 : i == 1 ? 1 : grid[i-1][j];
                } else {
                    long up = blockedRoads.contains(new Road(i, j, i - 1, j)) ? 0 : grid[i - 1][j];
                    long left = blockedRoads.contains(new Road(i, j, i, j - 1)) ? 0 : grid[i][j - 1];
                    grid[i][j] = up + left;
                }
            }
        }
        return grid[row - 1][col - 1];
    }

    class Road {
        int fromRow, fromCol, toRow, toCol;

        public Road(int fromRow, int fromCol, int toRow, int toCol) {
            this.fromRow = fromRow;
            this.fromCol = fromCol;
            this.toRow = toRow;
            this.toCol = toCol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return fromRow == road.fromRow &&
                    fromCol == road.fromCol &&
                    toRow == road.toRow &&
                    toCol == road.toCol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fromRow, fromCol, toRow, toCol);
        }

        @Override
        public String toString() {
            return "(" + fromRow + ", " + fromCol + ") -> (" + toRow + ", " + toCol + ")";
        }
    }

}
