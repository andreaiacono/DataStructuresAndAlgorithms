package interviewbit;

import org.junit.Test;

import java.util.*;

public class Perumtation {

    @Test
    public void test() {
        List<Integer> vals = Arrays.asList(1, 2, 3);
        ArrayList<Integer> v = new ArrayList<>(vals);
        System.out.println(permute(v));

        System.out.println(permute("ABCD", 0));

        List<String> list = List.of("A", "B", "C");
        System.out.println(permute(list, 0));
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (a.size() == 0) {
            return result;
        }
        permute(a, 0, result);
        return result;
    }

    void permute(ArrayList<Integer> a, int index, ArrayList<ArrayList<Integer>> result) {

        System.out.println("index=" + index + " res=" + result);
        if (index == a.size() - 1) {
            result.add(new ArrayList<>(a));
            return;
        }

        for (int i = index; i < a.size(); i++) {
            swap(a, index, i);
            permute(a, index + 1, result);
            swap(a, index, i);
        }
    }

    void swap(ArrayList<Integer> a, int i, int j) {
        int tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    Set<String> permute(String s, int idx) {
        if (idx == s.length()) {
            return Set.of(s);
        }

        Set<String> result = new HashSet<>();
        for (int i=idx; i<s.length(); i++) {
            String swapped = s.charAt(i) + s.substring(0, i) + s.substring(i + 1);
            result.addAll(permute(swapped, idx+1));
        }
        return result;
    }

    List<List<String>> permute(List<String> s, int idx) {
        if (idx == s.size()) {
            return List.of(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (int i=idx; i<s.size(); i++) {
            result.addAll(permute(swapped(s, i), idx+1));
        }
        return result;
    }

    List<String> swapped(List<String> s, int idx) {
        return new ArrayList<>() {{
            add(s.get(idx));
            addAll(s);
            remove(idx+1);
        }};
    }
}