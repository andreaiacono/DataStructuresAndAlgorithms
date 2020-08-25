package DailyCodingProblem;

import java.util.*;


    class A {}
    class B extends A {}
    class C extends B {}

public class NumberDecreaser {


    public static void main(String[] args) {
//        B b = new B();
//        System.out.println(b instanceof B);
//        System.out.println((b instanceof B) && (!(b instanceof A)) );
//        System.out.println((b instanceof B) && (!(b instanceof C)) );

        for (int n=0; n<50; n++){
            System.out.println("res " + n + " = " + ((n & n - 1) == 0));
        }
//
//        int sum = Arrays.asList(4, 4, -1, 7, 5, 10, 9)
//                .stream()
//                .limit(5)
//                .filter(i -> i < 5)
//                .map(i -> i * i)
//                .reduce(0, (a, b) -> a + b);
//        System.out.println(sum);

//        int n = 125327;
        List<Integer> steps = new ArrayList<>();
//        steps.add(n);
//        System.out.println("Smallest number of steps for " + n + " is: " + decreaserSteps(n, 0));
//        System.out.println("Steps for " + n + " are: " + decreaserSteps(n, steps));
//        System.out.println("Iterative steps for " + n + " are: " + iterativeDecreaserSteps(n));
    }

    private static int decreaserSteps(int n, int steps) {
        if (n == 1) {
            return steps;
        }

        int greaterDivisor = getGreaterDivisor(n);
        if (greaterDivisor > 0) {
            int result = decreaserSteps(greaterDivisor, steps + 1);
            if (result > 0) {
                return result;
            }
        }
        int result = decreaserSteps(n - 1, steps + 1);
        if (result > 0) {
            return result;
        }
        return 0;
    }

    private static List<Integer> decreaserSteps(int n, List<Integer> steps) {
        if (n == 1) {
            return steps;
        }

        int greaterDivisor = getGreaterDivisor(n);
        if (greaterDivisor > 0) {
            steps.add(greaterDivisor);
            if (decreaserSteps(greaterDivisor, steps) != null) {
                return steps;
            }
        }
        steps.add(n - 1);
        if (decreaserSteps(n - 1, steps) != null) {
            return steps;
        }
        return null;
    }

    private static List<Integer> iterativeDecreaserSteps(int n) {
        List<Integer> steps = new ArrayList<>();
        steps.add(n);

        while (n > 1) {
            int greaterDivisor = getGreaterDivisor(n);
            if (greaterDivisor > 0) {
                steps.add(greaterDivisor);
                n = greaterDivisor;
                continue;
            }
            steps.add(n - 1);
            n = n-1;
        }
        return steps;
    }

    private static int getGreaterDivisor(int n) {
        int result = 0;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) {
                result = n / i;
            }
        return result;
    }
}
