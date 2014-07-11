package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("isAnagram: " + isAnagram2("boston", "tnoobs"));
        System.out.println("isAnagram: " + isAnagram2("boston", "tsoobs"));

    }

    public static boolean isAnagram2(String val1, String val2) {

        if (val1.length() != val2.length()) return false;

        Map<Character, Integer> val1Map = decomposeString(val1);
        Map<Character, Integer> val2Map = decomposeString(val2);

        return val1Map.equals(val2Map);
    }

    private static Map<Character, Integer> decomposeString(String val) {

        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < val.length(); j++) {

            if (!map.containsKey(val.charAt(j))) {
                map.put(val.charAt(j), 0);
            }
            map.put(val.charAt(j), map.get(val.charAt(j)) + 1);
        }

        return map;
    }

    public static boolean isAnagram(String val1, String val2) {

        if (val1.length() != val2.length()) return false;

        String copy = val2;
        for (int j = 0; j < val1.length(); j++) {
            int pos = copy.indexOf(val1.charAt(j));
            if (pos < 0) return false;
            copy = copy.substring(0, pos) + copy.substring(pos + 1);
        }

        return true;
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
