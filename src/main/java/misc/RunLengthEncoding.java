package misc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RunLengthEncoding {

    @Test
    public void test() {
        assertEquals("A3B3C2", runLengthEncoding("AAABBBCC"));
        assertEquals("A1B3C2", runLengthEncoding("ABBBCC"));
        assertEquals("A5B3C1", runLengthEncoding("AAAAABBBC"));
        assertEquals("A1B1C1", runLengthEncoding("ABC"));
        assertEquals("A3", runLengthEncoding("AAA"));
        assertEquals("", runLengthEncoding(""));
    }

    String runLengthEncoding(String src) {
        if (src.length() == 0 ) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i=0; i<src.length()-1; i++) {
            int counter = 1;
            while (i < src.length()-1 && src.charAt(i) == src.charAt(i+1)) {
                i ++;
                counter ++;
            }
            result.append(src.charAt(i)).append(counter);
        }
        if (src.charAt(src.length()-1) != src.charAt(src.length()-2)) {
            result.append(src.charAt(src.length()-1)).append("1");
        }
        return result.toString();
    }
}
