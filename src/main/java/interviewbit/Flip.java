package interviewbit;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Flip {

    @Test
    public void test() {
        String a = "1101010001";
        ArrayList<Integer> result = new ArrayList<Integer>() {{
            add(3);
            add(9);
        }};

        assertEquals(result, flip(a));

        a = "1111";
        result = new ArrayList<>();
        assertEquals(result, flip(a));

        a = "0111000100010";
        result = new ArrayList<Integer>() {{
            add(5);
            add(11);
        }};
        assertEquals(result, flip(a));
    }


    ArrayList<Integer> flip(String a) {

        ArrayList<Integer> result = new ArrayList<>();

        if (a == null) {
            return result;
        }

        if (a.indexOf("0") < 0) {
            return result;
        }

        if (a.length() == 1) {
            result.add(1);
            result.add(1);
            return result;
        }

        int[] bits = new int[a.length()];
        for (int j=0; j<a.length(); j++) {
            if (a.charAt(j) == '0') {
                bits[j] = 1;
            }
            else {
                bits[j] = -1;
            }
        }

        int globalMax = bits[0];
        int partialMax = bits[0];
        int start = 0;
        int end = 0;

        for (int i = 1; i < bits.length; i++) {
            int partialStart = -1;

            if (partialMax <0) {
                partialStart = i;
                partialMax = bits[i];
            }
            else {
                partialMax += bits[i];
            }

            if (globalMax < partialMax) {
                globalMax = partialMax;
                if (partialStart != -1) {
                    start = partialStart;
                }
                end = i;
            }
        }

        result.add(start+1);
        result.add(end+1);

        return result;
    }

    public ArrayList<Integer> wrongFlip(String A) {

        int counter = 0;
        int lastOne = -1;
        int left = -1;
        int right = -1;
        int max = 0;

        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) == '0') {
                counter ++;
                continue;
            }

            if (counter > max) {
                max = counter;
                left = lastOne+1;
                right = i-1;
            }

            lastOne = i;
            counter = 0;
        }

        ArrayList<Integer> result = new ArrayList<>();
        if (max > 0) {
            result.add(left+1);
            result.add(right+1);

        }
        return result;
    }
}
