package topcoder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareFreeString {

    @Test
    public void test() {
        assertEquals("not square-free", isSquareFree("bobo"));
        assertEquals("not square-free", isSquareFree("apple"));
        assertEquals("square-free", isSquareFree("pen"));
        assertEquals("not square-free", isSquareFree("aydyamrbnauhftmphyrooyq"));
        assertEquals("square-free", isSquareFree("qwertyuiopasdfghjklzxcvbnm"));
    }


    public String isSquareFree(String s) {

        int n = s.length();

        for (int i = 0; i < (1 << n); i++) {
            StringBuilder builder = new StringBuilder();
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    counter ++;
                    builder.append(s.charAt(j));
                }
                if (counter >= n/2) {
                    break;
                }
            }
            if (isSquare(builder.toString())) {
                return "not square-free";
            }
        }

        return "square-free";
    }

    public boolean isSquare(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        int size = s.length() / 2;
        return s.substring(0, size).equals(s.substring(size));
    }
}
