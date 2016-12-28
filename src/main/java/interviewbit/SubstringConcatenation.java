package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SubstringConcatenation {

    @Test
    public void test() {

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 9));
        assertEquals(expected, findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")));

        expected = new ArrayList<>();
        assertEquals(expected, findSubstring("acaaacbcbccbaabaccabcbbcaaccbbbbcbabaacbbcbccababb", Arrays.asList("cabccbbbc", "abbccabbc", "bbbcbbbaa", "acbaabcab", "ccacabccb", "bbacaabca", "acacbaacb", "aabbcccab", "ccccbbcaa", "baaccaabc")));
    }

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {

        ArrayList<Integer> result = new ArrayList<>();

        if (b.size() == 0) {
            return result;
        }

        int length = b.size() * b.get(0).length();
        Set<String> perms = permutations(new ArrayList<>(b));

        for (int i=0; i<a.length() - length+1; i++) {
            if (perms.contains(a.substring(i, i + length))) {
                result.add(i);
            }
        }

        return result;
    }

    Set<String> permutations(List<String> strings) {
        if (strings.isEmpty()) {
            return Collections.singleton("");
        }
        else {
            Set<String> set = new HashSet<>();
            for (int i = 0; i < strings.size(); i++) {
                ArrayList<String> subList = new ArrayList<>(strings.subList(0, i));
                subList.addAll(strings.subList(i + 1, strings.size()));
                for (String s : permutations(subList))
                    set.add(strings.get(i) + s);
            }
            return set;
        }
    }

}
