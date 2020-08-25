package elements;

public class StringToInt {

    public static void main(String[] args) {
        String val = "123";
        System.out.println(val + "=" + strToint(val));
        val = "999";
        System.out.println(val + "=" + strToint(val));
        val = "10000000";
        System.out.println(val + "=" + strToint(val));
        val = "-1";
        System.out.println(val + "=" + strToint(val));
    }

    public static int strToint(String val) {

        boolean isNegative = val.charAt(0) == '-';
        if (isNegative) {
            val = val.substring(1);
        }

        int total = 0;
        for (int i=val.length()-1; i>=0; i--) {

            int digit = ((int) val.charAt(i)) - '0';
            total += digit * Math.pow(10, val.length()-i-1);
        }

        return total * (isNegative ? -1 : 1);
    }
}
