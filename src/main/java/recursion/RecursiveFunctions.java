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

    static int min = Integer.MAX_VALUE;
    //    static int[] nums = new int[]{23, 45, 12, 11};
    static int[] nums = new int[]{23, 45, 12, 211, 9, 65, 81, 43, 9, 88};
    static int[] set1 = new int[nums.length];
    static int[] set2 = new int[nums.length];


    public static void main(String[] args) {

        System.out.println("Factorial Recursive: " + factorial(5) + "\n");
        System.out.println("Factorial Tail Recursive: " + factorialTail(5, 1) + "\n");

        String val = "andreaiacono";
        System.out.println("Reverse (" + val + "): " + reverse(val));

        System.out.println("Pow(3,4)=" + pow(3, 4));
        System.out.println("PowTail(3,4)=" + powTail(3, 4, 1) + "\n");

        splitInTwo(nums, nums.length - 1, new int[nums.length], new int[nums.length], 0, 0);
        System.out.println("SplitInTwo" + Arrays.toString(nums) + " = " + Arrays.toString(set1) + " - " + Arrays.toString(set2) + " diff = "+ diff(set1, set2));
    }

    public static void splitInTwo(int[] nums, int n, int[] tmpSet1, int[] tmpSet2, int set1Index, int set2Index) {

        if (n < 0) {
            int diff = diff(tmpSet1, tmpSet2);
            if (diff < min) {
                min = diff;
                set1 = Arrays.copyOf(tmpSet1, set1Index);
                set2 = Arrays.copyOf(tmpSet2, set2Index);
            }
            return;
        }

        if (set1Index < nums.length) {
            tmpSet1[set1Index++] = nums[n];
            splitInTwo(nums, n - 1, tmpSet1, tmpSet2, set1Index, set2Index);
            tmpSet1[--set1Index] = 0;
        }
        if (set2Index < nums.length) {
            tmpSet2[set2Index++] = nums[n];
            splitInTwo(nums, n - 1, tmpSet1, tmpSet2, set1Index, set2Index);
            tmpSet2[--set2Index] = 0;
        }
    }

    public static int diff(int[] set1, int[] set2) {
        int sum1 = sum(set1);
        int sum2 = sum(set2);
        return Math.abs(sum1 - sum2);

    }

    public static int sum(int[] vals) {
        int sum = 0;
        for (int j = 0; j < vals.length; j++) {
            sum += vals[j];
        }
        return sum;
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

    public static int pow(int base, int n) {
        if (n == 1) return base;
        return base * pow(base, n - 1);
    }

    public static int powTail(int base, int n, int accumulator) {
        if (n == 0) return accumulator;
        return powTail(base, n - 1, base * accumulator);
    }

    public static String reverse(String val) {

        if (val.length() < 2) return val;

        return val.charAt(val.length() - 1) + reverse(val.substring(1, val.length() - 1)) + val.charAt(0);
    }

}
