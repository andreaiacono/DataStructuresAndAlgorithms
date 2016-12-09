package pramp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DronePlanner {

    @Test
    public void test() {
        assertEquals(5, flightPlanner(new int[]{10, 0, 6, 15, 8}));
        assertEquals(5, flightPlanner(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8}));
        assertEquals(5, flightPlannerElegant(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8}));
        assertEquals(5, solve(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8}));
        assertEquals(5, solve(new int[]{10, 0, 6, 15, 8}));
//        assertEquals(5, findFuel(new int[] {10, 0, 6, 15,8}));
//        assertEquals(5, findFuel(new int[] {10,0,6,14,1,13,2,15,8}));
        assertEquals(5, requiredFuel(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8}));
        assertEquals(5, requiredFuel(new int[]{10, 0, 6, 15, 8}));
        assertEquals(5, getFuel(new int[]{10, 0, 6, 14, 1, 13, 2, 15, 8}));
        assertEquals(5, getFuel(new int[]{10, 0, 6, 15, 8}));
    }

    int getFuel(int[] z){
        int liters = 0;
        int gained = 0;
        for(int i = 0; i < z.length - 1; i++){
            liters += (z[i] - z[i+1]);
            if(liters < 0){
                gained -= liters;
                liters = 0;
            }
        }
        return gained;
    }


    int requiredFuel(int[] zValues) {
        int req = 0;

        int n = zValues.length;
        int left = 0;
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            int p1 = zValues[i];
            int p2 = zValues[i + 1];
            left += p1 - p2;
            if (left < 0) {
                total += Math.abs(left);
                left = 0;
            }
        }
        return total;
    }


    int flightPlanner(int[] route) {
        int minFuel = 0;
        int volumeOfPetrol = 0;
        int prev = route[0];
        for(int i=1;i<route.length;i++)
        {
            int cur = route[i];

            if(prev<cur)
            {
                if((prev-cur)+volumeOfPetrol<0)
                {
                    minFuel += (cur-prev)+volumeOfPetrol;
                    volumeOfPetrol = 0;
                }
                else
                {
                    volumeOfPetrol += prev-cur;
                }
            }
            else
            {
                volumeOfPetrol += cur-prev;
            }
            prev = cur;


        }
        return minFuel;
    }

    int flightPlanner2(int[] route) {
        int litersAdded = 0;
        int energyBalance = 0;
        for (int i = 1; i < route.length; i++) {
            energyBalance = energyBalance + (route[i - 1] - route[i]);
            if (energyBalance < 0) {
                litersAdded = litersAdded - energyBalance;
                energyBalance = 0;
            }
        }
        return litersAdded;
    }

    int flightPlannerElegant(int[] route) {
        return Arrays.stream(route).max().getAsInt() - route[0];
    }


    int requiredFuel2(int[] zValues) {
        int requiredFuel = 0;
        int currentStepFuel = 0;
        int maxFuelSeenSoFar = 0;
        int extraFuel = 0;

        if (zValues.length < 2) return 0;

        for (int i = 1; i < zValues.length; i++) {
            currentStepFuel = (zValues[i - 1] - zValues[i]) + currentStepFuel;

            if (currentStepFuel < 0) {
                extraFuel = (zValues[i - 1] - zValues[i]) - currentStepFuel;

                if (extraFuel > maxFuelSeenSoFar) {
                    maxFuelSeenSoFar = extraFuel;
                }
            }
        }
        requiredFuel = maxFuelSeenSoFar;

        return extraFuel;
    }


    public static int solve(int arr[]) {
        int currentAmount = 0;
        int minAmount = 0;
        for (int i = 1; i < arr.length; ++i) {
            int diff = arr[i - 1] - arr[i];
            currentAmount += diff;
            if (currentAmount < 0) {
                minAmount = Math.max(minAmount, -currentAmount);
            }
        }
        return minAmount;
    }

}
