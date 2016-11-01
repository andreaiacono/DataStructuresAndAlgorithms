package sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountingSortTest {

    @Test
    public void emptyArray() throws Exception {
        int a[] = new int[]{};
        assertEquals(0, sorting.CountingSort.countingSort(a, 1).length);
    }

    @Test
    public void normalArray() throws Exception {
        int[] a = new int[] {5, 3, 7, 8, 11, 3, 1, 5, 7, 7, 2, 1, 8};
        int[] sorted = new int[] {1, 1, 2, 3, 3, 5, 5, 7, 7, 7, 8, 8, 11};
        int max = Arrays.stream(a).max().getAsInt() + 1;

        int[] sortedA = sorting.CountingSort.countingSort(a, max);
        assertTrue(Arrays.toString(sortedA), Arrays.equals(sorted, sortedA));
    }

}