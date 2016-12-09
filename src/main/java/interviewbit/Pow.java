package interviewbit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Pow {

    @Test
    public void test() {
        assertEquals(19, pow(-1, 1, 20));
//        assertEquals(20805472, pow(71045970, 41535484, 64735492));
        assertEquals(46340, sqrt(2147483647));
    }

    public long sqrt(int a) {
        if (a == 0 || a == 1) {
            return a;
        }

        long start = 1;
        long end = a/2 + 1;
        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            System.out.println("mid=" + mid);
            if (mid * mid == a) {
                return mid;
            }

            if (mid * mid < a) {
                start = mid + 1;
                ans = mid;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public int pow(int x, int n, int d) {
        if (d == 1) {
            return 0;
        }
        if (n == 0) {
            return 1 % d;
        }

        long result = 1;
        x = x % d;
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * x) % d;
//                System.out.println("result=" + result + " x=" + x + " d=" + d);
            }

            n = n >> 1;
            x = (x * x) % d;
        }

        if (result < 0) {
            return (int) (d + result);
        }
        return (int) result;
    }

    public int pow2(int x, int n, int d) {

        if (d == 1) {
            return 0;
        }
        if (n == 0) {
            return 1 % d;
        }

        long pow = pow(x, n);
        System.out.println(pow);
        if (pow < 0) {
            return d + (int) (pow % d);
        }
        return (int) (pow % d);

    }

    long pow(int x, int n) {

        if (n == 0) {
            return 1;
        }
        long half = pow(x, n / 2);
        System.out.println("Half=" + half);
        if (n % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
}

/*
public class Solution {

    public int pow(int x, int n, int d) {

        if (d == 1) {
            return 0;
        }
        if (n == 0) {
            return 1 % d;
        }

        long pow = pow(x, n);
        if (pow < 0) {
            return d + (int)(pow % d);
        }
        return (int)(pow % d);

    }

    long pow(int x, int n) {

        if (n == 0) {
            return 1;
        }
        long half = pow(x, n / 2);
        if (n % 2 == 0)	{
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
*/
/*
        long prod = 1;

	    while (n > 0) {
            if (n % 2 != 0) {
                prod = prod * x;
            }

            x = x * x;
            n = n / 2;
        }

	    if (prod < 0) {
	        return d + (int)(prod % d);
	    }
	    return (int)(prod % d);
	    */
/*
}
*/