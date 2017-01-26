package interviewbit;

import org.junit.Test;

import java.util.ArrayList;

public class PalindromePartitioning {

    @Test
    public void test() {
        System.out.println(isPalindrome("a"));
        System.out.println(partition("efe"));
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        return part(a, new ArrayList<>(), new ArrayList<>());
    }

    public ArrayList<ArrayList<String>> part(String s, ArrayList<String> subResult, ArrayList<ArrayList<String>> result) {
        if (s.equals("")) {
            result.add(new ArrayList(subResult));
            return result;
        }

        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                subResult.add(sub);
                part(s.substring(i), subResult, result);
                subResult.remove(sub);
            }
        }

        return result;
    }

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
