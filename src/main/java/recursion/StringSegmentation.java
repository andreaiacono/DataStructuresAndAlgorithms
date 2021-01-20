package recursion;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class StringSegmentation {

    /**
     * You are given a dictionary of words and a large input string. You have to find out whether the
     * input string can be completely segmented into the words of a given dictionary
     * https://levelup.gitconnected.com/cracking-the-top-40-facebook-coding-interview-questions-185bab32489f
     */

    @Test
    public void test() {
        Set<String> dict = new HashSet<>() {{
            add("cat");
            add("apple");
            add("pear");
            add("tea");
            add("pie");
            add("a");
            add("aa");
            add("aaa");
            add("aaaa");
            add("aaaaa");
            add("aaaaaa");
            add("aaaaaaa");
        }};

        String word = "applepie";
        assertTrue(isSegmentable(word, dict, 0));

        word = "applepearpie";
        assertTrue(isSegmentable(word, dict, 0));

        word = "catpiecat";
        assertTrue(isSegmentable(word, dict, 0));

        word = "catte";
        assertTrue(isSegmentable(word, dict, 0));

        word = "cattea";
        assertFalse(isSegmentable(word, dict, 0));

        word = "piecats";
        assertFalse(isSegmentable(word, dict, 0));

        word = "pieandcat";
        assertFalse(isSegmentable(word, dict, 0));

        word = "pieandcat";
        assertFalse(isSegmentable(word, dict, 0));

        word = "b";
        assertFalse(isSegmentable(word, dict, 0));

        word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assertTrue(isSegmentable(word, dict, 0));


    }

    boolean isSegmentable(String word, Set<String> dict, int index) {
        if (index == word.length()) {
            return true;
        }

        boolean result = false;
        for (int i=index; i<word.length(); i++) {
            String substring = word.substring(index, i+1);
            if (dict.contains(substring)) {
                result = result || isSegmentable(word, dict, i+1);
            }
        }
        return result;
    }
}
