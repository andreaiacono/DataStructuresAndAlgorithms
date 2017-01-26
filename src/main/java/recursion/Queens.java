package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Queens {

    static int EMPTY = 0;
    static int QUEEN = 1;
    static int UNDER_CHECK = 2;

    static int SIZE = 8;

    static int m[][] = new int[SIZE][SIZE];
    static Set<Integer[][]> found = new HashSet<>();

    public static void queens(int pos, int placedQueens) {

        if (placedQueens == SIZE) {
            Integer[][] copy = new Integer[SIZE][SIZE];
            for (int j=0; j<SIZE; j++) {
                for (int i=0; i<SIZE; i++) {
                    copy[j][i] = m[j][i];
                }
            }
            found.add(copy);
        }

        if (pos == SIZE*SIZE-1) {
            return;
        }

        for (int j=pos; j<SIZE*SIZE; j++) {
            if (m[j/SIZE][j%SIZE] == EMPTY) {
                placeQueen(j/SIZE, j%SIZE);
                queens(pos, placedQueens +1);
                removeQueen(j/SIZE, j%SIZE);
            }
        }
    }

    private static void removeQueen(int x, int y) {
        List<Coord> queens = new ArrayList<>();
        for (int j=0; j<SIZE*SIZE; j++) {
            if (x != j/SIZE && y != j%SIZE && m[j/SIZE][j%SIZE] == QUEEN) queens.add(new Coord(j/SIZE, j%SIZE));
        }
        m = new int[SIZE][SIZE];
        queens.forEach(coord -> placeQueen(coord.x, coord.y));
    }


    private static void placeQueen(int x, int y) {
        for (int j=0; j<SIZE; j++) {
            m[x][j] = UNDER_CHECK;
            m[j][y] = UNDER_CHECK;
            if (x+j < SIZE && y+j < SIZE) m[x+j][y+j] = UNDER_CHECK;
            if (x+j < SIZE && y-j >= 0) m[x+j][y-j] = UNDER_CHECK;
            if (x-j >= 0 && y+j < SIZE) m[x-j][y+j] = UNDER_CHECK;
            if (x-j >= 0 && y-j >= 0) m[x-j][y-j] = UNDER_CHECK;
        }
        m[x][y] = QUEEN;

    }

    private static String getCheckboard(Integer m[][]) {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<SIZE*SIZE; j++) {
            if (j % SIZE == 0) {
                sb.append("\n");
            }
            sb.append(m[j/SIZE][j%SIZE] == QUEEN ? "Q" : m[j/SIZE][j%SIZE] == EMPTY ? "." : "col").append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        queens(0, 0);
//        found.forEach(checkboard -> System.out.println(getCheckboard(checkboard)));
        System.out.println("Solutions found: " + found.size());
    }

    static class Coord {
        int x,y ;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
