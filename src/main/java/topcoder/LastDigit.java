package topcoder;

import java.util.ArrayList;
import java.util.List;

public class LastDigit {

    public long findX(long S) {

        ArrayList<Long> digits = new ArrayList<>();
        return recurse(S, 0, digits);
    }

    public long recurse(long S, long sum, List<Long> digits) {
        if (S == listSum(digits)) {
            return listToLong(digits);
        }
        if (sum > S) return -1;
        long value = -1;
        for (int j=0; j<10; j++) {
            if (sum == 0 && j==0) continue;
            digits.add((long) j);
            if (listSum(digits) > S) {
                digits.remove(digits.size()-1);
                continue;
            }
            value = recurse(S, listToLong(digits), digits);
            if (value != -1) {
                return value;
            }
            digits.remove(digits.size()-1);
        }

        return value;
    }

    private long listToLong(List<Long> digits) {
        long sum = 0;
        long exp = digits.size()-1;
        for (long digit: digits) {
            sum += digit * Math.pow(10, exp--);
        }
        return sum;
    }

    private long listSum(List<Long> digits) {
        long sum = 0;
        String value = "";
        for (long digit: digits) {
            value += digit;
            sum += Long.parseLong(value);
        }
        return sum;
    }

    public static void main(String[] args) {
        LastDigit lastDigit = new LastDigit();
        System.out.println("result= " + lastDigit.findX(137174210616796l));
    }
}
