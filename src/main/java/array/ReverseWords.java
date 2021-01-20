package array;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ReverseWords {


    /**
     * Reverse the order of words in a given sentence (an array of characters).
     * https://levelup.gitconnected.com/cracking-the-top-40-facebook-coding-interview-questions-185bab32489f
     */


    @Test
    public void test() {
        String s = "hello interview world";
        String expected = "olleh weivretni dlrow";

        assertEquals(expected, reverseWords(s));
    }

    String reverseWords(String s) {
        String[] tokens = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String token: tokens) {
            result.append(reverse(token)).append(" ");
        }
        return result.toString().trim();
    }

    private String reverse(String token) {
        StringBuilder reversed = new StringBuilder();
        for (int i=token.length()-1; i>=0;  i--) {
            reversed.append(token.charAt(i));
        }
        return reversed.toString();
    }
}
