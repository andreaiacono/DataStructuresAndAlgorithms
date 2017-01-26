package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.Assert.assertEquals;

public class MinJumps {

    @Test
    public void test() {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 4, -1, 2));
        assertEquals(result, minJumps(input, 2));

        result = new ArrayList<>();
        input = new ArrayList<>(Arrays.asList(307, 81, 939, -1, -1));
        assertEquals(result, minJumps(input, 1));

        result = new ArrayList<>(Arrays.asList(1, 5, 9, 13, 17));
        input = new ArrayList<>(Arrays.asList(387, 790, 528, -1, 718, 380, 894, 858, 772, 745, 893, 611, 54, 254, 748, 663, 273 ));
        assertEquals(result, minJumps(input, 4));

        result = new ArrayList<>(Arrays.asList());
        input = new ArrayList<>(Arrays.asList(621, 986, 383, -1, -1, 181, -1, -1, -1, -1, 904));
        assertEquals(result, minJumps(input, 4));

        input = new ArrayList<>(Arrays.asList( 2, 3, 1, 1, 4));
        assertEquals(2, jump(input));

        input = new ArrayList<>(Arrays.asList( 33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28));
        assertEquals(3, jump(input));
    }

    public int jump(ArrayList<Integer> a) {

        int[] jumps = new int[a.size()];
        for (int i=1; i<jumps.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<a.size(); i++) {
            int steps = a.get(i);
            for (int j=1; j<=steps && i+j < a.size(); j++) {
                if (jumps[i+j] > jumps[i] + 1 && jumps[i] != Integer.MAX_VALUE) {
                    jumps[i+j] = jumps[i] + 1;
                }
            }
        }

        System.out.println("Jumps= " + Arrays.toString(jumps));

        if (jumps[a.size()-1] == Integer.MAX_VALUE) {
            return -1;
        }

        return jumps[a.size()-1];
    }


    public ArrayList<Integer> minJumps(ArrayList<Integer> a, int b) {

        int[] from = new int[a.size()];
        int[] cost = new int[a.size()];
        from[0] = -1;
        cost[0] = a.get(0);

        for (int i = 1; i < a.size(); i++) {

            if (a.get(i) != -1) {
                int min = MAX_VALUE;
                int minIndex = -1;
                for (int j = i - 1; j >= i - b && j >= 0; j--) {
                    if (cost[j] < min) {
                        min = cost[j];
                        minIndex = j;
                    }
                }
                cost[i] = min + ((minIndex > -1) ? a.get(i) : 0);
                from[i] = minIndex;
            }
            else {
                cost[i] = MAX_VALUE;
                from[i] = -1;
            }
        }

        System.out.println("cost=" + Arrays.toString(cost) + " from=" + Arrays.toString(from));
        ArrayList<Integer> result = new ArrayList<>();
        if (cost[a.size() - 1] == MAX_VALUE) {
            return result;
        }

        int index = a.size() - 1;
        result.add(a.size());
        while (index > 0) {
            result.add(from[index] + 1);
            index = from[index];
        }

        Collections.reverse(result);
        return result;
    }

}
