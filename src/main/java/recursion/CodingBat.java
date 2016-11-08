package recursion;

import java.util.Arrays;

/**
 * CodingBat recursion exercises
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 04/07/14
 * Time: 13.10
 */
public class CodingBat {

    public static void main(String[] args) {
        System.out.println("Fibonacci(10)=" + fibonacci(10));
        System.out.println("SumDigits(100345)=" + sumDigits(100345));
        System.out.println("Count7(7667127)=" + count7(7667127));
        System.out.println("PowerN(3,4)=" + powerN(3, 4));
        String val = "jgfjcxxxxxsfbjc";
        System.out.println("CountX('" + val + "')=" + countX(val));
        val = "adfsdanhidfsdaghi";
        System.out.println("CountHi('" + val + "')=" + countHi(val));
        val = "ahxsabfjabxzxqsgxxs";
        System.out.println("changeXToY('" + val + "')=" + changeXToY(val));
        val = "pip";
        System.out.println("changePi('" + val + "')=" + changePi(val));
        val = "xcxafcxafcaxxa";
        System.out.println("removeX('" + val + "')=" + removeX(val));
        int[] nums = {1, 6, 6, 4};
        System.out.println("array6('" + Arrays.toString(nums) + "')=" + array6(nums, 0));

        nums = new int[]{11, 6, 11, 4, 11, 11};
        System.out.println("array11('" + Arrays.toString(nums) + "')=" + array11(nums, 0));

        nums = new int[]{11, 6, 6, 4, 11, 110};
        System.out.println("array220('" + Arrays.toString(nums) + "')=" + array220(nums, 0));

        val = "1234567890";
        System.out.println("allStar('" + val + "')=" + allStar(val));
        val = "abccdeffghh";
        System.out.println("pairStart('" + val + "')=" + pairStar(val));
        val = "hgfxaxcsfx";
        System.out.println("endX('" + val + "')=" + endX(val));
        val = "ihihhh";
        System.out.println("countPairs('" + val + "')=" + countPairs(val));
        val = "ababc";
        System.out.println("countAbc('" + val + "')=" + countAbc(val));
    }

    public static boolean split53(int[] nums) {

        return split53Helper(nums, 0, 0, 0);
    }

    public static boolean split53Helper(int[] nums, int n, int sum1, int sum2) {
        if (n >= nums.length) return sum1 == sum2;

        if (nums[n] % 5 == 0) {
            return split53Helper(nums, n + 1, sum1 + nums[n], sum2);
        }
        else if (nums[n] % 3 == 0) {
            return split53Helper(nums, n + 1, sum1, sum2 + nums[n]);
        }
        else
            return split53Helper(nums, n + 1, sum1 + nums[n], sum2) || split53Helper(nums, n + 1, sum1, sum2 + nums[n]);
    }

    public static boolean splitOdd10(int[] nums) {
        return splitOdd10Helper(nums, 0, 0, 0);
    }

    public static boolean splitOdd10Helper(int[] nums, int n, int sum1, int sum2) {
        if (n >= nums.length) return sum1 % 10 == 0 && sum2 % 2 == 1;
        return splitOdd10Helper(nums, n + 1, sum1 + nums[n], sum2) || splitOdd10Helper(nums, n + 1, sum1, sum2 + nums[n]);
    }


    public static boolean splitArray(int[] nums) {
        return splitHelper(nums, 0, 0, 0);
    }

    public static boolean splitHelper(int[] nums, int n, int sum1, int sum2) {
        if (n >= nums.length) return sum1 == sum2;
        return splitHelper(nums, n + 1, sum1 + nums[n], sum2) || splitHelper(nums, n + 1, sum1, sum2 + nums[n]);
    }


    public static boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;

        int counter = 1;
        while (start + counter < nums.length && nums[start] == nums[start + counter]) {
            counter++;
        }
        if (counter > 1) {
            if (groupSumClump(start + counter, nums, target - (nums[start] * (counter)))) return true;
            if (groupSumClump(start + counter, nums, target)) return true;
        }
        else {
            if (groupSumClump(start + 1, nums, target - nums[start])) return true;
            if (groupSumClump(start + 1, nums, target)) return true;
        }
        return false;
    }

    public static boolean groupSum5(int start, int[] nums, int target) {

        if (start >= nums.length) return target == 0;

        if (nums[start] % 5 != 0) {
            if (groupSum5(start + 1, nums, target)) return true;
            if (groupSum5(start + 1, nums, target - nums[start])) return true;
        }
        else {
            if (start < nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            return (groupSum5(start + 1, nums, target - nums[start]));
        }
        return false;
    }

    public static boolean groupNoAdj(int start, int[] nums, int target) {

        if (start >= nums.length) return target == 0;

        if (groupNoAdj(start + 2, nums, target - nums[start])) return true;
        if (groupNoAdj(start + 1, nums, target)) return true;

        return false;
    }


    public static boolean groupSum6(int start, int[] nums, int target) {

        if (start >= nums.length) return target == 0;

        if (groupSum6(start + 1, nums, target - nums[start])) return true;
        if (nums[start] != 6 && groupSum6(start + 1, nums, target)) return true;

        return false;
    }

    public static boolean groupSum(int start, int[] nums, int target) {

        if (start > nums.length - 1) return (target == 0);
        if (groupSum(start + 1, nums, target - nums[start])) return true;
        if (groupSum(start + 1, nums, target)) return true;
        return false;
    }

    public int strDist(String str, String sub) {
        int subLen = sub.length();
        if (str.length() < subLen) return 0;
        if (str.startsWith(sub)) {
            if (str.substring(str.length() - subLen).equals(sub)) return str.length();
            else return strDist(str.substring(0, str.length() - 1), sub);
        }
        else return strDist(str.substring(1), sub);
    }

    public static boolean strCopies(String str, String sub, int n) {
        int subLen = sub.length();
        if (str.length() < subLen) return n == 0;
        if (str.substring(0, subLen).equals(sub)) return strCopies(str.substring(1), sub, n - 1);
        return strCopies(str.substring(1), sub, n);
    }

    public static int strCount(String str, String sub) {
        if (str.length() < sub.length()) return 0;

        if (str.substring(0, sub.length()).equals(sub)) return 1 + strCount(str.substring(sub.length()), sub);
        return strCount(str.substring(1), sub);
    }

    public static boolean nestParen(String str) {
        if (str.length() == 0) return true;
        if (str.length() == 1) return false;

        if (str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')')
            return true && nestParen(str.substring(1, str.length() - 1));
        return false;
    }

    public static String parenBit(String str) {
        if (str.length() == 1) return str;
        if (str.charAt(0) == '(') {
            int pos = str.indexOf(")");
            return "(" + str.substring(1, pos) + ")";
        }
        return parenBit(str.substring(1));
    }

    public static int countHi2(String str) {
        if (str.length() < 2) return 0;
        if (str.charAt(0) == 'h' && str.charAt(1) == 'i') return 1 + countHi2(str.substring(2));
        if (str.charAt(0) != 'x' && str.charAt(1) == 'h' && str.charAt(2) == 'i') return 1 + countHi2(str.substring(3));
        if (str.charAt(0) == 'x' && str.charAt(1) == 'h' && str.charAt(2) == 'i') return countHi2(str.substring(3));
        return countHi2(str.substring(1));
    }

    public static String stringClean(String str) {
        if (str.length() < 2) return str;
        if (str.charAt(0) == str.charAt(1)) return stringClean(str.substring(1));
        return str.charAt(0) + stringClean(str.substring(1));
    }

    public int count11(String str) {
        if (str.length() < 2) return 0;
        if (str.charAt(0) == '1' && str.charAt(1) == '1') return 1 + count11(str.substring(2));
        return count11(str.substring(1));
    }


    public static int countAbc(String str) {
        if (str.length() < 3) return 0;
        if (str.substring(0, 3).equals("abc") || str.substring(0, 3).equals("aba"))
            return 1 + countAbc(str.substring(1));
        return countAbc(str.substring(1));
    }


    public static int countPairs(String str) {
        if (str.length() < 3) return 0;
        if (str.charAt(0) == str.charAt(2)) return 1 + countPairs(str.substring(1));
        return countPairs(str.substring(1));
    }

    public static String endX(String str) {
        int pos = str.indexOf("x");
        if (pos == -1) return str;
        if (pos == 0) return endX(str.substring(1)) + "x";
        return str.substring(0, pos) + endX(str.substring(pos + 1)) + "x";

    }

    public static String pairStar(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == str.charAt(1)) return str.charAt(0) + "*" + pairStar(str.substring(1));
        return str.charAt(0) + pairStar(str.substring(1));
    }

    public static String allStar(String str) {
        if (str.length() <= 1) return str;
        int pos = str.indexOf("*");
        if (pos == 1) return str;
        if (pos == -1) pos = str.length();
        return allStar(str.substring(0, pos - 1) + "*" + str.substring(pos - 1));

    }

    public static boolean array220(int[] nums, int index) {
        if (index == nums.length - 1) return false;
        return nums[index + 1] == nums[index] * 10 || array220(nums, index + 1);
    }

    public static int array11(int[] nums, int index) {
        if (index == nums.length) return 0;
        int result = nums[index] == 11 ? 1 : 0;
        return result + array11(nums, index + 1);
    }

    public static boolean array6(int[] nums, int index) {
        if (index == nums.length) return false;
        return nums[index] == 6 || array6(nums, index + 1);
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
        return changeXToY(val.substring(0, pos) + "y" + val.substring(pos + 1));
    }

    public static int countHi(String val) {
        if (val.length() == 0) return 0;
        int result = val.charAt(val.length() - 1) == 'i' && val.charAt(val.length() - 2) == 'h' ? 1 : 0;
        return result + countHi(val.substring(0, val.length() - 1));
    }

    public static int countX(String val) {
        if (val.length() == 0) return 0;
        int result = val.charAt(val.length() - 1) == 'x' ? 1 : 0;
        return result + countX(val.substring(0, val.length() - 1));
    }

    public static int powerN(int base, int n) {

        if (n == 0) return 1;
        return base * (powerN(base, n - 1));
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
