package dynamicprogramming;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SubsetSum {

    /**
     * Given a list of positive integers ls=(1..n) and an integer k, is there some subset of ls that sums to exactly k?
     */


    @Test
    public void test() {

        LocalDate first = LocalDate.of(2020, 10, 1);
        for (int i = 0; i < 61; i++) {
            System.out.println(first.getDayOfWeek() + "\t\t" + first);
            first = first.plusDays(1);
        }

        List<Integer> values = List.of(4, 7, 3);

        assertTrue(subsetSum(values, 4, 0));
        assertTrue(subsetSum(values, 7, 0));
        assertTrue(subsetSum(values, 3, 0));
        assertTrue(subsetSum(values, 10, 0));
        assertTrue(subsetSum(values, 11, 0));
        assertFalse(subsetSum(values, 12, 0));
        assertFalse(subsetSum(values, 9, 0));
        assertFalse(subsetSum(values, 6, 0));
    }

    private boolean subsetSum(List<Integer> values, int sum, int index) {
        if (sum == 0) {
            return true;
        }

        for (int i = index; i < values.size(); i++) {
            int value = values.get(i);
            if (sum >= value) {
                if (subsetSum(values, sum - value, i+1)) {
                    return true;
                }
            }
        }

        return false;
    }


}
