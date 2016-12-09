package interviewbit;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MinStepsInGrid {

    @Test
    public void test() {
        ArrayList<Integer> x = new ArrayList<Integer>() {{
            add(0);
            add(1);
            add(2);
        }};

        ArrayList<Integer> y = new ArrayList<Integer>() {{
            add(0);
            add(1);
            add(2);
        }};

        assertEquals(2, coverPoints(x, y));

        x = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(0);
        }};

        y = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(0);
        }};

        assertEquals(2, coverPoints(x, y));


        x = new ArrayList<Integer>() {{
            add(10);
            add(0);
        }};

        y = new ArrayList<Integer>() {{
            add(0);
            add(0);
        }};

        assertEquals(9, coverPoints(x, y));


    }

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> x, ArrayList<Integer> y) {

        if (x.size() != y.size()) {
            return -1;
        }
        int distance = 0;

        for (int i = 1; i < x.size(); i++) {
            int x1 = x.get(i - 1);
            int y1 = y.get(i - 1);
            int x2 = x.get(i);
            int y2 = y.get(i);
            distance += Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
        }

        return distance;
    }

}
