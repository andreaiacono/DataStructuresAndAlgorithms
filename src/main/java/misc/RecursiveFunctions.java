package misc;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 04/07/14
 * Time: 13.10
 */
public class RecursiveFunctions {

    public static void main(String[] args) {
        System.out.println("Fibonacci(10)=" + fibonacci(10));
        System.out.println("SumDigits(100345)=" + sumDigits(100345));
        System.out.println("Count7(7667127)=" + count7(7667127));
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    public static int count7(int n) {
        if (n == 0) return 0;
        int sum = n % 10 == 7 ? 1 : 0;
        return count7(n / 10) + sum;
    }
}
