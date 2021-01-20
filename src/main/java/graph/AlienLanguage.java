package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class AlienLanguage {


    /**
     * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
     */

    @Test
    public void test() {
        List<String> words = List.of("baa", "abcd", "abca", "cab", "cad");
        assertEquals(List.of('b', 'd', 'a', 'c'), alienOrder(words));

        words = List.of("caa", "aaa", "aab");
        assertEquals(List.of('c', 'a', 'b'), alienOrder(words));
    }


    List<Character> alienOrder(List<String> words) {

        return null;
    }

//    Set<String> powerSet(String s, String tmp) {
//
//        if (s.length() == 0) {
//            return Set.of(tmp);
//        }
//
//        return new HashSet<>() {{
//            addAll(powerSet(s.substring(1), tmp));
//            addAll(powerSet(s.substring(1), tmp + s.charAt(0)));
//        }};
//    }
}
