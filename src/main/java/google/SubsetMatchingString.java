package google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubsetMatchingString {

    /**
     * Interview #1
     * Given a text (in form of string) and a set of string, return the subset of matching
     * strings with the maximum length.
     * <p>
     * Input:
     * Text: the quick brown fox
     * Set (the, brown fox, fox, dog)
     * <p>
     * Output:
     * (The, brown fox)
     */

    @Test
    public void test() {
        List<String> words = List.of("the", "brown fox", "dog", "fox");
        String text = "the quick brown fox";

        assertTrue(longestSubset(words, text, new ArrayList<>()).contains("the"));
        assertTrue(longestSubset(words, text,  new ArrayList<>()).contains("brown fox"));
        assertFalse(longestSubset(words, text, new ArrayList<>()).contains("fox"));
    }

    List<String> longestSubset(List<String> words, String text, List<String> tmp) {
        System.out.println(words + ", " + text);
        if (words.size() == 0) {
            return new ArrayList<>(tmp);
        }

        List<String> result = null;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            List<String> tmpResult = null;
            List<String> lessWords = new ArrayList<>(words) {{ remove(word); }};
            if (text.contains(word)) {
                tmp.add(word);
                tmpResult = longestSubset(lessWords, remove(word, text), tmp);
                tmp.remove(tmp.size() - 1);
            }
            else {
                tmpResult = longestSubset(lessWords, text, tmp);
            }

            if (length(tmpResult) > length(result)) {
                result = tmpResult;
            }
        }
        return result;
    }

    String remove(String word, String text) {
        int index = text.indexOf(word);
        // check -1
        return text.substring(0, index) + text.substring(index + word.length());
    }

    int length(List<String> words) {
        if (words == null) {
            return 0;
        }
        return words.stream().mapToInt(word -> word.length()).sum();
    }

}
