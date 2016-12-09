package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridPath {

    @Test
    public void test() {
        assertEquals(2, uniquePaths(2, 2));
        assertEquals(3, uniquePaths(2, 3));
        assertEquals(6, uniquePaths(3, 3));
        assertEquals(20, uniquePaths(4, 4));

    }

    public int uniquePaths(int a, int b) {

        if (a == 1 && b == 1) {
            return 1;
        }

        int sum = 0;

        if (a - 1 >= 1) {
            sum += uniquePaths(a - 1, b);
        }
        if (b - 1 >= 1) {
            sum += uniquePaths(a, b - 1);
        }

        return sum;
    }
}