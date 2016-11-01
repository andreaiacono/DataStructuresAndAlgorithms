package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringCompression {

    public static String compress(String value) {

        if (value == null || value.length() < 2) {
            return value;
        }

        StringBuilder result = new StringBuilder();
        int j=1;
        int count = 1;
        char previous = value.charAt(0);

        while (j < value.length()) {
            if (value.charAt(j) != previous) {
                result.append(previous).append(count);
                count = 0;
            }

            previous = value.charAt(j);
            count ++;
            j++;
        }
        result.append(previous).append(count);

        return result.length() >= value.length() ? value : result.toString();
    }

    @Test
    public void test() {
        assertNull(compress(null));
        assertEquals("a", compress("a"));
        assertEquals("aa", compress("aa"));
        assertEquals("a3", compress("aaa"));
        assertEquals("ab", compress("ab"));
        assertEquals("aab", compress("aab"));
        assertEquals("a4b1", compress("aaaab"));
        assertEquals("a1b4", compress("abbbb"));
        assertEquals("a4b4", compress("aaaabbbb"));
        assertEquals("a3b1c1d5", compress("aaabcddddd"));
    }
}
