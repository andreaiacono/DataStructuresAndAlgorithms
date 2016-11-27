package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateItems {

    @Test
    public void test() {
        int[] a = new int[] {2, 1, 7, 5, 2, 3, 4, 4};
        assertEquals(2, getDuplicate(a));

        a = new int[] {};
        assertEquals(-1, getDuplicate(a));

        a = new int[] {1};
        assertEquals(-1, getDuplicate(a));

        a = new int[] {6, 1, 7, 5, 2, 3, 4};
        assertEquals(-1, getDuplicate(a));

        a = new int[] {3, 3, 1, 2};
        assertEquals(3, getDuplicate(a));

        a = new int[] {1, 3, 3, 3};
        assertEquals(3, getDuplicate(a));
    }

    int getDuplicate(int[] a) {

        for (int j=0; j<a.length; j++) {
            if (a[Math.abs(a[j])-1] < 0) {
                return Math.abs(a[j]);
            }
            a[Math.abs(a[j])-1] *= -1;
        }

        return -1;
    }
}
