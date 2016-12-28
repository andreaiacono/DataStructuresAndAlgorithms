package misc;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsomorphicStrings {

    @Test
    public void test() {
        assertFalse(isIsomorphic("foo", "barrrrr"));
        assertFalse(isIsomorphic("foo", "bar"));
        assertTrue(isIsomorphic("foo", "egg"));
        assertFalse(isIsomorphic("for", "egg"));
    }

    private boolean isIsomorphic(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                if (map.get(s1.charAt(i)) != s2.charAt(i)) {
                    return false;
                }
            }
            else {
                if (map.containsValue(s2.charAt(i))) {
                    return false;
                }
                map.put(s1.charAt(i), s2.charAt(i));
            }
        }

        return true;
    }


}
