package recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSelect {


    @Test
    public void test() {
        assertEquals(5, quickSelect(new int[] {1, 3, 9, 2, 8, 5, 4}, 3));
        assertEquals(5, quickSelect(new int[] {5}, 1));
    }

    /**
     * finds the k-th greatest value in the array
     * @param a
     * @param k
     * @return
     */
    public int quickSelect(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        int searched = a.length - k; // the searched k-th greatest element

        while (left < right) {
            int pivot = partition(a, left, right);
            System.out.println("partition called. pivot=" + pivot + " (" + a[pivot] + ")");

            if (pivot < searched) {
                left = pivot + 1;
            }
            else if (pivot > searched) {
                right = pivot - 1;
            }
            else {
                return a[pivot];
            }
        }
        return a[left];
    }

    private int partition(int[] a, int left, int right) {

        System.out.println("Start partition with pivolt = " + left + " (" + a[left] + ")");
        System.out.println("Start:" + Arrays.toString(a));
        int pivot = left;

        while (left <= right) {
            while (left <= right && a[left] <= a[pivot]) {
                left++;
            }
            while (left <= right && a[right] > a[pivot]) {
                right--;
            }
            if (left > right) {
                break;
            }
            swap(a, left, right);
        }

        swap(a, right, pivot);

        System.out.println("End:  " + Arrays.toString(a));
        return right;
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}
