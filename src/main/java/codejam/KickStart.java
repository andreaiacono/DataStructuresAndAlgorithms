package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KickStart {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int result = readFragment(in.next());
            System.out.println("Case #" + i + ": " + result);
        }
    }

    static char[] kick = new char[] { 'K', 'I', 'C', 'K' };
    static char[] start = new char[] { 'S', 'T', 'A', 'R', 'T' };

    static int readFragment(String s) {

        int open = 0;
        int index = 0;
        int result = 0;

        while (index < s.length() - 4) {

            if (isKick(s, index)) {
                open ++;
            }
            else if (isStart(s, index) && open > 0) {
                result += open;
            }

            index ++;
        }

        return result;
    }

    static boolean isWord(String s, int index, char[] word) {
        for (int i = 0; i<word.length; i++ ) {
            if (s.charAt(index + i) != word[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean isKick(String s, int index) {
        return isWord(s, index, kick);
    }
    static boolean isStart(String s, int index) {
        return isWord(s, index, start);
    }

}
