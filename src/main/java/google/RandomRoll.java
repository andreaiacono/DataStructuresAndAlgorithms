package google;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomRoll {

    @Test
    public void test() {

        double rnd = 0.9999;
        assertTrue(compare(rnd, 1) == 0);
        assertFalse(compare(rnd, 1, 0.00001) == 0);
        assertTrue(compare(rnd, 1, 0.001) == 0);

        double[] probs = new double[]{0, 0.1, 0.3, 0.5, 0.8, 1};
        int[] counts = new int[probs.length];
        for (int i = 1; i < 1_000_000; i++) {
            counts[randomRoll(probs)]++;
        }
        for (int i = 0; i < counts.length - 1; i++) {
            System.out.println("[" + probs[i] + ", " + probs[i + 1] + "): " + counts[i]);
        }
        System.out.println("[" + probs[5] + ", " + probs[5] + "): " + counts[5]);
    }

    // dice with `n` faces, each of which has `probs[i]` probablity to occur
    // probs[0] = 0.0
    // probs[1] = 0.1
    // probs[2] = 0.3
    // probs[3] = 0.5
    // probs[4] = 0.8
    // probs[5] = 1

    int randomRoll(double[] probs) {

        double rnd = new Random().nextDouble(); // returns [0, 1)
        int left = 0;
        int right = probs.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (compare(rnd, probs[mid]) >= 0 && compare(rnd, probs[mid + 1]) <= 0) {
                return mid;
            }
            else if (compare(rnd, probs[mid + 1]) < 0) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return probs.length - 2;
    }

    int compare(double d1, double d2, double epsilon) {
        if (d1 - d2 > epsilon) {
            return 1;
        } else if (d2 - d1 > epsilon) {
            return -1;
        }
        return 0;
    }

    final double EPSILON = 0.0001;

    int compare(double d1, double d2) {
        return compare(d1, d2, EPSILON);
    }

}
