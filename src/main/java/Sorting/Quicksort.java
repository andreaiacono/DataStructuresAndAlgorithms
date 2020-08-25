package sorting;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Quicksort  {
    private int[] numbers;
    private int number;

    @Test
    public void test() {

        int[] n = new int [] {1,2,10,5,7,6,8};
        int[] result = new int [] {1,2,5,6,7,8,10};
        assertFalse(Arrays.equals(result, n));
        quicksort(n);
        assertTrue(Arrays.equals(result, n));
    }

    public void quicksort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        quicksort(values, 0, values.length-1);
    }

    public void quicksort(int[] values, int low, int hi) {
        if (hi <= low) {
            return;
        }

        int j = partition(values, low, hi);
        quicksort(values, low, j-1);
        quicksort(values, j+1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int pivot = lo;

        while (lo <= hi) {

            while (lo <= hi && a[lo] <= a[pivot]) {
                lo++;
            }
            while (lo <= hi && a[hi] > a[pivot]) {
                hi--;
            }
            if (lo > hi) {
                break;
            }
            swap(a, lo, hi);
        }

        swap(a, hi, pivot);
        return hi;
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}