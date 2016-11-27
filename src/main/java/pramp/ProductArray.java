package pramp;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ProductArray {


    @Test
    public void test() {
        int[] input = new int[]{5, 7, 3, 4};
        int[] result = new int[]{84, 60, 140, 105};
        assertTrue(Arrays.equals(result, arrayOfArray(input)));
        assertTrue(Arrays.equals(result, betterArrayOfArray(input)));
        input = new int[]{1, 2, 3, 4, 5};
        result = new int[]{120, 60, 40, 30, 24};
        assertTrue(Arrays.equals(result, arrayOfArray(input)));
        assertTrue(Arrays.equals(result, betterArrayOfArray(input)));
    }

    int[] arrayOfArray(int[] a) {
        if (a == null || a.length < 2) {
            return null;
        }
        int[] result = new int[a.length];
        for (int j = 0; j < a.length; j++) {
            int product = 1;
            for (int i = 0; i < a.length; i++) {
                if (i != j) {
                    product *= a[i];
                }
            }
            result[j] = product;
        }

        return result;
    }

    int[] betterArrayOfArray(int[] a) {
        System.out.println(Arrays.toString(a));
        int[] products = new int[a.length];
        Arrays.fill(products, 1);
        int product = 1;
        System.out.println(Arrays.toString(products));
        for (int j = 0; j < a.length; j++) {
            products[j] *= product;
            System.out.println("Step " + j +": " + Arrays.toString(products));
            product *= a[j];
        }
        System.out.println("Finished first step: " + Arrays.toString(products));

        product = 1;
        for (int j = a.length-1; j>=0; j--) {
            products[j] *= product;
            System.out.println("Step " + j +": " + Arrays.toString(products));
            product *= a[j];
        }
        System.out.println("Finished second step: " + Arrays.toString(products));

        return products;
    }

}
