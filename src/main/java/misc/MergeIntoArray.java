package misc;

import java.util.Arrays;

public class MergeIntoArray {

    public static void main(String[] args) {
        int a[] = new int [] {1,3,5,7,0,0,0,0};
        int b[] = new int [] {2,4,6,8};

        System.out.println("Result=" + Arrays.toString(mergeInto(a, b)));
    }

    public static int[] mergeInto(int[] a, int[] b) {
        int aCnt = 0;
        int bCnt = 0;
        while (bCnt < b.length && aCnt < a.length) {
            System.err.println("a=" + Arrays.toString(a) + " acnt=" + aCnt + " bcnt=" + bCnt);
            if (a[aCnt] > b[bCnt]) {
                System.arraycopy(a, aCnt, a, aCnt+1, a.length-aCnt-1);
                a[aCnt] = b[bCnt++];
            }
            else {
                aCnt++;
            }
        }

        return a;
    }
}
