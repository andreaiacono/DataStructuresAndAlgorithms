package topcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortingSubsets {

    @Test
    public void test() {
        assertEquals(2, getMinimalSize(new int[]{3, 2, 1}));
        assertEquals(0, getMinimalSize(new int[]{1, 2, 3, 4}));
        assertEquals(6, getMinimalSize(new int[]{4, 4, 4, 3, 3, 3}));
        assertEquals(7, getMinimalSize(new int[]{11, 11, 49, 7, 11, 11, 7, 7, 11, 49, 11}));
    }

    public int getMinimalSize(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int n: a) {
            list.add(n);
        }

        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        int counter =0;
        for (int j=0; j<list.size(); j++) {
            if (list.get(j) != sortedList.get(j)) {
                counter ++;
            }
        }
        return counter;
    }


}
