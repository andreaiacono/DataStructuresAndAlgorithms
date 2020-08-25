package dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

// Dynamic programming for coding interviews
// Example 8.3

public class CountWays {

    @Test
    public void testCountWays() {
        int[] points = new int[] {3, 5, 10};
        int score = 21;
        int count = countWays(points, points.length-1, score);
        System.out.println(count);
        //    [3,3,3,3,3,3,3]
        //    [3,3,5,10]
        //    [3,3,5,5,5]
        System.out.println("Result=" + result);
        assertEquals(3, count);

        score = 20;
        result= new ArrayList<>();
        count = countWays(points, points.length-1, score);
        System.out.println(count);
        //    [5,5,5,5]
        //    [5,5,10]
        //    [10,10]
        //    [3,3,3,3,3,5]
        System.out.println("Result=" + result);
        assertEquals(4, count);
    }




    int[] cache = new int[10000];
    List<String> sets = new ArrayList<>();
    List<List<String>> result= new ArrayList<>();

    int countWays(int[] points, int index, int score) {
        if (score >= 0 && cache[score] > 0) {
            return cache[score];
        }
        if (score == 0) {
            result.add(new ArrayList<>(sets));
            return 1;
        }
        if (score < 0) {
            return 0;
        }

        int ways = 0;
        for (int i=index; i>= 0; i--) {
            sets.add("" + points[i]);
            ways += countWays(points, i, score-points[i]);
            sets.remove("" + points[i]);
        }
        cache[score] = ways;
        return cache[score];
    }

}


