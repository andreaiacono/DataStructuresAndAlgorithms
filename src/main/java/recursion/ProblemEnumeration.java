package recursion;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ProblemEnumeration {

    @Test
    public void test() {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");

        List<List<String>> expected = new ArrayList<>();
        List<String> s0 = new ArrayList<>();
        List<String> s1 = new ArrayList<>();
        s1.add("A");
        List<String> s2 = new ArrayList<>();
        s2.add("B");
        List<String> s3 = new ArrayList<>();
        s3.add("C");
        List<String> s4 = new ArrayList<>();
        s4.add("A");
        s4.add("B");
        List<String> s5 = new ArrayList<>();
        s5.add("A");
        s5.add("C");
        List<String> s6 = new ArrayList<>();
        s6.add("B");
        s6.add("C");
        List<String> s7 = new ArrayList<>();
        s7.add("A");
        s7.add("B");
        s7.add("C");
        expected.add(s0);
        expected.add(s1);
        expected.add(s2);
        expected.add(s3);
        expected.add(s4);
        expected.add(s5);
        expected.add(s6);
        expected.add(s7);

        assertEquals(new HashSet<>(expected), new HashSet<>(allSubsets(items, 0, new ArrayList<>())));


        String val = "ABC";
        Set<String> expectedSet = new HashSet<>() {{
            add("ABC");
            add("ACB");
            add("BAC");
            add("BCA");
            add("CAB");
            add("CBA");
        }};
        assertEquals(expectedSet, permutations(val, 0));
        assertEquals(24, permutations("ABCD", 0).size());
        assertEquals(120, permutations("ABCDE", 0).size());

        Set<List<String>> expectedFixedSets = new HashSet<>() {{
            add(List.of("A", "B"));
            add(List.of("A", "C"));
            add(List.of("B", "C"));
        }};
        assertEquals(3, fixedSizeSubsets(items, 2, 0, new ArrayList<>()).size());
        assertEquals(expectedFixedSets, fixedSizeSubsets(items, 2, 0, new ArrayList<>()));

        int groups = 3;
        List<List<String>> partial = new ArrayList<>();
        for (int i = 0; i < groups; i++) {
            partial.add(new ArrayList<>());
        }
        List<List<String>> result = divideInGroups(0, partial, groups, List.of("A", "B", "C"));
        System.out.println(result);

        String parenthesis = "[(((()))), ((()())), ((())()), ((()))(), (()(())), (()()()), (()())(), (())(()), (())()(), ()((())), ()(()()), ()(())(), ()()(()), ()()()()]";
        assertEquals(parenthesis, balancedParenthesis(4, 4, new StringBuilder()).toString());

        List<String> resultPG = passwordGenerator(new StringBuilder(), 3, allowedChars());
        System.out.println("PG: " + resultPG);
        assertEquals(Math.round(Math.pow(26, 3)), resultPG.size());

        char[] chars = new char[]{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        assertEquals(Math.round(Math.pow(26, 3)), passwordGenerator(chars, 3, "").size());
        
//        resultPG = passwordGenerator(new StringBuilder(), 5, allowedChars());
//        assertEquals(Math.round(Math.pow(26, 5)), resultPG.size());

        int n = 3;
        System.out.println("allSums(" + n + ")=" + allSums(new ArrayList<>(), 1, n));

        for (int i =1; i<3; i++) {
            for (int j =1; j<3; j++) {
                for (int k =1; k<3; k++) {
                    System.out.print("["+i+", "+j+", "+k+"] - ");
                }
                System.out.println();
            }
        }

        assertEquals(6, allSums(new ArrayList<>(), 1, 5).size());
    }

    public List<List<String>> allSubsets(List<String> items, int index, List<String> partial) {
        if (index == items.size()) {
            return List.of(partial);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(allSubsets(items, index + 1, partial));
        result.addAll(allSubsets(items, index + 1, new ArrayList<>(partial) {{
            add(items.get(index));
        }}));
        return result;
    }

    Set<String> permutations(String s, int idx) {
        if (idx == s.length()) {
            return Set.of(s);
        }
        Set<String> values = new HashSet<>();
        for (int i = idx; i < s.length(); i++) {
            values.addAll(permutations(s.charAt(i) + removeCharAt(i, s), idx + 1));
        }
        return values;
    }

    String removeCharAt(int index, String value) {
        return value.substring(0, index) +
                value.substring(index + 1);
    }


    Set<String> permut2ations(String s, int index) {
        HashSet<String> result = new HashSet<>();
        if (s.length() == index) {
            result.add(s);
            return result;
        }

        for (int i = index; i < s.length(); i++) {
            result.addAll(permut2ations(swap(s, i, index), index + 1));
        }
        return result;
    }

    private String swap(String s, int idx1, int idx2) {
        StringBuilder sb = new StringBuilder(s);
        char tmp = sb.charAt(idx1);
        sb.setCharAt(idx1, sb.charAt(idx2));
        sb.setCharAt(idx2, tmp);
        return sb.toString();
    }

    Set<List<String>> fixedSizeSubsets(List<String> items, int k, int index, List<String> partial) {

        if (partial.size() == k) {
            return Set.of(new ArrayList<>(partial));
        }

        Set<List<String>> result = new HashSet<>();
        for (int i = index; i < items.size(); i++) {
            partial.add(items.get(i));
            result.addAll(fixedSizeSubsets(items, k, i + 1, partial));
            partial.remove(items.get(i));
        }

        return result;
    }

    List<List<String>> divideInGroups(int index, List<List<String>> partial, int groups, List<String> items) {
        List<List<String>> result = new ArrayList<>();
        if (index == items.size()) {
            List<List<String>> newPartial = new ArrayList<>();
            for (int i = 0; i < groups; i++) {
                newPartial.add(new ArrayList<>(partial.get(i)));
            }
            result.addAll(newPartial);
            return result;
        }
        for (int i = 0; i < groups; i++) {
            partial.get(i).add(items.get(index));
            result.addAll(divideInGroups(index + 1, partial, groups, items));
            partial.get(i).remove(items.get(index));
        }
        return result;
    }

    List<String> balancedParenthesis(int toOpen, int toClose, StringBuilder partial) {

        if (toOpen == 0 && toClose == 0) {
            return List.of(partial.toString());
        }

        List<String> result = new ArrayList<>();
        if (toOpen > 0) {
            partial.append("(");
            result.addAll(balancedParenthesis(toOpen - 1, toClose, partial));
            partial.deleteCharAt(partial.length() - 1);
        }

        if (toClose > 0 && toClose > toOpen) {
            partial.append(")");
            result.addAll(balancedParenthesis(toOpen, toClose - 1, partial));
            partial.deleteCharAt(partial.length() - 1);
        }

        return result;
    }

    List<String> passwordGenerator(StringBuilder acc, int n, List<Character> chars) {
        if (acc.length() == n) {
            return List.of(acc.toString());
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.size(); i++) {
            acc.append(chars.get(i));
            result.addAll(passwordGenerator(acc, n, chars));
            acc.deleteCharAt(acc.length() - 1);
        }
        return result;
    }


    List<String> passwordGenerator(char[] chars, int k, String tmp) {

        if (tmp.length() == k) {
            return List.of(tmp);
        }

        List<String> result = new ArrayList<>();
        for (int i=0; i<chars.length; i++) {
            result.addAll(passwordGenerator(chars, k, tmp + chars[i]));
        }
        return result;
    }

    private List<Character> allowedChars() {
        List<Character> result = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            result.add(c);
        }
        return result;
    }

    public List<List<Integer>> allSums(List<Integer> acc, int index, int n) {

        // base case
        if (acc.size() == n) {
            System.out.println(acc);
            return List.of(new ArrayList<>(acc));
        }

        // recursive case
        List<List<Integer>> result = new ArrayList<>();
        for (int i = index; i < n; i++) {
            acc.add(i);
            result.addAll(allSums(acc, index, n));
            acc.remove(acc.size()-1);
        }
        return result;
    }
//        public List<List<Integer>> allSums(List<Integer> acc, int index, int n) {
//
//        // base case
//        int sum = sum(acc);
//        if (sum == n) {
//            return List.of(new ArrayList<>(acc));
//        } else if (sum > n) {
//            return List.of();
//        }
//
//        // recursive case
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = index; i < n; i++) {
//            acc.add(i);
//            result.addAll(allSums(acc, i, n));
//            acc.remove(acc.size()-1);
//        }
//        return result;
//    }
//


    private int sum(List<Integer> values) {
        return values.stream().mapToInt(n -> n).sum();
    }
}

