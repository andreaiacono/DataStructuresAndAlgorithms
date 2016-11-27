package pramp;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DifferentNumber {

    @Test
    public void test() {
        int[] a = new int[]{1};
        assertTrue(new Integer(1) != getAnotherNumber(a));
        assertTrue(new Integer(1) != getAnotherNumber2(a));
        assertTrue(new Integer(1) != differentNumber(a));

        a = new int[]{0};
        assertTrue(new Integer(0) != getAnotherNumber(a));
        assertTrue(new Integer(0) != getAnotherNumber2(a));
        assertTrue(new Integer(0) != differentNumber(a));

        a = new int[]{Integer.MAX_VALUE};
        assertTrue(Integer.MAX_VALUE != getAnotherNumber(a));
        assertTrue(Integer.MAX_VALUE != getAnotherNumber2(a));
        assertTrue(Integer.MAX_VALUE != differentNumber(a));

        a = new int[]{0, 1, 2, 3, 4};
        int n = getAnotherNumber(a);
        assertTrue(n > 4);
        int n2 = getAnotherNumber2(a);
        assertTrue(n2 > 4);

        int n3 = differentNumber(a);
        assertTrue(n3 > 4);

        a = new int[]{0, 1, 2, 3, 4, 6, 7};
        n = getAnotherNumber(a);
        assertTrue(n == 5 || n > 7);

        n2 = getAnotherNumber2(a);
        assertTrue(n2 == 5 || n2 > 7);

        n3 = differentNumber(a);
        assertTrue(n3 == 5 || n3 > 7);

        // for this test to run, you need to set -Xmx12500M as parameter of the JVM.
        // Due to internal JVM implementation (which can vary from OS to OS and from vendor
        // to vendor), the maximum array size for a Linux 64bit Oracle JVM is Integer.MAX_VALUE -2.
        a = new int[Integer.MAX_VALUE-2];
        for (int j=0; j<a.length; j++) {
            a[j] = j;
        }
        assertNull(getAnotherNumber(a));
    }


    Integer differentNumber(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int s : arr){
            set.add(s);
        }

        int i=0;
        while (set.contains(i) && i <= Integer.MAX_VALUE) {++i;}
        if (i >= 0) { return i; }
        return null;
    }


    Integer getAnotherNumber2(int[] arr) {
        int n = arr.length;
        int[] arr2 = new int[n+1];

        for (int j=0; j<n; j++) {
            int num = arr[j];
            arr2[num % (n+1)] = 1;
        }

        for (int j=0; j<n+1; j++) {
            if (arr2[j] == 0) {
                return j;
            }
        }

        return null;
    }

    Integer getAnotherNumber(int[] a) {

        if (a == null) {
            return null;
        }
        if (a.length == 0) {
            return 1;
        }
        if (a.length > Integer.MAX_VALUE) {
            return null;
        }

        Arrays.sort(a);

        if (a[0] > 0) {
            return 0;
        }
        if (a[a.length-1] < Integer.MAX_VALUE-3) {
            return Integer.MAX_VALUE;
        }

        int index = 1;
        while (index < a.length) {
            if (a[index] - a[index - 1] > 1) {
                return a[index - 1] + 1;
            }
            index ++;
        }

        return null;
    }

}
