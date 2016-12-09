package recursion;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Permutations {


    /**
     * PERMUTE 1
     */

    public static Set<String> permute1(String str) {
        Set<String> perm = new TreeSet<>();
        if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permute1(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }


    /**
     * PERMUTE 2
     */
    public static Set<String> permute2(StringBuilder value, int index) {
        Set<String> values = new HashSet<>();
        values.add(value.toString());

        for (int j = index; j < value.length(); j++) {
            swap(value, index, j);
            values.addAll(permute2(value, index + 1));
            swap(value, index, j);
        }

        return values;
    }

    private static void swap(StringBuilder s, int index1, int index2) {
        char temp = s.charAt(index1);
        s.setCharAt(index1, s.charAt(index2));
        s.setCharAt(index2, temp);
    }


    /**
     * PERMUTE 3
     */
    public static void permute3(String str, Set<String> values) {
        permute3("", str, values);
    }

    private static void permute3(String prefix, String str, Set<String> values) {
        if (str.length() == 0) {
            values.add(prefix);
        }

        for (int j = 0; j < str.length(); j++) {
            permute3(prefix + str.charAt(j), removeCharAt(j, str), values);
        }
    }

    public static String removeCharAt(int index, String value) {
        return value.substring(0, index) + value.substring(index+1);
    }

    /**
     * PERUMTE 4
     */
    static int counter = 0;
    private static Set<String> permute4(String s, int index) {
        Set<String> values = new TreeSet<>();
        values.add(s);
        counter ++;
        for (int j = index; j < s.length(); j++) {
            values.addAll(permute4(s.charAt(j) + removeCharAt(j, s), index + 1));
        }

        return values;
    }

    @Test
    public void permutations() {
        String s = "ABCD";
        Set<String> result = permute1(s);
        System.out.println(result);
        Set<String> result2 = permute2(new StringBuilder(s), 0);
        System.out.println(result2);

        Set<String> result3 = new TreeSet<>();
        permute3(s, result3);
        System.out.println(result3);

        System.out.println("coutner=" + counter);
        Set<String> result4 = permute4(s, 0);
        System.out.println("coutner=" + counter);
        System.out.println(result4);

        assertEquals(24, result.size());

        assertTrue(result.contains("ABCD"));
        assertTrue(result.contains("ACBD"));
        assertTrue(result.contains("BACD"));
        assertTrue(result.contains("BCAD"));
        assertTrue(result.contains("CABD"));
        assertTrue(result.contains("CBAD"));

        assertTrue(result.contains("ABDC"));
        assertTrue(result.contains("ACDB"));
        assertTrue(result.contains("BADC"));
        assertTrue(result.contains("BCDA"));
        assertTrue(result.contains("CADB"));
        assertTrue(result.contains("CBDA"));

        assertTrue(result.contains("ADBC"));
        assertTrue(result.contains("ADCB"));
        assertTrue(result.contains("BDAC"));
        assertTrue(result.contains("BDCA"));
        assertTrue(result.contains("CDAB"));
        assertTrue(result.contains("CDBA"));

        assertTrue(result.contains("DABC"));
        assertTrue(result.contains("DACB"));
        assertTrue(result.contains("DBAC"));
        assertTrue(result.contains("DBCA"));
        assertTrue(result.contains("DCAB"));
        assertTrue(result.contains("DCBA"));

        assertEquals(24, result2.size());

        assertTrue(result2.contains("ABCD"));
        assertTrue(result2.contains("ACBD"));
        assertTrue(result2.contains("BACD"));
        assertTrue(result2.contains("BCAD"));
        assertTrue(result2.contains("CABD"));
        assertTrue(result2.contains("CBAD"));

        assertTrue(result2.contains("ABDC"));
        assertTrue(result2.contains("ACDB"));
        assertTrue(result2.contains("BADC"));
        assertTrue(result2.contains("BCDA"));
        assertTrue(result2.contains("CADB"));
        assertTrue(result2.contains("CBDA"));

        assertTrue(result2.contains("ADBC"));
        assertTrue(result2.contains("ADCB"));
        assertTrue(result2.contains("BDAC"));
        assertTrue(result2.contains("BDCA"));
        assertTrue(result2.contains("CDAB"));
        assertTrue(result2.contains("CDBA"));

        assertTrue(result2.contains("DABC"));
        assertTrue(result2.contains("DACB"));
        assertTrue(result2.contains("DBAC"));
        assertTrue(result2.contains("DBCA"));
        assertTrue(result2.contains("DCAB"));
        assertTrue(result2.contains("DCBA"));

        assertEquals(24, result3.size());

        assertTrue(result3.contains("ABCD"));
        assertTrue(result3.contains("ACBD"));
        assertTrue(result3.contains("BACD"));
        assertTrue(result3.contains("BCAD"));
        assertTrue(result3.contains("CABD"));
        assertTrue(result3.contains("CBAD"));

        assertTrue(result3.contains("ABDC"));
        assertTrue(result3.contains("ACDB"));
        assertTrue(result3.contains("BADC"));
        assertTrue(result3.contains("BCDA"));
        assertTrue(result3.contains("CADB"));
        assertTrue(result3.contains("CBDA"));

        assertTrue(result3.contains("ADBC"));
        assertTrue(result3.contains("ADCB"));
        assertTrue(result3.contains("BDAC"));
        assertTrue(result3.contains("BDCA"));
        assertTrue(result3.contains("CDAB"));
        assertTrue(result3.contains("CDBA"));

        assertTrue(result3.contains("DABC"));
        assertTrue(result3.contains("DACB"));
        assertTrue(result3.contains("DBAC"));
        assertTrue(result3.contains("DBCA"));
        assertTrue(result3.contains("DCAB"));
        assertTrue(result3.contains("DCBA"));

        assertEquals(24, result3.size());

        assertTrue(result4.contains("ABCD"));
        assertTrue(result4.contains("ACBD"));
        assertTrue(result4.contains("BACD"));
        assertTrue(result4.contains("BCAD"));
        assertTrue(result4.contains("CABD"));
        assertTrue(result4.contains("CBAD"));

        assertTrue(result4.contains("ABDC"));
        assertTrue(result4.contains("ACDB"));
        assertTrue(result4.contains("BADC"));
        assertTrue(result4.contains("BCDA"));
        assertTrue(result4.contains("CADB"));
        assertTrue(result4.contains("CBDA"));

        assertTrue(result4.contains("ADBC"));
        assertTrue(result4.contains("ADCB"));
        assertTrue(result4.contains("BDAC"));
        assertTrue(result4.contains("BDCA"));
        assertTrue(result4.contains("CDAB"));
        assertTrue(result4.contains("CDBA"));

        assertTrue(result4.contains("DABC"));
        assertTrue(result4.contains("DACB"));
        assertTrue(result4.contains("DBAC"));
        assertTrue(result4.contains("DBCA"));
        assertTrue(result4.contains("DCAB"));
        assertTrue(result4.contains("DCBA"));

    }

}
