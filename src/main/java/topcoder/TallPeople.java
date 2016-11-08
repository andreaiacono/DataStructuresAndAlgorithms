package topcoder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * TopCoder: https://community.topcoder.com/stat?c=problem_statement&pm=2923&rd=5854
 */
public class TallPeople {

    @Test
    public void test() {
        String[] rows = new String[]{"9 2 3", "4 8 7"};
        assertTrue(Arrays.equals(new int[]{4, 7}, getPeople(rows)));

        rows = new String[]{"1 2", "4 5", "3 6"};
        assertTrue(Arrays.equals(new int[]{4, 4}, getPeople(rows)));

        rows = new String[]{"1 1", "1 1"};
        assertTrue(Arrays.equals(new int[]{1, 1}, getPeople(rows)));
    }

    int[] getPeople(String[] rows) {

        List<Integer>[] items = new ArrayList[rows.length];

        int tallest = 0;
        int shortest = 1000;

        for (int j = 0; j < rows.length; j++) {
            List<Integer> values = Arrays.stream(rows[j].split(" ")).map(n -> new Integer(n)).collect(Collectors.toList());
            items[j] = values;
        }

        for (int j = 0; j < rows.length; j++) {
            int shortestInRow = 1000;
            for (int i = 0; i < items[j].size(); i++) {
                if (shortestInRow > items[j].get(i)) {
                    shortestInRow = items[j].get(i);
                }
            }
            if (tallest < shortestInRow) {
                tallest = shortestInRow;
            }
        }

        for (int j = 0; j < items[0].size(); j++) {
            int tallestInColumn = 0;
            for (int i = 0; i < rows.length; i++) {
                if (tallestInColumn < items[i].get(j)) {
                    tallestInColumn = items[i].get(j);
                }
            }
            if (shortest > tallestInColumn) {
                shortest = tallestInColumn;
            }
        }

        return new int[]{tallest, shortest};
    }

}
