package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastWordLength {

    @Test
    public void test() {
        assertEquals(5, lengthOfLastWord("Word1    "));
        assertEquals(5, lengthOfLastWord("    Word1"));
        assertEquals(3, lengthOfLastWord("A bad code now"));
    }

    public int lengthOfLastWord(final String a) {

        if (a.length() == 0) {
            return 0;
        }
        int len = 0;
        int lastLen = 0;
        for (int i=0; i<a.length(); i++) {

            if (a.charAt(i) != ' ') {
                len ++;
                continue;
            }

            if (len > 0) {
                lastLen = len;
            }
            len = 0;
        }

        if (a.charAt(a.length()-1) != ' ') {
            lastLen = len;
        }

        return lastLen;
    }

}
