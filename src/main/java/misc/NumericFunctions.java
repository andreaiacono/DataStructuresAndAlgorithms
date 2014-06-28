package misc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.33
 */
public class NumericFunctions {

    public static void main(String[] args) {

        int n = 27;
        System.out.println("Collatz(" + n + "): " + collatz(n));

        System.out.println("number of 1s of 5: " + numberOf1(5));
        System.out.println("number of 1s of 1254: " + numberOf1(1254));
        System.out.println("number of 1s of 56465: " + numberOf1(56465));
        System.out.println("number of 1s of 45781254: " + numberOf1(45781254));

        n = 1200037006;
        System.out.println("Consec zeros [" + n + "]:" + getConsecutiveZeros(n));
    }


    private static int collatz(int n) {

        int times = 0;

        while (n > 1) {

            System.out.print(n + " ");
            if (n % 2 == 0) {
                n = n / 2;
            }
            else {
                n = 3 * n + 1;
            }
            times++;
        }

        return times;
    }


    public static int getConsecutiveZeros(int number) {
        int counter = 0;
        int max = 0;

        while (number > 1) {

            if (number % 10 == 0) {
                counter++;
            }
            else {
                if (max < counter) {
                    max = counter;
                }
                counter = 0;
            }

            number /= 10;
        }

        if (max < counter) {
            max = counter;
        }

        return max;
    }



    public static int numberOf1(int number) {

        int counter = 0;

        while (number >= 1) {
            int mask = 1;
            counter += mask & number;
        }

        return counter;
    }

}
