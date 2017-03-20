package codingame;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class KolakoskiSequence {

    @Test
    public void test() {

        assertEquals("1221121221", getKolakoskiSequence(10, 1, 2));
    }

    String getKolakoskiSequence(int length, int digit1, int digit2) {

        StringBuilder sequence = new StringBuilder();
        appendN(sequence, digit1, digit1);
        boolean useDigitOne = false;
        int index = 1;
        while (sequence.length() < length) {
            int digit = useDigitOne ? digit1 : digit2;
            int val = digit1 == 1 && index == 1 ? digit2 : sequence.charAt(index)-48;
            appendN(sequence, digit, val);
            useDigitOne = !useDigitOne;
            index ++;
        }

        return sequence.toString().substring(0, length);
    }

    void appendN(StringBuilder builder, int digit, int length) {
        IntStream.range(0, length).forEach( val -> builder.append(digit));
    }
}
