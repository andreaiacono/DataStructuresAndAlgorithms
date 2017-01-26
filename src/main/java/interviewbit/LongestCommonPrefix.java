package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {

    @Test
    public void test() {
        ArrayList<String> ss = new ArrayList<>(Arrays.asList("ab", "ac", "bc"));
        assertEquals(4, LCPrefix(ss, 1));
    }

    public int LCPrefix(ArrayList<String> a, int b) {
        int n = a.size();

        int counter = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                if (lcp(a.subList(i, j)) >= b) {
                    counter ++;
                }
                else {
                    break;
                }
            }
        }

        return counter % 1000000007;
    }

    int lcp(List<String> strings) {
        System.out.println("calling lcp with " + strings);
        int index = 0;
        while (true) {
            if (index >= strings.get(0).length()) {
                System.out.println("Returning " + index + " for LCP " + strings);
                return index;
            }
            char c = strings.get(0).charAt(index);
            for (String s: strings) {
                if (index >= s.length() || s.charAt(index) != c) {
                    System.out.println("Returning " + index + " for LCP " + strings);
                    return index;
                }
            }
            index ++;
        }
    }
}
