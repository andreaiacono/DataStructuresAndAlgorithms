package recursion;

import org.junit.Test;
import util.Pair;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PalindromeConcatenation {

    /**
     * Given a list of words, find all pairs of unique indices such that the concatenation
     * of the two words is a palindrome.
     *
     * For example, given the list ["code", "edoc", "da", "d"], return [(0, 1), (1, 0), (2, 3)].
     */

    @Test
    public void test() {

        List<String> words = List.of("code", "edoc", "da", "d");

        List<Pair> expected = List.of(
                new Pair(0, 1),
                new Pair(1, 0),
                new Pair(2, 3)
        );
        assertEquals(expected, palindromePairs(words));
        assertEquals(expected, palindromePairs(words, new ArrayList<>()));
    }

    List<Pair> palindromePairs(List<String> words) {

        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.size(); j++) {
                if (i != j && isPalindrome(words.get(i) + words.get(j))) {
                    result.add(new Pair(i, j));
                }
            }
        }

        return result;
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    List<Pair> palindromePairs(List<String> words, List<Integer> tmp) {
        if (tmp.size() == 2) {
            if (isPalindrome(words.get(tmp.get(0)) + words.get(tmp.get(1)))) {
                return List.of(new Pair(tmp.get(0), tmp.get(1)));
            } else {
                return List.of();
            }
        }

        List<Pair> result = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (tmp.size() == 0 || (tmp.size() > 0 && tmp.get(0) != i)) {
                tmp.add(i);
                result.addAll(palindromePairs(words, tmp));
                tmp.remove(tmp.size() - 1);
            }
        }

        return result;
    }


}
