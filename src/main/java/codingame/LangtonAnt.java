package codingame;

/**
 *
 */
public class LangtonAnt {

    enum DIRS {
        N, E, S, W;
    };

    static int[][] dirs = new int[][] {
            {-1,0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String args[]) {
        int W = 5;
        int H = 5;
        int x = 2;
        int y = 2;
        String D = "N";
        int d = DIRS.valueOf(D).ordinal();
        int T = 10;
        char[][] map = new char[H][W];
        String[] in = new String[] {
                ".....",
                ".....",
                ".....",
                ".....",
                "....."
        };
        for (int i = 0; i < H; i++) {
            String C = in[i];
            map[i] = C.toCharArray();
        }

        for (int i=0; i< T; i++) {

            d = ( 4 + d + (map[x][y] == '.' ? -1 : +1 )) % 4;
            map[x][y] = map[x][y] == '.' ? '#' : '.';

            y += dirs[d][1];
            x += dirs[d][0];
        }

        for (int i = 0; i < H; i++) {

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(new String(map[i]));
        }
    }
}
