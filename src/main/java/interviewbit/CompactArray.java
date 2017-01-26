package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/seats/
 */
public class CompactArray {

    @Test
    public void test() {
        assertEquals(5, seats("....x..xx...x.."));
    }

    public int seats(String a) {

        int n = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) == 'x') {
                n++;
            }
        }

        int max = 0;
        int bestWindowStartIndex = 0;
        int window = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) == 'x') {
                window ++;
            }
            if (i >= n && a.charAt(i-n) == 'x') {
                window--;
            }

            if (window > max) {
                max = window;
                bestWindowStartIndex = i-n+1;
            }
        }
        System.out.println("best start="  + bestWindowStartIndex);

        int toFind = n - max;
        System.out.println("to find="  + toFind);

        int moves = 0;
        int counter = 0;

        int startIndex = bestWindowStartIndex;
        int endIndex = bestWindowStartIndex + n;
        int left = bestWindowStartIndex-1;
        int right = bestWindowStartIndex + n +1;

        while (counter < toFind && left > 0 && right < a.length()) {
            int dl = a.charAt(left) == 'x' ? (startIndex - left)-1 : -1;
            int dr = a.charAt(right) == 'x' ? (right - endIndex)-1 : -1;

            if (dl > -1) {
                moves += dl;
                startIndex--;
                counter ++;
                if (counter == toFind) {
                    return moves;
                }
            }
            if (dr > -1) {
                moves += dr;
                counter++;
                endIndex++;
                if (counter == toFind) {
                    return moves;
                }
            }

            left--;
            right++;
        }


        return moves % 10000003;
    }
}
