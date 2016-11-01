package topcoder;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RepeatStringEasy {

    Map<String,Integer> cache = new HashMap<>();

    @Test
    public void test() {
        assertEquals(4, maximalLength("frankfurt"));
        assertEquals(20, maximalLength("ananannnannandadnadndfsddddssdsdddnsndtttnennddnf"));
    }


    public int maximalLength(String s) {

        if (cache.containsKey(s)) return cache.get(s);

        int max = isSquare(s) ? s.length() : 0;
        for (int j=0; j<s.length(); j++) {
            int value = maximalLength(deleteAt(j, s));
            if (value > max) {
                max = value;
            }
        }
        cache.put(s, max);
        return max;
    }

    private String deleteAt(int index, String s) {
        if (index == 0) return s.substring(1);
        if (index == s.length()-1) return s.substring(0, s.length()-1);
        return s.substring(0, index) + s.substring(index+1);
    }

    private boolean isSquare(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) return false;
        return s.substring(0, s.length()/2).equals(s.substring(s.length()/2));
    }


//    public static void main(String[] args) {
//        RepeatStringEasy rep = new RepeatStringEasy();
//        System.out.println(rep.maximalLength("frankfurt"));
//    }
}
