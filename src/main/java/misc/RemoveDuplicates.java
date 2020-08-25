package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicates {

    @Test
    public void test() {

        int[] values = new int[] {1, 2, 2};
        int result = removeDuplicates(values);
        assertEquals(2, result);
        assertEquals(1, values[0]);
        assertEquals(2, values[1]);

        values = new int[] {0,0,1,1,1,2,2,3,3,4};
        result = removeDuplicates(values);
        assertEquals(5, result);
        assertEquals(0, values[0]);
        assertEquals(1, values[1]);
        assertEquals(2, values[2]);
        assertEquals(3, values[3]);
        assertEquals(4, values[4]);
    }

    int removeDuplicates(int[] values) {
        int writeIndex = 1;
        for (int i=1; i<values.length; i++) {
            while (i < values.length && values[i-1] == values[i]) {
                i++;
            }
            if (i < values.length) {
                values[writeIndex++] = values[i];
            }
        }
        return writeIndex;
    }
}
