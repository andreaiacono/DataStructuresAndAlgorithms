package misc;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UnscrambleSentence {


    Map<String, String> dictionary = new HashMap<String, String>() {{
        put(sort("hello"), "hello");
        put(sort("to"), "to");
        put(sort("the"), "the");
        put(sort("world"), "world");
    }};


    @Test
    public void test() {
        assertEquals("hello to the world", unscramble("elhloothtedrowl"));
        assertEquals("to world", unscramble("toworld"));
        assertEquals("to world", unscramble("otdrowl"));
    }

    String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    String isPresent(String s) {
        String sorted = sort(s);
        if (dictionary.containsKey(sorted)) {
            return dictionary.get(sorted);
        }

        return null;
    }

    String unscramble(String s) {
        StringBuilder result = new StringBuilder();

        int wordStart = 0;
        for (int j = 2; j <= s.length(); j++) {
            String word = isPresent(s.substring(wordStart, j));
            if (word != null) {
                result.append(word).append(" ");
                wordStart = j;
            }
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}
