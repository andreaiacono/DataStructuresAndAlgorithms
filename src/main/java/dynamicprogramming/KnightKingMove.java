package dynamicprogramming;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.*;

public class KnightKingMove {

    @Test
    public void test() {
        Pos start = new Pos(3, 3);
        Pos target = new Pos(5, 1);
        int moves = minMoves(start, target, 0, new HashSet<>());
        System.out.println("Recursive moves: " + moves);
        moves = minMovesBfs(start, target);
        System.out.println("BFS moves: " + moves);
    }

    int minMovesBfs(Pos start, Pos target) {
        Set<Pos> visited = new HashSet<>();
        Deque<Pos> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            if (current.equals(target)) {
                return current.moves;
            }

            for (Pos next : getPossibleMoves(current)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return -1;
    }

    int minMoves(Pos current, Pos target, int moves, Set<Pos> checked) {
        System.out.println("current: " + current);
        if (current.equals(target)) {
            System.out.println("Returning " + moves);
            return moves;
        }

        int min = Integer.MAX_VALUE;
        for (Pos next : getPossibleMoves(current)) {
            if (!checked.contains(next)) {
                checked.add(next);
                min = Math.min(min, minMoves(next, target, moves + 1, checked));
            }
        }
        return min;
    }

    int[] knightRows = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    int[] knightCols = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    List<Pos> getPossibleMoves(Pos current) {
        List<Pos> result = new ArrayList<>();
        for (int row = -1; row < 2; row++) {
            for (int col = -1; col < 2; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                Pos next = new Pos(current.row + row, current.col + col, current.moves + 1);
                if (isLegal(next)) {
                    result.add(next);
                }
            }
        }
        for (int i = 0; i < knightRows.length; i++) {
            Pos pos = new Pos(current.row + knightRows[i], current.col + knightCols[i], current.moves + 1);
            if (isLegal(pos)) {
                result.add(pos);
            }
        }
        return result;
    }

    boolean isLegal(Pos pos) {
        return pos.row >= 0 && pos.row < 8 && pos.col >= 0 && pos.col < 8;
    }

}


class Pos {
    int row, col, moves;

    public Pos(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Pos(int row, int col, int moves) {
        this.row = row;
        this.col = col;
        this.moves = moves;
    }

    public boolean equals(Object o) {
        // extra check null and instanceof
        Pos other = (Pos) o;
        return other.row == row && other.col == col;
    }

    public int hashCode() {
        return 17 * row + 23 + col;
    }

    public String toString() {
        return "(" + row + ", " + col + ")[" + moves + "]";
    }
}



