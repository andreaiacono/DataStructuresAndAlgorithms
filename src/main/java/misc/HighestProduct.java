package misc;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HighestProduct {

    @Test
    public void test() {
        assertEquals(35, highest(0, 5, 7));
        assertEquals(35, highest(-1, 5, 7));
        assertEquals(35, highest(-1, -5, 7));
        assertEquals(35, highest(-1, -5, -7));
        assertEquals(0, highest(0, 0, -7));
        assertEquals(49, highest(0, -7, -7));
        assertEquals(49, highest(-7, -7, 0));
        assertEquals(7, highest(0, 0, 7));
        assertEquals(0, highest(0, 0, 0));
        assertEquals(7, highest(7, 0, 0));
        assertEquals(0, highest(-7, 0, 0));
        assertEquals(70, highest(5, 2, 7));
    }

    int highest(int n1, int n2, int n3) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        if (n1 > 0) {
            pos.add(n1);
        }
        else {
            neg.add(n1);
        }
        if (n2 > 0) {
            pos.add(n2);
        }
        else {
            neg.add(n2);
        }
        if (n3 > 0) {
            pos.add(n3);
        }
        else {
            neg.add(n3);
        }

        if (pos.size() == 3) {
            return n1*n2*n3;
        }
        else if (pos.size() == 2) {
            return pos.get(0) * pos.get(1);
        }
        else if (neg.size() == 2) {
            if (neg.get(0) == 0 || neg.get(1) == 0) {
                return pos.get(0);
            }
            return n1*n2*n3;
        }
        else {
            Collections.sort(neg);
            return neg.get(0) * neg.get(1);
        }
    }
}
