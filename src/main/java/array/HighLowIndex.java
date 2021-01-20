package array;

import org.junit.Test;

public class HighLowIndex {

    /**
     * Given a sorted array of integers, return the low and high index of the given key. You must
     * return -1 if the indexes are not found.
     */

    @Test
    public void test() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    int[] higLowIndexOpt(int[] arr, int k) {
        return new int[]{lowIndex(arr, k), highIndex(arr, k)};
    }

    int highIndex(int[] arr, int k) {
        return 0;
    }

    int lowIndex(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < k) {
                left = mid + 1;
            }
            else if (arr[mid] > k) {
                right = mid - 1;
            }
        }
        return -1;
    }

    int[] higLowIndex(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (arr[mid] == k) {
                int leftRunner = mid;
                while (leftRunner >= 0 && arr[leftRunner] == k) {
                    leftRunner--;
                }
                int rightRunner = mid;
                while (rightRunner < arr.length && arr[rightRunner] == k) {
                    rightRunner++;
                }
                return new int[]{leftRunner, rightRunner};
            } else if (arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{-1, -1};

    }

}
