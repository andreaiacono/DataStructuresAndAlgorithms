package recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RodCuttingTest {

    @Test
    public void rodCutting() {
        int prices[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
        assertEquals(10, RodCutting.rodCutting(prices, 3));
        assertEquals(13, RodCutting.rodCutting(prices, 4));
        assertEquals(30, RodCutting.rodCutting(prices, 9));
    }

}