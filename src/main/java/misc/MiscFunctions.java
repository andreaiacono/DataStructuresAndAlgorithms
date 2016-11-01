package misc;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.29
 */

public class MiscFunctions {


    public static void main(String[] args) {
        FizzBuzz();
    }

    public static void FizzBuzz() {

        String value;

        for (int j=1; j<=100; j++) {
            if (j % 15 == 0 ) value = "FizzBuzz";
            else if (j % 3 == 0) value = "Fizz";
            else if (j % 5 == 0) value = "Buzz";
            else value = "" + j;
            System.out.println(value);
        }
    }
}