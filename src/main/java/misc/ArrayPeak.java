package misc;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class ArrayPeak {

    @Test
    public void test() {
        int[] a = new int[]{2, 10, 20, 15, 17, 25, 18};
        Set<Integer> peaks = new HashSet<>(Arrays.asList(2, 5));
        assertTrue(peaks.contains(getPeak(a)));

        a = new int[]{2, 10, 20, 25, 37, 45, 58};
        peaks = new HashSet<>(Arrays.asList(6));
        assertTrue(peaks.contains(getPeak(a)));

        a = new int[]{22, 21, 15, 5};
        peaks = new HashSet<>(Arrays.asList(0));
        assertTrue(peaks.contains(getPeak(a)));

        a = new int[]{1, 1, 1, 1, 1, 1};
        peaks = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5));
        assertTrue(peaks.contains(getPeak(a)));
    }

    int getPeak(int[] a) {

        int n = a.length;
        int left = 0;
        int right = n - 1;

        while (true) {
            int mid = left + (right - left) / 2;
            if ((mid > 0 && a[mid] > a[mid - 1])
                    && (mid < n - 1 && a[mid] > a[mid + 1])) {
                return mid;
            }

            if (mid > 0 && a[mid] < a[mid - 1]) {
                right = mid - 1;
            }
            else if (mid < n - 1 && a[mid] < a[mid + 1]) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
    }
}
