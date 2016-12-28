package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LetterPhone {

    @Test
    public void test() {
        ArrayList<String> expected = new ArrayList<String>() {{
            add("ad");
            add("ae");
            add("af");
            add("bd");
            add("be");
            add("bf");
            add("cd");
            add("ce");
            add("cf");
        }};

        assertEquals(expected, letterCombinations("23"));
    }

    ArrayList<String> result = new ArrayList<>();

    public ArrayList<String> letterCombinations(String a) {

        Map<Character, List<Character>> digits = getDigits();
        compose(a, 0, new StringBuilder(), digits);
        return result;
    }

    void compose(String a, int digit, StringBuilder builder, Map<Character, List<Character>> digits) {

//        System.out.println("a=" + a + " digit=" + digit + " builder=" + builder.toString());
        if (builder.length() == a.length()) {
//            System.out.println("adding " + builder.toString() + " digit=" + digit);
            result.add(builder.toString());
            return;
        }

        for (int i=digit; i<a.length(); i++) {
            List<Character> chars = digits.get(a.charAt(i));
            for (int j=0; j<chars.size(); j++) {
                builder.append(chars.get(j));
                compose(a, i+1, builder, digits);
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }

    Map<Character, List<Character>> getDigits() {

        Map<Character, List<Character>> digits = new HashMap<>();
        List<Character> list = new ArrayList<>();
        list.add('0');
        digits.put('0', list);

        list = new ArrayList<>();
        list.add('1');
        digits.put('1', list);

        list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        digits.put('2', list);

        list = new ArrayList<>();
        list.add('d');
        list.add('e');
        list.add('f');
        digits.put('3', list);

        list = new ArrayList<>();
        list.add('g');
        list.add('h');
        list.add('i');
        digits.put('4', list);

        list = new ArrayList<>();
        list.add('j');
        list.add('k');
        list.add('l');
        digits.put('5', list);

        list = new ArrayList<>();
        list.add('m');
        list.add('n');
        list.add('o');
        digits.put('6', list);

        list = new ArrayList<>();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        digits.put('7', list);

        list = new ArrayList<>();
        list.add('t');
        list.add('u');
        list.add('v');
        digits.put('8', list);

        list = new ArrayList<>();
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        digits.put('9', list);

        return digits;
    }

}
