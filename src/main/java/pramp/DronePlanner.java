package pramp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DronePlanner {

    @Test
    public void test() {
        assertEquals(10, flightPlanner(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 20}));

        assertEquals(10, getFuel(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8, 20}));
        assertEquals(5, amountOfFuelNeeded(new int[]{10, 0, 6, 15, 8}));
        assertEquals(10, amountOfFuelNeeded(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8, 20}));
        assertEquals(10, amountOfFuelNeeded(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8, 20, 0, 1, 2, 3, 20, 1, 5}));
        assertEquals(5, getFuel(new int[]{10, 0, 6, 15, 8}));
    }

    int amountOfFuelNeeded(int[] z) {
        int fuelAvailable = 0;
        int result = 0;
        for (int i = 0; i < z.length - 1; i++) {
            int fuelNeeded = (z[i + 1] - z[i]);
            fuelAvailable += -fuelNeeded;

            if (fuelAvailable < 0) {
                result += -fuelAvailable;
                fuelAvailable = 0;
            }
        }

        return result;
    }

    int getFuel(int[] route) {
        int currentFuel = 0;
        int addedFuel = 0;
        for (int i = 0; i < route.length - 1; i++) {
            currentFuel += (route[i] - route[i + 1]);
            if (currentFuel < 0) {
                addedFuel -= currentFuel;
                currentFuel = 0;
            }
        }
        return addedFuel;
    }


    int flightPlanner(int[] route) {
        return Arrays.stream(route).max().getAsInt() - route[0];
    }


}
