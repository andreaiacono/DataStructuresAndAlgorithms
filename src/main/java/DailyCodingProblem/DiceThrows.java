package DailyCodingProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceThrows {

    public static void main(String[] args) {
        throwDices(2, 6);
        System.out.println("Recursive: \n" + throwDicesRec(new ArrayList<>(), 2, 4));
    }

    static void throwDices(int dices, int faces) {
        int n = (int) Math.pow(faces, dices);
        for (int i = 0; i < n; i++) {
            int[] values = new int[dices];
            values[0] = i % faces + 1;
            for (int j = 1; j < values.length; j++) {
                values[j] = (i / ((int) (Math.pow(faces, j)))) % faces + 1;
            }
            System.out.println(Arrays.toString(values));
        }
    }

    static List<List<Integer>> throwDicesRec(List<Integer> current, int n, int faces) {
        if (n == 0) {
            return Arrays.asList(new ArrayList<>(current));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= faces; i++) {
            current.add(i);
            result.addAll(throwDicesRec(current, n - 1, faces));
            current.remove(Integer.valueOf(i));
        }
        return result;
    }

}
