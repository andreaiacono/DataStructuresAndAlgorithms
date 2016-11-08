package topcoder;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CyclicWords {

    @Test
    public void test() {
        assertEquals(2, differentCW(new String[]{"picture", "turepic", "icturep", "word", "ordw"}));
        assertEquals(3, differentCW(new String[]{"ast", "ats", "tas", "tsa", "sat", "sta", "ttt"}));
        assertEquals(4, differentCW(new String[]{"aaaa", "aaa", "aa", "aaaa", "aaaaa"}));
    }

    int differentCW(String[] words) {
        Set<String> wordsSet = new HashSet<>();
        for (String word: words) {
            boolean isPresent = false;
            for (String wordInSet: wordsSet) {
                if (isCyclic(word, wordInSet)) {
                    isPresent = true;
                }
            }
            if (!isPresent) {
                wordsSet.add(word);
            }
        }
        return wordsSet.size();
    }

    public boolean isCyclic(String word1, String word2) {
        return word1.length() == word2.length() && (word1+ word1).contains(word2);
    }
}
