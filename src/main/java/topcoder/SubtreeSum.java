package topcoder;

import java.util.Arrays;

public class SubtreeSum {

    public int getSum(int[] p, int[] x) {

        System.out.println("getSum " + Arrays.toString(p) + " xz=" + Arrays.toString(x));
        if (p.length == 0) {
            System.out.println("returning " + x[p[0]] + " p=" + p[0]);
            return x[p[0]];
        }

        int sum = 0;
        for (int j=0; j<p.length; j++) {
            sum += getSum(Arrays.copyOfRange(x, p[j], p[j]+1), x);
        }

        return sum;
    }

    private int[] getSubarray(int[] a, int from, int to) {
        return Arrays.copyOfRange(a, from, to);
    }

    public static void main(String[] args) {
        SubtreeSum sub = new SubtreeSum();
        System.out.println(sub.getSum(new int [] {0}, new int[] {1,2}));
    }
}
