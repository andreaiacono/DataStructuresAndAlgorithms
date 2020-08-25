package misc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AllPalindroms {

    @Test
    public void test() {
        String test = "abcd";
//        System.out.println(allPals(test));
        assertEquals(5, allPals(test).size());

        test = "ABCCBD";
//        System.out.println(allPals(test));
        System.out.println(allPalsOpt(test, 0, ""));
        assertEquals(7, allPals(test).size());

    }

    // cardinality of powerset: 2^n
    // O(n*2^n)

    List<String> allPals(String str) {
        return allPals(str, 0, "").stream().filter(s -> isPalindrome(s)).collect(Collectors.toList());
    }

    boolean isPalindrome(String s) {
        for (int i=0; i<s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1)) {
                return false;
            }
        }
        return true;
    }

    Set<String> allPals(String s, int index, String tmp) {
        if (index == s.length()) {
            return Set.of(tmp);
        }
        return new HashSet<>() {{
            addAll(allPals(s, index + 1, tmp));
            addAll(allPals(s, index + 1, tmp + s.charAt(index)));
        }};
    }

    Set<String> allPalsOpt(String s, int index, String tmp) {
        System.out.println("index=" + index + " tmp="+index);
        if (index == s.length()) {
            return Set.of(tmp);
        }
        return new HashSet<>() {{
            addAll(allPalsOpt(s, index + 1, tmp));
            if (tmp.length() == 0 || tmp.charAt(0) == s.charAt(index)) {
                addAll(allPalsOpt(s, index + 1, tmp + s.charAt(index)));
            }
        }};
    }

}
