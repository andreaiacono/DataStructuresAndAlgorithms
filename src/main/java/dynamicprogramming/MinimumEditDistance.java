package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MinimumEditDistance {

    @Test
    public void test() {
        assertEquals(2, med("cat", "cars"));
        assertEquals(1, med("cat", "cut"));
        assertEquals(3, med("sunday", "saturday"));
        assertEquals(1, med("abcdefghijklm", "abcdefghijklmn"));
        assertEquals(2, medDp("cat", "cars"));
        assertEquals(1, medDp("cat", "cut"));
        assertEquals(3, medDp("sunday", "saturday"));
        assertEquals(1, editDistDP("abc", "ab"));
        assertEquals(1, editDistDP("ab", "abc"));
        assertEquals(1, editDistDP("abcdefghijklm", "abcdefghijklmn"));
    }

    class Pair {
        String s1;
        String s2;

        public Pair(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return s1.equals(pair.s1) && s2.equals(pair.s2);
        }

        @Override
        public int hashCode() {
            int result = s1 != null ? s1.hashCode() : 0;
            result = 31 * result + (s2 != null ? s2.hashCode() : 0);
            return result;
        }
    }

    Map<Pair, Integer> cache = new HashMap<>();

    int med(String s1, String s2) {
        Pair pair = new Pair(s1, s2);
        if (cache.containsKey(pair)) {
            return cache.get(pair);
        }

        if (s1.equals("") || s2.equals("")) {
            return Math.abs(s1.length() - s2.length());
        }

        int replace = med(s1.substring(1), s2.substring(1)) + (s1.charAt(0) == s2.charAt(0) ? 0 : 1);
        int insert = 1 + med(s1, s2.substring(1));
        int delete = 1 + med(s1.substring(1), s2);

        int min = min(replace, insert, delete);
        cache.put(pair, min);
        return min;
    }


    int editDistDP(String str1, String str2)
    {
        int m = str1.length();
        int n = str2.length();

        // Create a table to store results of subproblems
        int dp[][] = new int[m+1][n+1];

        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // isnert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                            dp[i-1][j],  // Remove
                            dp[i-1][j-1]); // Replace
            }
        }

        return dp[m][n];
    }


    int medDp(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] costs = new int[l1][l2];
        costs[l1-1][l2-1] = s1.charAt(l1-1) == s2.charAt(l2-1) ? 0 : 1;

        for (int i=l2-2; i>=0; i--) {
            costs[l1-1][i] = costs[l1-1][i+1] + 1;
        }

        for (int i=l1-2; i>=0; i--) {
            costs[i][l2-1] = costs[i+1][l2-1] + 1;
        }

        for (int i = s1.length()-2; i>= 0; i--) {
            for (int j = s2.length()-2; j>= 0; j--) {
                int replace = costs[i + 1][j + 1] + (s1.charAt(i) == s2.charAt(j) ? 0 : 1);
                int delete = 1 + costs[i + 1][j];
                int insert = 1 + costs[i][j + 1];
                costs[i][j] = min(replace, delete, insert);
            }
        }

        return costs[0][0];
    }

    public int editDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        int word1Length = word1.length();
        int word2Length = word2.length();

        //minCosts[i][j] represents the edit distance of the substrings
        //word1.substring(i) and word2.substring(j)
        int[][] minCosts = new int[word1Length][word2Length];

        //This is the edit distance of the last char of word1 and the last char of word2
        //It can be 0 or 1 depending on whether the two are different or equal
        minCosts[word1Length - 1][word2Length - 1] = replaceCost(word1, word2, word1Length - 1, word2Length - 1);

        for (int j = word2Length - 2; j >= 0; j--) {
            minCosts[word1Length - 1][j] = 1 + minCosts[word1Length - 1][j + 1];
        }

        for (int i = word1Length - 2; i >= 0; i--) {
            minCosts[i][word2Length - 1] = 1 + minCosts[i + 1][word2Length - 1];
        }

        for (int i = word1Length - 2; i >= 0; i--) {
            for (int j = word2Length - 2; j >= 0; j--) {
                int replace = replaceCost(word1, word2, i, j) + minCosts[i + 1][j + 1];
                int delete = 1 + minCosts[i + 1][j];
                int insert = 1 + minCosts[i][j + 1];
                minCosts[i][j] = min(replace, delete, insert);
            }
        }
        System.out.println(Arrays.deepToString(minCosts));
        return minCosts[0][0];
    }

    public static int replaceCost(String w1, String w2, int w1Index, int w2Index) {
        return (w1.charAt(w1Index) == w2.charAt(w2Index)) ? 0 : 1;
    }


    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
