package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LookAndSay {

    @Test
    public void test() {
        assertEquals("111221", las(5));
        assertEquals("13112221", las(7));
    }

    String las(int n) {
        String result = "1";
        for (int i=0; i<n-1; i++) {
            result = las(result);
        }
        return result;
    }

    String las(String str) {
        if (str.length() == 1) {
            return "1" + str;
        }
        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        for (int i=0; i<str.length()-1; i++) {
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                i++;
            }
            result.append(i-startIndex+1).append(str.charAt(i));
            startIndex = i+1;
        }
        if (str.charAt(str.length()-1) != str.charAt(str.length()-2) ) {
            result.append("1").append(str.charAt(str.length()-1));
        }

        return result.toString();
    }

}
