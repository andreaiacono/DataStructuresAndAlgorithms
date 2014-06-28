package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.33
 */
public class StringFunctions {


    public static void main(String[] args) {

        System.out.println("anilina: " + isPalindromeWithSpaces("___ani__llin_a"));

        String val = "andrea iacono";
        System.out.println("Reverse: " + Arrays.toString(reverse(val.toCharArray())));

    }

    public static char[] reverse(char[] value) {

        int length = value.length;
        for (int i = 0; i < length / 2; i++) {
            char c = value[i];
            value[i] = value[length - 1 - i];
            value[length - 1 - i] = c;
        }

        return value;
    }

    public static boolean isPalindromeWithSpaces(String value) {

        int right_cnt = value.length() - 1;
        int left_cnt = 0;

        do {
            while (value.charAt(left_cnt) == '_' && left_cnt < right_cnt) {
                left_cnt++;
            }
            while (value.charAt(right_cnt) == '_' && right_cnt > left_cnt) {
                right_cnt--;
            }
            if (value.charAt(left_cnt) != value.charAt(right_cnt)) {
                return false;
            }
            left_cnt++;
            right_cnt--;
        }
        while (left_cnt < right_cnt);

        return true;
    }

    public static boolean isPalindrome(String value) {

        int length = value.length();

        for (int i = 0; i < length / 2; i++) {
            if (value.charAt(i) != value.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
