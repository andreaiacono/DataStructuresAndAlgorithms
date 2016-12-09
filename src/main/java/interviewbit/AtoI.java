package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtoI {

    @Test
    public void test() {
        assertEquals(123, atoi("123"));
        assertEquals(123, atoi("  123"));
        assertEquals(123, atoi("123   "));
        assertEquals(123, atoi("  123   "));
        assertEquals(-88297, atoi(" -88297 248252140B12 37239U4622733246I218  9 1303   44 A83793H3G2 1674443R591 4368 7  97"));
        assertEquals(0, atoi("- 5 88C340185Q  71  8079 834617385 2898422X5297Z6900"));
        assertEquals(0, atoi(" V515V 5793K 627 23815945269 1 1249794L 631 8755 7"));
        assertEquals(-2147483648, atoi( "-54332872018247709407 4 54"));
    }

    public int atoi(final String a) {

        int end = -1;
        int start = -1;
        boolean foundNumber = false;
        String a2 = a.trim();

        for (int j = 0; j < a2.length(); j++) {
            if (isValidNumber(a2.charAt(j)) && !foundNumber) {
                foundNumber = true;
                start = j;
                continue;
            }

            if (!isValidNumber(a2.charAt(j))) {
                if (foundNumber) {
                    end = j;
                    break;
                }
                else {
                    return 0;
                }
            }
        }

        String n = null;
        if (end == -1) {
            n = a2.substring(start);
        }
        else {
            n = a2.substring(start, end);
        }

        int isMinus = 1;
        if (n.charAt(0) == '-') {
            isMinus = -1;
            n = n.substring(1);
        }
        else if (n.charAt(0) == '+') {
            n = n.substring(1);
        }

        if (n.length() == 0) {
            return 0;
        }
        if (n.length() > 9) {
            return isMinus == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        int val = 0;
        for (int j = 0; j < n.length(); j++) {
            val += Math.pow(10, n.length() - 1 - j) * (n.charAt(j) - 48);
        }

        return val * isMinus;
    }

    boolean isValidNumber(char c) {
        return (c >= '0' && c <= '9') || c == '-' || c == '+';
    }
}
