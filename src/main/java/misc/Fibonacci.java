package misc;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
    }

    static int fibonacci(int n) {
        int counter = 0;
        int first = 0;
        int second = 1;
        while (counter < n) {
            int tmp = first + second;
            first = second;
            second = tmp;
            counter ++;
        }
        return first;
    }
}
