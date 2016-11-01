package searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchInRotatedArray {

    public static int getIndex(int[] n, int value) {

        int mid = getDivisionIndex(n);
        if (mid == -1) {
            mid = n.length / 2;
        }
        if (n[0] > value) {
            return bsearch(n, value, mid, n.length - 1);
        }
        else {
            return bsearch(n, value, 0, mid);
        }
    }

    private static int getDivisionIndex(int[] n) {

        if (n[0] < n[n.length - 1]) {
            return -1;
        }
        return innnerDivisionIndex(n, 0, n.length - 1);
    }

    private static int bsearch(int[] n, int value, int left, int right) {
        if (right - left < 2) {
            if (n[right] == value) {
                return right;
            }
            if (n[left] == value) {
                return left;
            }
            return -1;
        }
        int mid = (left + right) / 2;
        if (n[mid] == value) {
            return mid;
        }
        if (n[mid] > value) {
            return bsearch(n, value, left, mid);
        }
        else {
            return bsearch(n, value, mid + 1, right);
        }
    }

    private static int innnerDivisionIndex(int[] n, int left, int right) {

        if (right - left <= 2) {
            if (n[left] > n[right]) {
                return right;
            }
            else {
                return left;
            }
        }
        int mid = (left + right) / 2;
        if (n[left] > n[mid]) {
            return innnerDivisionIndex(n, left, mid);
        }
        else {
            return innnerDivisionIndex(n, mid + 1, right);
        }
    }


    @Test
    public void test() {
        int n[] = new int[]{5, 6, 7, 8, 1, 2, 3};
        assertEquals(4, getDivisionIndex(n));
        assertEquals(5, getIndex(n ,2));
        assertEquals(-1, getIndex(n ,10));

        n = new int[]{5};
        assertEquals(0, getDivisionIndex(n));

        n = new int[]{5, 7};
        assertEquals(-1, getDivisionIndex(n));
        assertEquals(1, getIndex(n ,7));

        n = new int[]{5, 1, 2, 3};
        assertEquals(1, getDivisionIndex(n));
        assertEquals(0, getIndex(n ,5));
        assertEquals(1, getIndex(n ,1));
        assertEquals(3, getIndex(n ,3));

        n = new int[]{5, 5, 5, 3};
        assertEquals(3, getDivisionIndex(n));

    }

}
