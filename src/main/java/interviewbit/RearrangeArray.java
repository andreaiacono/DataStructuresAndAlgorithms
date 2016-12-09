package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RearrangeArray {

    @Test
    public void test() {

        List<Integer> input = new ArrayList<Integer>() {{
            add(4);
            add(0);
            add(2);
            add(1);
            add(3);
        }};
        List<Integer> result = new ArrayList<Integer>() {{
            add(3);
            add(4);
            add(2);
            add(0);
            add(1);
        }};
        arrange(input);
        assertEquals(result, input);

        input = new ArrayList<Integer>() {{
            add(2);
            add(4);
            add(1);
            add(0);
            add(3);
        }};
        result = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(4);
            add(2);
            add(0);
        }};
        arrange(input);
        assertEquals(result, input);
    }

    public void arrange(List<Integer> a) {
        int n = a.size();
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);
        }
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) / n);
        }
    }

}
