package topcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeneralChess {

    @Test
    public void test() {
        String[] expected = new String[]{"-2,-1", "-2,1", "-1,-2", "-1,2", "1,-2", "1,2", "2,-1", "2,1"};
        Arrays.sort(expected);
        String[] result = attackPositions(new String[]{"0,0"});
        Arrays.sort(result);
        assertTrue(Arrays.equals(expected, result));

        expected = new String[]{"0,0", "1,-1"};
        Arrays.sort(expected);
        result = attackPositions(new String[]{"2,1", "-1,-2"});
        Arrays.sort(result);

        result = attackPositions(new String[]{"0,0", "2,1"});
        assertEquals(0, result.length);

        expected = new String[]{"-1001,998"};
        Arrays.sort(expected);
        result = attackPositions(new String[]{"-1000,1000", "-999,999", "-999,997"});
        Arrays.sort(result);
        assertTrue(Arrays.equals(expected, result));
    }

    class Position {
        int x;
        int y;

        public Position(String pos) {
            x = Integer.parseInt(pos.split(",")[0]);
            y = Integer.parseInt(pos.split(",")[1]);
        }

        public Position(Position position, int[] coord) {
            x = position.x + coord[0];
            y = position.y + coord[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return x + "," + y;
        }

        public Set<Position> getAttackingPositions() {
            Set<Position> positions = new HashSet<>();
            int[][] coords = new int[][]{{-1, -2}, {1, -2}, { -2, -1}, {2, -1}, { -2, 1}, {2, 1}, { -1, 2}, {1, 2}};

            for (int j = 0; j < coords.length; j++) {
                if (isValid(coords[j])) {
                    positions.add(new Position(this, coords[j]));
                }
            }
            return positions;
        }

        private boolean isValid(int[] pos) {
            return x + pos[0] >= -10000 && x + pos[0] <= 10000 && y + pos[1] >= -10000 && y + pos[1] <= 10000;
        }
    }

    String[] attackPositions(String[] pieces) {
        System.out.println("\n\n\n");
        Set<Position> positions = new HashSet<>();

        for (String piece : pieces) {
            // first, fill the set with some positions
            if (positions.isEmpty()) {
                positions.addAll(new Position(piece).getAttackingPositions());
            }
            // and then intersects these positions with every other
            else {
                positions.retainAll(new Position(piece).getAttackingPositions());
            }
        }

        return positions.stream().map(p -> p.toString()).toArray(String[]::new);
    }
}
