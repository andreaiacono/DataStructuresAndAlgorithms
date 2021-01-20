package array;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class MoveZeroesToLeft {

    /**
     * Given an integer array, move all elements that are 0 to the left while maintaining the order of
     * other elements in the array. The array has to be modified in-place.
     */

    @Test
    public void test() {

        int arr[] = new int[] { 1, 2, 0, 4, 1, 0, 5, 7, 0, 1, 0};
        int expecetd[] = new int[] { 0, 0, 0, 0, 1, 2, 4, 1, 5, 7, 1};

        assertTrue(Arrays.equals(expecetd, moveZeroes(arr)));


    }

    int[] moveZeroes(int[] arr) {

        return null;

    }


}
