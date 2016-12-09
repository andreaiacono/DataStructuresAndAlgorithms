package pramp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MergePackages {

    @Test
    public void test() {
        int[] a = new int[] { 4, 3};
        int limit = 8;
        assertTrue(Arrays.equals(new int[] {-1}, mergePackages(a, limit) ));

        a = new int[] { 4, 3, 4};
        limit = 8;
        System.out.println(Arrays.toString( mergePackages(a, limit) ));
        assertTrue(Arrays.equals(new int[] {2, 0}, mergePackages(a, limit) ));
    }

    int[] mergePackages(int[] a, int limit) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            if (map.containsKey(a[i])) {
                return new int[] {i, map.get(a[i])};
            }
            map.put(limit - a[i], i);
        }

        return new int[] {-1};
    }

}
