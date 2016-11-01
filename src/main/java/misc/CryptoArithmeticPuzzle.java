package misc;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CryptoArithmeticPuzzle {

    public Map<Character, Integer> cryptoSolve(String s1, String s2, String sum) {

        List<Character> chars = new ArrayList<>();
        add(s1, chars);
        add(s2, chars);
        add(sum, chars);

        Map<Character, Integer> charsMap = new HashMap<>();
        int counter = 0;
        for (Character c : chars) {
            charsMap.put(c, counter++);
        }

        return cryptoSolve(s1, s2, sum, charsMap, 0, chars);
    }

    private Map<Character, Integer> cryptoSolve(String s1, String s2, String sum, Map<Character, Integer> charsMap, int index, List<Character> chars) {

        if (!containsDuplicates(charsMap) && isTrue(s1, s2, sum, charsMap)) {
            printSolution(s1, s2, sum, charsMap);
            return charsMap;
        }

        for (int i = index; i < chars.size(); i++) {
            for (int n = 0; n <= 9; n++) {
                int tmp = charsMap.get(chars.get(i));
                charsMap.put(chars.get(i), n);

                Map<Character, Integer> result = cryptoSolve(s1, s2, sum, charsMap, index + 1, chars);
                if (result != null) {
                    return result;
                }
                charsMap.put(chars.get(i), tmp);

            }
        }

        return null;
    }

    private void printSolution(String s1, String s2, String sum, Map<Character, Integer> charsMap) {
        System.out.printf("%5s%n", s1);
        System.out.printf("%5s%n", s2);
        System.out.printf("-----%n");
        System.out.printf("%5s%n", sum);

        System.out.println();
        System.out.printf("%5s%n", stringToNum(s1, charsMap));
        System.out.printf("%5s%n", stringToNum(s2, charsMap));
        System.out.printf("-----%n");
        System.out.printf("%5s%n", stringToNum(sum, charsMap));

    }

    private boolean isTrue(String s1, String s2, String sum, Map<Character, Integer> chars) {
        return stringToNum(s1, chars) + stringToNum(s2, chars) == stringToNum(sum, chars);
    }

    private boolean containsDuplicates(Map<Character, Integer> charsMap) {
        int[] count = new int[128];
        for (Integer i: charsMap.values()) {
            if (count[i] == 1) {
                return true;
            }
            count[i]++;
        }
        return false;
    }

    private void add(String s1, List<Character> chars) {
        s1.chars().filter(c -> !chars.contains((char) c)).forEach(c -> chars.add((char) c));
    }

    private int stringToNum(String value, Map<Character, Integer> chars) {
        int sum = 0;
        int pos = 0;
        for (int j = value.length() - 1; j >= 0; j--) {
            sum += chars.get(value.charAt(j)) * Math.pow(10, pos++);
        }
        return sum;
    }

    @Test
    public void test() {

        // execution time is ~ 6'
        String s1 = "FIVE";
        String s2 = "FIVE";
        String sum = "TEN";

        Map<Character, Integer> result = new HashMap<>();
        result.put('F', 0);
        result.put('I', 1);
        result.put('V', 3);
        result.put('E', 7);
        result.put('T', 2);
        result.put('N', 4);
        assertEquals(result, cryptoSolve(s1, s2, sum));

        s1 = "BASE";
        s2 = "BALL";
        sum = "GAMES";

        result = new HashMap<>();
        result.put('B', 2);
        result.put('A', 4);
        result.put('S', 6);
        result.put('E', 1);
        result.put('L', 5);
        result.put('G', 0);
        result.put('M', 9);
        assertEquals(result, cryptoSolve(s1, s2, sum));
    }

}
