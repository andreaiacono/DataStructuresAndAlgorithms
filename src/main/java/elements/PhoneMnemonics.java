package elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneMnemonics {

    public static Map<Character, List<Character>> numbers = new HashMap<>();

    public static void main(String[] args) {
        numbers.put('2', Arrays.asList('A', 'B', 'C'));
        numbers.put('3', Arrays.asList('D', 'E', 'F'));
        numbers.put('4', Arrays.asList('G', 'H', 'I'));
        numbers.put('5', Arrays.asList('J', 'K', 'L'));
        numbers.put('6', Arrays.asList('M', 'N', 'O'));
        numbers.put('7', Arrays.asList('P', 'Q', 'R', 'S'));
        numbers.put('8', Arrays.asList('T', 'U', 'V'));
        numbers.put('9', Arrays.asList('W', 'X', 'Y', 'Z'));

        System.out.println(getMnemonics("227"));
        System.out.println(getMnemonics("2276696"));
    }

    private static List<String> getMnemonics(String number) {
        List<String> results = new ArrayList<>((int)Math.pow(3.2, number.length()));

        compute(new StringBuilder(number), number,0, results);

        return results;
    }

    private static void compute(StringBuilder result, String s, int index, List<String> results) {

        if (index == result.length()) {
            results.add(result.toString());
            return;
        }
        for (char c: numbers.get(s.charAt(index))) {
            result.setCharAt(index, c);
            compute(result, s,index + 1, results);
        }
    }
}
