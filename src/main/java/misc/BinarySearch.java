package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearch {


    @Test
    public void test() {
        int[] arr = { 2, 3, 4, 10, 40 };
        assertEquals(-1, binarySearch(arr, 5));
        assertEquals(2, binarySearch(arr, 4));
        assertEquals(0, binarySearch(arr, 2));
        assertEquals(4, binarySearch(arr, 40));
    }


    int binarySearch(int[] values, int target) {
        int left = 0;
        int right = values.length-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (values[mid] > target) {
                right = mid - 1;
            }
            else if (values[mid] < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

}
