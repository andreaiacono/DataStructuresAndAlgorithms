package searching;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMinInRotatedArray {

    @Test
    public void test() {
        assertEquals(2, findMin(new int[]{4, 5, 6, 7, 2, 3}));
        assertEquals(1, findMin(new int[]{9, 1, 2, 3, 4, 5}));
        assertEquals(1, findMin(new int[]{2, 3, 4, 5, 1}));
        assertEquals(1, findMin(new int[]{1, 2, 3, 4, 5}));
    }

    private int findMin(int[] a) {

        int left = 0;
        int right = a.length - 1;

        // if it's already sorted
        if (a[left]<a[right]) {
            return a[left];
        }

        while (left < right) {
            int mid = (left + right) / 2;

            if (a[mid] > a[left]) {
                left = mid;
            }
            if (a[mid] < a[left]) {
                right = mid;
            }

            if (a[mid] < a[mid - 1]) {
                return a[mid];
            }
            if (a[mid] > a[mid + 1]) {
                return a[mid+1];
            }
        }
        return -1;
    }
}
