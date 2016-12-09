package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MaximumThreeProduct {

    @Test
    public void Test() {
        List<Integer> l = Arrays.asList(0, -1, 3, 100, -70, -50 );
        ArrayList<Integer> a = new ArrayList<>(l);
//        assertEquals(350000, maxp3(a));
//
//        l = Arrays.asList( -1, -2, -3, -4, -5);
//        a = new ArrayList<>(l);
//        assertEquals(-6, maxp3(a));
//
//        l = Arrays.asList( 0, -1, -2, -3 );
//        a = new ArrayList<>(l);
//        assertEquals(0, maxp3(a));

        l = Arrays.asList( -40, -15, -49, -17, -8, -39, 86, -43, 47, 25, 58, -35, -38, -87, -11, 1, -13, -73, -24, 72, 31, 40, 5, -16, -32, 96, 69, 54, -23 );
        a = new ArrayList<>(l);
        assertEquals(609696, maxp3(a));
    }

    public int maxp3(ArrayList<Integer> a) {
        PriorityQueue<Integer> negative = new PriorityQueue<Integer>((i1, i2) -> -Integer.compare(i1, i2));
        PriorityQueue<Integer> positive = new PriorityQueue<Integer>((i1, i2) -> Integer.compare(i1, i2));
        int minimum = 3;

        boolean hasZero = false;
        for (int i=0; i<a.size(); i++) {
            int n = a.get(i);

            if (n == 0) {
                hasZero = true;
                continue;
            }

            if (negative.size() < minimum) {
                negative.add(n);
                positive.add(n);
                continue;
            }

            if (negative.peek() > n) {
                negative.poll();
                negative.add(n);
            }
            if (positive.peek() < n) {
                positive.poll();
                positive.add(n);
            }
        }

        // discard the first element
        negative.poll();
        int negProd = negative.poll() * negative.poll();
        int thirdPos = positive.poll();
        int secondPos = positive.poll();
        int firstPos = positive.poll();

        if (firstPos < 0 && hasZero) {
            return 0;
        }

        if (firstPos < 0 || thirdPos * secondPos > negProd ) {
            return firstPos * secondPos * thirdPos;
        }

        return negProd * firstPos;
    }
}
