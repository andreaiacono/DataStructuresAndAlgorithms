package misc;

import java.util.*;

public class DeleteHash {

    public static void main(String[] args) {
        String s1 = "y#fo##f";
        String s2 = "y#f#o##f";
//        String s1 = "ab##";
//        String s2 = "c#d#";
        System.out.println(s1 + " equals to " + s2 + " = " + backspaceCompare(s1, s2));
    }

    static public boolean backspaceCompare(String S, String T) {
        return deleted(S).equals(deleted(T));
    }

    static public String deleted(String s) {
        char[] result = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                index = Math.max(0, index -1);
            }
            else {
                result[index++] = s.charAt(i);
            }
        }
        System.out.println("result=" + new String(Arrays.copyOf(result, index)));
        return new String(Arrays.copyOf(result, index));
    }
}
