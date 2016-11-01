package misc;

import java.util.Arrays;

public class Merge {

    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        while (cCnt < c.length) {
            if (aCnt == a.length) {
                c[cCnt++] = b[bCnt++];
            }
            else if (bCnt == b.length) {
                c[cCnt++] = a[aCnt++];
            }
            else {
                c[cCnt++] = a[aCnt] < b[bCnt] ? a[aCnt++] : b[bCnt++];
            }
        }

        return c;
    }
    public static int[] merge2(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aCnt = 0;
        int bCnt = 0;
        int cCnt = 0;

        while (aCnt < a.length && bCnt < b.length) {
            c[cCnt++] = a[aCnt] < b[bCnt] ? a[aCnt++] : b[bCnt++];
        }

        if (aCnt < a.length) {
            System.arraycopy(a, aCnt, c, cCnt, a.length-aCnt);
        }

        if (bCnt < b.length) {
            System.arraycopy(b, bCnt, c, cCnt, b.length-bCnt);
        }

        return c;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,3,5,7};
        int[] b = new int[] {2,4,5,7,9};

        System.out.println(Arrays.toString(merge2(b, a)));

    }
}
