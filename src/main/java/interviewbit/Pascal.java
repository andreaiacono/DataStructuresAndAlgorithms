package interviewbit;

import org.junit.Test;

import java.util.ArrayList;

public class Pascal {

    @Test
    public void test(){
        System.out.println(generate(5));
    }

    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i=0; i<a; i++) {

            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (i == 0 || j == 0 || (i == 1 && j == 1) || j == i) {
                    row.add(1);
                }
                else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(row);
        }

        return result;
    }
}
