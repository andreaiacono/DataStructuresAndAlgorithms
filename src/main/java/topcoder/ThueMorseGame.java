package topcoder;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ThueMorseGame {

    @Test
    public void test() {
        assertEquals("Alice", get(3, 3));
        assertEquals("Bob", get(3, 2));
        assertEquals("Alice", get(387, 22));
        assertEquals("Alice", get(499999999, 50));
        assertEquals("Bob", get(499999975, 49));
    }

    public String get(int n, int m) {

//        Map<Integer, Boolean> oddNumbers = getOddNUmbers();

        int turn = 0;

        if (n <= m) {
            return "Alice";
        }

        while (n > 0) {
            n--;
        }
        System.out.println("finished");
        return turn % 2 == 0 ? "Alice" : "Bob";
    }


    public boolean isOdd(int n) {
        return getOnesNumber(n) % 2 == 0;
    }

    public static int  getOnesNumber(int n) {
        int counter = 0;
        while (n > 0) {
            if (n % 2 != 0) counter++;
            n /= 2;
        }
        return counter;
    }

    public Map<Integer, Boolean> getOddNUmbers() {
        Map<Integer, Boolean> odds = new HashMap<>(5000000);
        for (int j=0; j<50_000_000; j++) {
            odds.put(j, isOdd(j));
            if (j%1_000_000 == 0) {
                System.out.println("1M");
            }
        }
        return odds;
    }
}
