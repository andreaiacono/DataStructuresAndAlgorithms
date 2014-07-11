package recursion;

import java.util.Arrays;

/**
 * CodingBat recursion exercises
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 04/07/14
 * Time: 13.10
 */
public class RecursiveFunctions {

    public static void main(String[] args) {

        int[] nums = new int[]{23, 45, 12, 11, 9, 65, 81, 43};
        int[] set1 = new int[nums.length];
        int[] set2 = new int[nums.length];
        splitInTwo(nums, 0, set1, set2, Integer.MAX_VALUE);
        System.out.println("Best split - Set 1: " + Arrays.toString(set1) + " - " + Arrays.toString(set2));

        System.out.println("Factorial Recursive: " + factorial(5) + "\n\n");
        System.out.println("Factorial Tail Recursive: " + factorialTail(5, 1) + "\n\n");

        String val = "andreaiacono";
        System.out.println("Reverse (" + val + "): " + reverse(val));
    }

    public static int factorial(int n) {
        if (n == 1) return 1;
        int val = factorial(n - 1);
        System.out.println("factorial(" + n + ") = " + n + "*" + val + " = " + (n * val));
        return n * val;
    }

    public static int factorialTail(int n, int accumulator) {
        if (n == 1) return accumulator;
        System.out.println("factorial(" + n + ") = " + (n) + "*" + accumulator + " = " + ((n) * accumulator));
        return factorialTail(n - 1, n * accumulator);
    }


    public static void splitInTwo(int[] nums, int n, int[] set1, int[] set2, int min) {

        //if (n >= nums.length) return


    }

    public static String reverse(String val) {

        if (val.length() < 2) return val;

        return val.charAt(val.length()-1) + reverse(val.substring(1, val.length()-1)) + val.charAt(0);
    }

}
