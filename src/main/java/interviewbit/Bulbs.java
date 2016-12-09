package interviewbit;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Bulbs {

    @Test
    public void test() {
        assertEquals(4,bulbs(Arrays.asList(1, 1, 0, 0, 1, 1, 0, 0, 1)));
    }

    public int bulbs(List<Integer> a) {


        int counter = 0;
        for (int i=0; i<a.size(); i++) {
            if (a.get(i) == 0) {
                flipFrom(i, a);
                counter ++;
            }
        }

        return counter;
    }

    void flipFrom(int x, List<Integer> a) {
        for (int i=x; i<a.size(); i++) {
            a.set(i, (a.get(i) + 1) % 2);
        }
    }
}
