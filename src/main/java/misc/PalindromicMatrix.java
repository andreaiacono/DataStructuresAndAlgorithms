package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// TODO: to add to TechInterviewTalk for backtracking
public class PalindromicMatrix {

    @Test
    public void test() {
        char mat[][] = new char[][]
        {
                {'a', 'a', 'a', 'b'},
                {'b', 'a', 'a', 'a'},
                {'a', 'b', 'b', 'a'}
        };

        assertEquals(3, countPaths(mat));
    }

    int countPaths(char[][] mat) {
        return countPaths(mat, 0, 0, "");
    }

    int countPaths(char[][] mat, int r, int c, String path) {
        path += mat[r][c];

        // goal
        if (r==mat.length-1 && c == mat[0].length-1) {
            return isPalindrome(path) ? 1 : 0;
        }

        int total = 0;
        if (r+1 < mat.length) {
            total += countPaths(mat, r+1, c, path);
        }

        if (c+1 < mat[0].length) {
            total += countPaths(mat, r, c+1, path);
        }

        return total;
    }

    boolean isPalindrome(String path) {

        for (int i=0; i<path.length()/2; i++) {
            if (path.charAt(i) != path.charAt(path.length()-i-1)) {
                return false;
            }
        }

        return true;
    }
}
