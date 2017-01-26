package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/word-break/
 */
public class WordBreak {

    @Test
    public void test() {

        ArrayList<String> dict = new ArrayList<>(Arrays.asList("interview", "my", "trainer"));
        assertEquals(1, wordBreak("myinterviewtrainer", dict));
    }

    Map<String, Integer> cache = new HashMap<>();

    public int wordBreak(String a, ArrayList<String> b) {
        System.out.println("calling with [" + a + "] on " + b);
        if (cache.containsKey(a)) {
            return cache.get(a);
        }

        if (a.equals("")) {
            cache.put(a, 1);
            return 1;
        }

        for (int i = 0; i < a.length()+1; i++) {
            if (b.contains(a.substring(0, i))) {
                int result = wordBreak(a.substring(i), b);
                if (result == 1) {
                    return result;
                }
            }
        }

        cache.put(a, 0);
        return 0;
    }
}
