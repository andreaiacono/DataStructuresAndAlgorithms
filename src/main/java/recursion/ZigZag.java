package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ZigZag {

    public static void main(String[] args) {
        ArrayList n = new ArrayList();
        n.addAll(Arrays.asList(374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244));
//        assert (isZigZag(Arrays.asList(new Integer[]{1})));
//        assert (isZigZag(Arrays.asList(new Integer[]{2, 1}));
//        assert (!isZigZag(Arrays.asList(new Integer[]{1, 1}));
//        assert (isZigZag(new Integer[]{1, 7, 4, 9, 2, 5}));
//        assert (!isZigZag(new Integer[]{1, 7, 4, 9, 2, 1}));
        int result = getLongestSequence(n);
        assert (result == 36);
    }

    private static boolean isZigZag(List<Integer> n) {

        if (n.size()== 1) {
            return true;
        }
        if (n.size() == 2) {
            return n.get(0) != n.get(1);
        }
        boolean growing = n.get(0) < n.get(1);
        for (int j = 0; j < n.size() - 1; j++) {
            if ((growing && n.get(j) < n.get(j + 1)) || (!growing && n.get(j) > n.get(j + 1))) {
                growing = !growing;
            }
            else {
                return false;
            }
        }
        return true;
    }

    static int M = 0;
    static HashMap<List<Integer>, Integer> cache = new HashMap<>();

    public static int getLongestSequence(List<Integer> n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n.size() <= 2) {
            return isZigZag(n) ? 2 : 1;
        }

        if (isZigZag(n)) {
            if (n.size() > M) {
                System.out.println("IsZigZag " + n + " [" + n.size()+ "]");
                M = n.size();
            }
            return n.size();
        }

        int longest = 0;
        for (int j = 0; j < n.size(); j++) {
            int removedValue = n.remove(j);
            int localMax = getLongestSequence(n);
            if (localMax > longest) {
                longest = localMax;
            }
            n.add(j, removedValue);
        }
        cache.put(n, longest);
        return longest;
    }

    private static Integer[] removeElementAtIndex(Integer[] n, int index) {
        Integer b[] = new Integer[n.length - 1];
        int counter = 0;
        for (int j = 0; j < n.length; j++) {
            if (j == index) {
                continue;
            }
            b[counter++] = n[j];
        }
        return b;
    }

}
