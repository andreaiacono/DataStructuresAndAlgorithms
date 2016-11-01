package topcoder;

import java.util.Arrays;

public class DivisibleSetDiv2 {

    public String isPossible(int[] b) {
        int[] a = new int[b.length];
        Arrays.fill(a, 2);
        return inner(a, b, 0);
    }

    private String inner(int[] a, int[] b, int index) {
        System.out.println("inner a=" + Arrays.toString(a) + " b=" + Arrays.toString(b) + " index=" + index);
        if (isDivisible(a, b)) return "Possible";
        if (a[index] >= Math.pow(2, 30)) return "Impossible";
        for (int j=index; j<a.length; j++) {
            a[j] *= 2;
            if (inner(a, b, j).equals("Possible")) return "Possible";
            a[j] /= 2;
        }

        return "Impossible";
    }

    private boolean isDivisible(int[] a, int b[]) {

        int prod = Arrays.stream(a).reduce(1, (x, y) -> x*y);

        for (int j=0; j<a.length; j++) {
            if (Math.pow(a[j], b[j]) % prod != 0) return false;
        }

        System.out.println("Possible!!!!");
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new DivisibleSetDiv2().isPossible(new int[] {7,10,4,6,3}));
    }
}
