package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NestingDepth {


    static String input = "9\n" +
            "0000\n" +
            "101\n" +
            "111000\n" +
            "1\n" +
            "021\n" +
            "312\n" +
            "3241753623681269476324862387456123796542387964023947983264873248644893463742645976496412387124876237468327\n" +
            "987654321234566789876543212345667898765432123456678987654321234566789876543212345667898765432123456678987654321234566789\n" +
            "22321231267812631\n";

    public static void main(String[] args) {
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            String s = in.next();
            String result = nestingDepth(s);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    private static String nestingDepth(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 48;

            // open
            int toOpen = n - count;
            count += toOpen;
            result.append(open(toOpen)).append(n);

            // close
            int toClose = count;
            if (i < s.length() - 1) {
                int next = (s.charAt(i+1) - 48);
                if (n > next) {
                    toClose = n - next;
                }
                else {
                    toClose = 0;
                }
            }
            count -= toClose;
            result.append(close(toClose));
        }
        return result.toString();
    }


    private static StringBuilder open(int n) {
        return by(n, '(');
    }

    private static StringBuilder close(int n) {
        return by(n, ')');
    }

    private static StringBuilder by(int n, char c) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(c);
        }
        return builder;
    }
}
