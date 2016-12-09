package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perumtation {

    @Test
    public void test() {
        List<Integer> vals = Arrays.asList(1, 2, 3);
        ArrayList<Integer> v = new ArrayList<>(vals);
        System.out.println(permute(v));
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
}