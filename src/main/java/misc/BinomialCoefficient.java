package misc;

/**
 * Created by andrea on 25/08/16.
 */
public class BinomialCoefficient {

    static long[][]values = new long[500][500];

    public static void main(String[] args) {
        assert(binomialCoefficient(5,2) == 10);
        assert(binomialCoefficient(4,2) == 6);
        assert(binomialCoefficient(150,10) == 1169554298222310l);
        System.out.println("Binomial coeeff(50,10)=" + binomialCoefficient(150, 10));
    }

    private static long binomialCoefficient(long n, long k) {
        if (k == 0 || n == k) return 1;
        if (values[(int)n][(int)k] == 0) values[(int)n][(int)k] = binomialCoefficient(n-1, k-1) + binomialCoefficient(n-1, k);
        return values[(int)n][(int)k];
    }
}
