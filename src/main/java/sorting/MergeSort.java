package sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class MergeSort {

    @Test
    public void test() {

        int[] n = new int[]{1};
        int[] result = mergeSort(n);
        assertTrue(Arrays.equals(new int[]{1}, result));

        n = new int[]{3, 1};
        result = mergeSort(n);
        assertTrue(Arrays.equals(new int[]{1, 3}, result));

        n = new int[]{1, 2, 10, 5, 7, 6, 8};
        result = mergeSort(n);
        assertTrue(Arrays.equals(new int[]{1, 2, 5, 6, 7, 8, 10}, result));
    }

    public int[] mergeSort(int[] n) {
        return mergeSort(n, 0, n.length - 1);
    }

    private int[] mergeSort(int[] n, int left, int right) {

        if (right - left == 0) {
            return new int[] { n[left] };
        }

        int mid = (left + right) / 2;
        return merge(mergeSort(n, left, mid), mergeSort(n, mid+1, right));
    }

    public int[] merge(int[] a, int[] b) {
        int aIndex = 0;
        int bIndex = 0;

        int[] c = new int[a.length + b.length];
        int cIndex = 0;

        while (aIndex < a.length && bIndex < b.length) {
            c[cIndex++] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
        }

        if (aIndex < a.length) {
            System.arraycopy(a, aIndex, c, cIndex, a.length - aIndex);
        }
        else {
            System.arraycopy(b, bIndex, c, cIndex, b.length - bIndex);
        }

        return c;
    }
}
