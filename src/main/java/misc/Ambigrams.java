package misc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Ambigrams {

/**
 * you have a list of paired ambigram letter, like a<->e, b<->q, i<->I, y<->h, h<->h, m<->w …
 * Given a word, return true if it's a ambigram, like swims(true), pod(true)
 */

    Map<Character, Character> ambigrams = new HashMap<>() {{
        put('a', 'e');
        put('b', 'q');
        put('p', 'd');
        put('i', 'i');
        put('o', 'o');
        put('s', 's');
        put('y', 'h');
        put('m', 'w');
        put('e', 'a');
        put('q', 'b');
        put('h', 'y');
        put('w', 'm');
        put('d', 'p');
    }};

    @Test
    public void test() {
        assertTrue(isAmbigram("swims"));
        assertTrue(isAmbigram("pod"));
        assertTrue(isAmbigram("pood"));
        assertFalse(isAmbigram("pods"));
        assertTrue(isAmbigram("spods"));
        assertTrue(isAmbigram("pispodsid"));
    }

    boolean isAmbigram(String s) {
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (! (ambigrams.containsKey(c) && s.charAt(s.length()-i-1) == ambigrams.get(c)) ) {
                return false;
            }
        }

        return true;
    }
}
