package interviewbit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RotatedBinarySearch {

    @Test
    public void test() {

        assertEquals(4, searchInsert(Arrays.asList(1, 3, 5, 6), 7));
        assertEquals(149, searchInsert(Arrays.asList(3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993), 902));
        assertEquals(1, searchInsert(Arrays.asList(11, 106, 143, 222, 247, 248, 310, 311, 399, 415, 450, 495, 575, 658, 813, 818, 855, 986), 77));

        assertEquals(0, search(Arrays.asList(1, 7, 67, 133, 178), 1));
        assertEquals(7, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 5));
        assertEquals(2, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 0));
        assertEquals(3, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 1));
        assertEquals(4, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 2));
        assertEquals(5, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 3));
        assertEquals(6, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 4));
        assertEquals(8, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 6));
        assertEquals(0, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 7));
        assertEquals(1, search(Arrays.asList(7, 8, 0, 1, 2, 3, 4, 5, 6), 8));
        assertEquals(8, search(Arrays.asList(101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100), 202));
    }


    public int searchInsert(List<Integer> a, int b) {
        int left = 0;
        int right = a.size() - 1;

        int mid = 0;
        while (left <= right) {

            mid = (left + right) / 2;

            if (a.get(mid) == b) {
                return mid;
            }
            else if (b < a.get(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        if (a.get(mid) < b) {
            return Math.min(a.size(), mid + 1);
        }
        else {
            return Math.max(0, mid );
        }
    }


    public int search(final List<Integer> a, int b) {

        int start = getStart(a);

        if (b >= a.get(start) && b <= a.get(a.size() - 1)) {
            return binarySearch(a, b, start, a.size() - 1);
        }

        return binarySearch(a, b, 0, start - 1);
    }

    private int getStart(List<Integer> a) {
        int left = 0;
        int right = a.size() - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (mid >= 1 && a.get(mid - 1) > a.get(mid)) {
                return mid;
            }
            else if (a.get(mid) < a.get(right)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return 0;
    }


    int binarySearch(List<Integer> a, int x, int left, int right) {

        int mid = 0;
        while (left <= right) {

            mid = (left + right) / 2;

            if (a.get(mid) == x) {
                return mid;
            }
            else if (x > a.get(mid)) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1 - mid;
    }
}
