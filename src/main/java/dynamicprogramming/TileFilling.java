package dynamicprogramming;

import datastructures.AdjacencyListGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

// Dynamic programming for coding interviews
// Example 8.2
public class TileFilling {

    @Test
    public void testCountFills() {
        int n = 45;
        int count = linearCountFills(n);
        System.out.println(count);
        assertEquals(1836311903, count);
    }

    int[] cache = new int[10000];

    int countFills(int index) {

        if (cache[index] > 0) {
            return cache[index];
        }

        if (index == 0) {
            return 1;
        }
        int ver = countFills(index - 1);
        int hor = 0;
        if (index > 1) {
            hor = countFills(index - 2);
        }
        cache[index] = ver + hor;
        return cache[index];
    }

    // this is fibonacci!
    int linearCountFills(int index) {
        int a = 1;
        int b = 2;
        int c = a + b;

        for (int i=3; i<index; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }

}


