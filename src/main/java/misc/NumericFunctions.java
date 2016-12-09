package misc;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.33
 */
public class NumericFunctions {

    public static void main(String[] args) {

        int n = 7;
        System.out.println("Collatz(" + n + "): " + collatz(n));
//
//        System.out.println("number of 1s of 5: " + numberOf1(5));
//        System.out.println("number of 1s of 1254: " + numberOf1(1254));
//        System.out.println("number of 1s of 56465: " + numberOf1(56465));
//        System.out.println("number of 1s of 45781254: " + numberOf1(45781254));

        n = 1200037006;
        System.out.println("Consec zeros [" + n + "]:" + getConsecutiveZeros(n));

        double d = 125;
        System.out.println("Square root(" + d + ")=" + squareRoot(d, 0.00001));

        System.out.println(numSetBits(1));
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

    static public int numSetBits(long a) {

        int counter = 0;
        while (a > 0) {
            counter += a & 1;
            a >>= 1;
        }

        return counter;
    }


    public static int numberOf1(int number) {

        int counter = 0;

        while (number >= 1) {
            int mask = 1;
            counter += mask & number;
        }

        return counter;
    }


    public static double squareRoot(double val, double precision) {

        double diff = Double.MAX_VALUE;
        double sr = 1;
        int counter = 0;

        while (Math.abs(diff) > precision && ++counter<100) {
            diff = (sr * sr) - val;
            sr -= diff/20;
        }

        return sr;

    }
}
