package dynamicprogramming;

import org.junit.Test;

// Dynamic programming for coding interviews
// Example 9.3
public class StringInterleaving {

    @Test
    public void test() {

        String s1 = "xyz";
        String s2 = "abcd";
        String s3 = "xabycdz";
        s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        s2 = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        s3 = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        assert isInterleaved(s1, s2, s3,0, 0 ,0);

        s1 = "abc";
        s2 = "def";
        s3 = "xzy";
        assert !isInterleaved(s1, s2, s3, 0, 0 ,0);
    }
    boolean isInterleaved(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index1 == s1.length() && index2 == s2.length()) {
            return true;
        }

        boolean result = false;
        if (index1 < s1.length() && s3.charAt(index3) == s1.charAt(index1)) {
            result = result || isInterleaved(s1, s2, s3, index1 + 1, index2, index3 + 1);
        }
        if (index2 < s2.length() && s3.charAt(index3) == s2.charAt(index2)) {
            result = result || isInterleaved(s1, s2, s3, index1, index2 + 1, index3 + 1);
        }
        return result;
    }

//    // wrong: it assumes not overlapping chars in s1 and s2
//    boolean isInterleaved(String s1, String s2, String s3) {
//        // checks for lengths, nulls, etc
//        // assumes strings are utf8
//        int index1 = 0;
//        int index2 = 0;
//
//        for (int i=0; i<s3.length(); i++) {
//            if (index1 < s1.length() && s3.charAt(i) == s1.charAt(index1)) {
//                index1++;
//            }
//            else if (index2 < s2.length() && s3.charAt(i) == s2.charAt(index2)) {
//                index2++;
//            }
//            else {
//                return false;
//            }
//        }
//        return true;
//    }

}
