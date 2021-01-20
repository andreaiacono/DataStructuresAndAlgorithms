package array;

import org.junit.Test;

public class CurrencyExchange {

    /**
     * Suppose you are given a table of currency exchange rates, represented as a 2D array. Determine whether
     * there is a possible arbitrage: that is, whether there is some sequence of trades you can make, starting
     * with some amount A of any currency, so that you can end up with some amount greater than A of that currency.
     * <p>
     * There are no transaction costs and you can trade fractional quantities.
     * <p>
     * <p>
     * 1    2    3  4
     * 0.5  1    5  0.25
     * 0.3  0.2  1  0.13
     * 0.25 4    6  1
     */

    @Test
    public void test() {

        double[][] rates = new double[][]{
                {1, 2, 3, 4},
                {0.5, 1, 5, 0.25},
                {0.3, 0.2, 1, 0.13},
                {0.25, 4, 6, 1}
        };
        

    }


}
