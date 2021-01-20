package graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PasswordLock {

    /**
     * There is a box protected by a password. The password is a sequence of n digits where each digit can be one
     * of the first k digits 0, 1, ..., k-1. While entering a password, the last n digits entered will automatically
     * be matched against the correct password. For example, assuming the correct password is "345", if you
     * type "012345", the box will open because the correct password matches the suffix of the entered password.
     *
     * Return any password of minimum length that is guaranteed to open the box at some point of entering it.
     *
     * Example 1:
     * Input: n = 1, k = 2
     * Output: "01"
     * Note: "10" will be accepted too.
     *
     * Example 2:
     * Input: n = 2, k = 2
     * Output: "00110"
     * Note: "01100", "10011", "11001" will be accepted too.
     */

    @Test
    public void test() {
        System.out.println(crackBox(1, 2));
        System.out.println(crackBox(2, 2));
        System.out.println(crackBox(3, 2));
    }

    String crackBox(int n, int k) {
        List<String> passwords = allPasswords(n, k, "");
        StringBuilder result = new StringBuilder();
        for (String password: passwords) {
            boolean isCut = false;
            for (int i=n;i>=0;i--) {
                if (result.length() > 0 && password.startsWith(result.substring(result.length() - i))) {
                    result.append(password.substring(i));
                    isCut = true;
                    break;
                }
            }
            if (!isCut){
                result.append(password);
            }
        }
        return result.toString().trim();
    }

    List<String> allPasswords(int n, int k, String tmp) {
        if (n == 0) {
            return List.of(tmp);
        }
        List<String> result = new ArrayList<>();
        for (int i=0; i<k; i++) {
            result.addAll(allPasswords(n-1, k, tmp + i));
        }
        return result;
    }



}
