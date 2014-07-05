package misc;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 04/07/14
 * Time: 13.10
 */
public class RecursiveFunctions {

    public static void main(String[] args) {
        System.out.println("Fibonacci(10)=" + fibonacci(10));
        System.out.println("SumDigits(100345)=" + sumDigits(100345));
        System.out.println("Count7(7667127)=" + count7(7667127));
        System.out.println("PowerN(3,4)=" + powerN(3, 4));
        String val = "jgfjcxxxxxsfbjc";
        System.out.println("CountX('"+ val + "')=" + countX(val));
        val = "adfsdanhidfsdaghi";
        System.out.println("CountHi('"+ val + "')=" + countHi(val));
        val = "ahxsabfjabxzxqsgxxs";
        System.out.println("changeXToY('"+ val + "')=" + changeXToY(val));
        val = "pip";
        System.out.println("changePi('"+ val + "')=" + changePi(val));
        val = "xcxafcxafcaxxa";
        System.out.println("removeX('"+ val + "')=" + removeX(val));
        int[] nums = {1, 6, 6, 4};
        System.out.println("array6('"+ Arrays.toString(nums) + "')=" + array6(nums, 0));

        nums = new int[] {11, 6, 11, 4, 11, 11};
        System.out.println("array11('"+ Arrays.toString(nums) + "')=" + array11(nums, 0));

        nums = new int[] {11, 6, 6, 4, 11, 110};
        System.out.println("array220('"+ Arrays.toString(nums) + "')=" + array220(nums, 0));

        val = "1234567890";
        System.out.println("allStar('"+ val + "')=" + allStar(val));

    }

    public static String allStar(String str) {
        int pos = str.indexOf("*");
        if (pos == 1) return "*" + str;
        if (pos == -1) pos = str.length();
        return allStar(str.substring(0, pos-1) + "*" + str.substring(pos-1));
    }


    public static boolean array220(int[] nums, int index) {
        if (index == nums.length-1) return false;
        return nums[index+1] == nums[index]*10 || array220(nums, index+1);
    }

    public static int array11(int[] nums, int index) {
        if (index == nums.length) return 0;
        int result = nums[index] == 11 ? 1 : 0;
        return result + array11(nums, index + 1);
    }

    public static boolean array6(int[] nums, int index) {
        if (index == nums.length) return false;
        return nums[index] == 6 || array6(nums, index+1);
    }

    public static String removeX(String val) {
        int pos = val.indexOf("x");
        if (val.length() == 0 || pos < 0) return val;
        return removeX(val.substring(0, pos) + val.substring(pos + 1));
    }

    public static String changePi(String val) {
        int pos = val.indexOf("pi");
        if (val.length() == 0 || pos < 0) return val;
        return changePi(val.substring(0, pos) + "3.14" + val.substring(pos + 2));
    }

    public static String changeXToY(String val) {
        int pos = val.indexOf("x");
        if (val.length() == 0 || pos < 0) return val;
        return changeXToY(val.substring(0, pos) + "y" + val.substring(pos+1));
    }

    public static int countHi(String val) {
        if (val.length() == 0) return 0;
        int result = val.charAt(val.length()-1) == 'i' && val.charAt(val.length()-2) == 'h' ? 1 : 0;
        return result + countHi(val.substring(0, val.length() - 1));
    }

    public static int countX(String val) {
        if (val.length() == 0) return 0;
        int result = val.charAt(val.length()-1) == 'x' ? 1 : 0;
        return result + countX(val.substring(0, val.length()-1));
    }

    public static int powerN(int base, int n) {

        if (n == 0) return 1;
        return base * (powerN(base, n-1));
    }

    public static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    public static int count7(int n) {
        if (n == 0) return 0;
        int sum = n % 10 == 7 ? 1 : 0;
        return count7(n / 10) + sum;
    }
}
