package misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FormPalindrome {

    static Set<Character> alphabet;
    static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        assert(isPalindrome("abba"));
        assert(isPalindrome("aba"));
        assert(isPalindrome("anilina"));
        String s = "anasdad";
        System.out.println("Min of " + s + " = " + getMinChars(s));
    }

    public static int getMinChars(String s) {
        alphabet = getAlphabetFrom(s);
        return recurse(s, s, 0);
    }

    private static int recurse(String original, String s, int steps) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (isPalindrome(s)) {
//            System.out.println("PALINDORMO:" + s);
            return steps;
        }

        if (s.length() > original.length() * 2-1) {
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;
        for (int j=0; j<s.length()+1; j++) {
            for (Character c: alphabet) {
                int result = recurse(original, insertCharAt(j, c, s), steps+1);
                if (result < min) {
                    min = result;
                }
            }
        }

        cache.put(s, min);
        return min;
    }

    private static boolean isPalindrome(String s) {
        for (int j=0; j<s.length(); j++) {
            if (s.charAt(j) != s.charAt(s.length()-j-1)) {
                return false;
            }
        }
        return true;
    }

    private static Set<Character> getAlphabetFrom(String s) {
        Set<Character> result = new HashSet<>();
        for (int j=0; j<s.length(); j++) {
            result.add(s.charAt(j));
        }
        return result;
    }

    private static String insertCharAt(int j, char c, String s) {
        if (j == 0) {
            return c + s;
        }
        if (j == s.length()+1) {
            return s + c;
        }
        return s.substring(0, j) + c + s.substring(j);
    }


}
