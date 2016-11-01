package misc;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * TopCoder: https://community.topcoder.com/stat?c=problem_statement&pm=2915&rd=5853
 */
public class CaptureThemAll {

    @Test
    public void test() {
        assertEquals(2, fastKnight("a1", "b3", "c5"));
        assertEquals(3, fastKnight("b1", "c3", "a3"));
        assertEquals(6, fastKnight("a1", "a2", "b2"));
        assertEquals(3, fastKnight("a5", "b7", "e4"));
        assertEquals(6, fastKnight("h8", "e2", "d2"));
    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Position(String code) {
            row = Integer.parseInt(code.substring(1)) - 1;
            col = code.charAt(0) - 'a';
        }

        @Override
        public String toString() {
            return "(" + row + "," + col + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (row != position.row) return false;
            return col == position.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    class State {
        int moves;
        Position position;
        boolean hasCapturedQueen;
        boolean hasCapturedRook;
        State parent;

        public State(Position position, boolean hasCapturedQueen, boolean hasCapturedRook, int moves, State parent) {
            this.position = position;
            this.hasCapturedQueen = hasCapturedQueen;
            this.hasCapturedRook = hasCapturedRook;
            this.moves = moves;
            this.parent = parent;
        }

        public State(String pos) {
            position = new Position(pos);
        }

        public List<State> getNextStates(int moves) {
            List<State> states = new LinkedList<>();

            if (position.row - 1 >= 0 && position.col - 2 >= 0) {
                states.add(new State(new Position(position.row - 1, position.col - 2), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row - 1 >= 0 && position.col + 2 < 8) {
                states.add(new State(new Position(position.row - 1, position.col + 2), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row - 2 >= 0 && position.col - 1 >= 0) {
                states.add(new State(new Position(position.row - 2, position.col - 1), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row - 2 >= 0 && position.col + 1 < 8) {
                states.add(new State(new Position(position.row - 2, position.col + 1), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row + 1 < 8 && position.col - 2 >= 0) {
                states.add(new State(new Position(position.row + 1, position.col - 2), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row + 1 < 8 && position.col + 2 < 8) {
                states.add(new State(new Position(position.row + 1, position.col + 2), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row + 2 < 8 && position.col - 1 >= 0) {
                states.add(new State(new Position(position.row + 2, position.col - 1), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            if (position.row + 2 < 8 && position.col + 1 < 8) {
                states.add(new State(new Position(position.row + 2, position.col + 1), hasCapturedQueen, hasCapturedRook, moves, this));
            }
            return states;
        }

        @Override
        public String toString() {
            return position + (hasCapturedQueen ? "+" : "-") + (hasCapturedRook ? "+ " : "- ");
        }
    }

    int fastKnight(String knight, String rook, String queen) {
        Position queenPosition = new Position(queen);
        Position rookPosition = new Position(rook);

        return Math.min(bfs(new Position(knight), queenPosition) + bfs(queenPosition, rookPosition),
                bfs(new Position(knight), rookPosition) + bfs(rookPosition, queenPosition));
    }

    private int bfs(Position start, Position target) {

        Set<Position> visitedPositions = new HashSet<>();
        Deque<State> queue = new ArrayDeque<>();
        queue.add(new State(start, false, false, 0, null));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.position.equals(target)) {

                int moves = current.moves;
                System.out.println("\nSolution: ");
                do {
                    System.out.print(current + " -> ");
                    current = current.parent;
                }
                while (current != null);
                System.out.println("\n");
                return moves;
            }

            for (State next : current.getNextStates(current.moves + 1)) {
                if (!visitedPositions.contains(next.position)) {
                    visitedPositions.add(next.position);
                    queue.add(next);
                }
            }
        }

        // should not arrive here
        return -1;
    }
}
