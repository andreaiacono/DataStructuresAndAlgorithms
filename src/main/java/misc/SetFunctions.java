package misc;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 09/07/14
 * Time: 13.30
 */
public class SetFunctions {

    public static void main(String[] args) {

        int[] a = { 6, 8, 9, 12, 16};
        int[] b = { 1, 3, 5, 7, 9, 16};

        int k = 7;
        System.out.println("Smallest(" + k + "):" + getKthSmallestElementTrivial(k, a, b));
        System.out.println("Intersection:" + Arrays.toString(intersect(a, b)));
    }


    public static int getKthSmallestElementTrivial(int k, int[] a, int[] b) {

        int counter = 0;
        int aindex=0, bindex=0;
        int result = 0;

        while (counter < k) {

            if (a[aindex] < b[bindex]) {
                result = a[aindex];
                aindex++;
            }
            else {
                result = b[bindex];
                bindex++;
            }

            counter ++;
        }

        return result;
    }

    public static int[] intersect(int[] a, int[] b) {

        int[] is = new int[Math.min(a.length, b.length)];

        int counter = 0;
        int aindex=0, bindex=0;

        do {
            if (a[aindex] == b[bindex]) {
                is[counter++] = a[aindex];
                aindex++;
                bindex++;
            }
            else {

                if (a[aindex] < b[bindex]) {
                    aindex++;
                }
                else {
                    bindex++;
                }
            }
        } while (aindex < a.length && bindex<b.length);

        return is;
    }
}
