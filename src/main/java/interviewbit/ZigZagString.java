package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZigZagString {

    @Test
    public void test() {
        assertEquals("B", convert("B", 1));
    }

    public String convert(String a, int b) {

        if (b == 1) {
            return a;
        }

        StringBuffer[] rows = new StringBuffer[b];
        for (int i=0; i<b; i++) {
            rows[i] = new StringBuffer();
        }
        int rowIndex = 0;
        int length = b-1;
        boolean isGoingDown = false;
        for (int i=0; i<a.length(); i++) {
            rows[rowIndex].append(a.charAt(i));
            if (i % length == 0) {
                isGoingDown = !isGoingDown;
            }
            rowIndex = rowIndex + (isGoingDown ? 1 : -1);
        }

        StringBuffer result = new StringBuffer();
        for (int i=0; i<b; i++) {
            result.append(rows[i]);
        }

        return result.toString();
    }
}
