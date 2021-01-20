package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SumTo {

    /**
     * Given a list of integers and a number K, return which contiguous elements of the list sum to K.
     *
     * For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4], since 2 + 3 + 4 = 9.
     */

    @Test
    public void test() {
        int[] values = new int[]{1, 2, 3, 4, 5};
        assertEquals(List.of(2, 3, 4), sumTo(values, 9));

        values = new int[]{1, 2, 3, 4, 5, 6};
        assertEquals(List.of(), sumTo(values, 100));

        values = new int[]{ 3, 4, 5, 6};
        assertEquals(List.of(), sumTo(values, 2));

        values = new int[]{ 3, 4, 5, 6};
        assertEquals(List.of(3), sumTo(values, 3));

        values = new int[]{ 3, 4, 5, 6};
        assertEquals(List.of(6), sumTo(values, 6));
    }

    List<Integer> sumTo(int[] values, int k) {
       for (int i=0; i<values.length; i++) {
           int sum = values[i];
           int index = i+1;
           while (index < values.length && sum <= k) {
               sum += values[index++];
               if (sum == k) {
                   List<Integer> result = new ArrayList<>();
                   for (int j=i; j<index; j++) {
                       result.add(values[j]);
                   }
                   return result;
               }
           }
       }
       return List.of();
    }
}
