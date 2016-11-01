package quiz;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/01/16
 * Time: 10.32
 */
public class ArrayAndStrings {

    public static void main(String[] args) {

        String test = "andrez";
        String test2 = "andreza";
        System.err.println("hasUniqueChars: " + hasUniqueChars(test));
        System.err.println("hasUniqueCharsInPlace: " + hasUniqueCharsInPlace(test));
        System.err.println("reverse: " + reverse(test));
        System.err.println("recursive reverse: " + recursiveReverse(test));
        System.err.println("are perumtation: " + arePermutation(test, test));
        System.err.println("are perumtation: " + arePermutation(test, test2));
    }

    public static boolean hasUniqueChars(String val) {

        boolean isPresent[] = new boolean['z'-'a'+1];

        for (int j=0; j<val.length(); j++) {
            if (isPresent[val.charAt(j) - 'a']) {
                return false;
            }
            isPresent[val.charAt(j)-'a'] = true;
        }

        return true;
    }

    public static boolean hasUniqueCharsInPlace(String val) {

        for (int j=0; j<val.length(); j++) {
            char c = val.charAt(j);
            for (int i=0; i<val.length(); i++) {
                if (i!= j && val.charAt(i) == c) {
                    return false;
                }
            }
        }

        return true;
    }

    public static String reverse(String val) {

        StringBuffer buffer = new StringBuffer();
        for (int j=val.length()-1; j>=0; j--) {
            buffer.append(val.charAt(j));
        }
        return buffer.toString();
    }

    public static String recursiveReverse(String val) {
        if (val.length() == 1) return val;
        return recursiveReverse(val.substring(1)) + val.charAt(0);
    }



    public static boolean arePermutation(String val1, String val2) {
        return Arrays.equals(getCharFrequency(val1), getCharFrequency(val2));
    }

    private static int[] getCharFrequency(String val) {
        int[] chars = new int[26];
        for (int j=0; j<val.length(); j++) {
            chars[val.charAt(j) - 'a']++;
        }
        return chars;
    }


}
