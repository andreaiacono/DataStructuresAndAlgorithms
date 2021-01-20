package misc;

import java.util.Random;

public class BiasedCoinToss {

    /*
      Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's
      not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.
      Write a function to simulate an unbiased coin toss.
     */

    int toss_biased() {
        return new Random().nextInt(3) > 1 ? 1 : 0;
    }

    int tossCoin() {

        while (true) {
            int first = toss_biased();
            int second = toss_biased();

            if (first != second) {
                return first;
            }
        }
    }

}
