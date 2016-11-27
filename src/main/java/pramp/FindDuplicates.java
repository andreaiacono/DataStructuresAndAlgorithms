package pramp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class FindDuplicates {



    @Test
    public void test() {
        int[] arr1 = new int[] {1,3,9,4};
        int[] arr2 = new int[] {3,2};
        int[] result = new int[] {3};
        assertTrue(Arrays.equals(result, findDuplicate(arr1, arr2)));

        arr1 = new int[] {1, 2, 3, 4, 9, 11, 12, 13, 14, 19, 21, 22, 23, 24, 29, 31, 32, 33, 34, 39, 31, 32, 33, 34, 99};
        arr2 = new int[] {2, 99};
        result = new int[] {2, 99};
        assertTrue(Arrays.equals(result, findDuplicatesDiffSizes(arr1, arr2)));
    }


    public int[] findDuplicate(int[] arr1, int[] arr2){

        int[] result = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int resultIndex = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] == arr2[index2]) {
                result[resultIndex++] = arr1[index1];
                index1++;
                index2++;
            }
            else if (arr1[index1] < arr2[index2]) {
                index1++;
            }
            else {
                index2++;
            }
        }

        return Arrays.copyOf(result, resultIndex);
    }


    public int[] findDuplicatesDiffSizes(int[] arr1, int[] arr2) {

        // assumes arr2 is shorter than arr1
        assert (arr1.length > arr2.length);

        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 0; j < arr2.length; j++) {
            if (binarySearch(arr1, arr2[j]) >= 0) {
                result.add(arr2[j]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == n) {
                return mid;
            }
            else if (arr[mid] < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
