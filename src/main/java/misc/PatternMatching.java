package misc;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class PatternMatching {

    @Test
    public void test() {
        assertEquals(73, getBirthYearFromFiscalCode("CNINDR73E25L219A"));
    }

    int getBirthYearFromFiscalCode(String s) {
        Pattern r = Pattern.compile(".*(\\d\\d)\\w\\d\\d\\w\\d\\d\\d\\w"); // searches for test-number-text
        Matcher s2 = r.matcher(s);
        if (!s2.matches()) {
            return -1;
        }
        return Integer.parseInt(s2.group(1));
    }
}
