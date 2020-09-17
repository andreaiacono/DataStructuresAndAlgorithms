package streaming;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class Mode {

    /**
     * Mode in a stream of integers (running integers)
     * Given that integers are being read from a data stream.
     * Find the mode of all the elements read so far starting from the first integer till the last integer.
     * <p>
     * Mode is defined as the element which occurs the maximum time. If two or more elements have the same
     * maximum frequency, then take the one with the last occurrence.
     */

    @Test
    public void test() throws Exception {

        insertValue(0);
        assertEquals(0, getMode());
        insertValue(1);
        assertEquals(1, getMode());
        assertEquals(1, getMode());
        insertValue(0);
        assertEquals(0, getMode());
        insertValue(1);
        assertEquals(1, getMode());
        insertValue(1);
        assertEquals(1, getMode());
        insertValue(2);
        assertEquals(1, getMode());
        insertValue(2);
        assertEquals(1, getMode());
        insertValue(2);
        assertEquals(2, getMode());
    }

    Map<Integer, Integer> values = new HashMap<>();
    int mode = 0;

    void insertValue(int value) {
        int newVal = 1;
        if (values.containsKey(value)) {
            newVal = values.get(value) + 1;
        }
        values.put(value, newVal);
        if (newVal >= values.get(mode)) {
            mode = value;
        }
    }

    int getMode() throws Exception {
        if (values.keySet().size() == 0) {
            throw new Exception();
        }

        return mode;
    }

}
