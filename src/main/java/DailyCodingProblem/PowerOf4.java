package DailyCodingProblem;

public class PowerOf4 {

    public static void main(String[] args) {

        for (int i=0; i < 5000000; i++) {
            boolean is = isPowerOfFour(i);
            if (is) System.out.println(i);
        }
    }

    static boolean isPowerOfFour(int n) {
        int v = 4;
        while (v > 0) {
            if (n == v) {
                return true;
            }
            v = v << 2;
        }
        return false;
    }
}
