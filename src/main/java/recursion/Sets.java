package recursion;

import java.util.*;

public class Sets {


    static Map<Set<Integer>, Set<Set<Integer>>> cache = new HashMap<>();

    public static Set<Set<Integer>> allSubsets(Set<Integer> set) {

        if (cache.containsKey(set)) {
            return cache.get(set);
        }

        Set<Set<Integer>> result = new HashSet<>();
        result.add(set);

        for (int n: set) {
            result.addAll(allSubsets(removeElementFromSet(n, set)));
        }

        cache.put(set, result);
        return result;
    }

    private static Set<Integer> removeElementFromSet(int n, Set<Integer> set) {
        Set<Integer> newSet = new HashSet(set);
        newSet.remove(n);
        return newSet;
    }

    public static Set<Pair> getPairs(Integer[] n, int index) {

        Set<Pair> pairs = new HashSet<>();
        if (index == n.length) {
            return pairs;
        }

        for (int j=index+1; j<n.length; j++) {
            pairs.add(new Pair(n[index], n[j]));
        }
        pairs.addAll(getPairs(n, index+1));

        return pairs;
    }

    public static Set<Triple> getTriples(Integer[] n, int index) {

        Set<Triple> triples = new HashSet<>();
        if (index == n.length) {
            return triples;
        }

        for (int j=index+1; j<n.length; j++) {
            for (int i=j+1; i<n.length; i++) {
                triples.add(new Triple(n[index], n[j], n[i]));
            }
        }
        triples.addAll(getTriples(n, index+1));

        return triples;
    }


    static class Triple {
        int first;
        int second;
        int third;

        public Triple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public String toString() {
            return "(" + first + "," + second + "," + third + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triple triple = (Triple) o;
            if (first != triple.first) return false;
            if (second != triple.second) return false;
            return third == triple.third;
        }

        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            result = 31 * result + third;
            return result;
        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "(" + first + "," + second + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            if (first != pair.first) return false;
            return second == pair.second;
        }

        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }
    }


    static Map<List<Integer>, Set<List<Integer>>> binomialCache = new HashMap<>();

    public static Set<List<Integer>> nChooseK(Integer[] n, int k) {

        if (n.length < k) {
            return new HashSet<>();
        }

        List<Integer> values = Arrays.asList(n);

        if (binomialCache.containsKey(values)) {
            return binomialCache.get(values);
        }

        Set<List<Integer>> result = new HashSet<>();
        if (n.length == k) {
            result.add(values);
            return result;
        }

        for (int j=0; j<n.length; j++) {
            Integer b[] = removeElementAtIndex(n, j);
            result.addAll(nChooseK(b, k));
        }

        binomialCache.put(values, result);
        return result;
    }

    public static boolean subsetSum(int n[], int sum) {

        if (Arrays.stream(n).sum() == sum) {
            System.out.println("Found subset sum for " + Arrays.toString(n));
            return true;
        }

        for (int j=0; j<n.length; j++) {
            int b[] = removeElementAtIndex(n, j);
            if (subsetSum(b, sum)) {
                return true;
            }
        }

        return false;
    }

    private static Integer[] removeElementAtIndex(Integer[] n, int index) {
        Integer b[] = new Integer[n.length-1];
        int counter = 0;
        for (int j=0; j<n.length; j++) {
            if (j == index) {
                continue;
            }
            b[counter++] = n[j];
        }
        return b;
    }

    private static int[] removeElementAtIndex(int[] n, int index) {
        int b[] = new int[n.length-1];
        int counter = 0;
        for (int j=0; j<n.length; j++) {
            if (j == index) {
                continue;
            }
            b[counter++] = n[j];
        }
        return b;
    }


    static List<String> parenthesis = new ArrayList<>();


    public static void parenthesisGenerator(int n) {
        innerParenthesisGenerator(n, 0, 0, "");
    }

    private static void innerParenthesisGenerator(int n, int opened, int closed, String s) {

        if (opened > n) {
            return;
        }
        if (closed > opened) {
            if (s.length() == n*2+1) {
                System.out.println(s.substring(0, s.length() - 1));
            }
            return;
        }
        innerParenthesisGenerator(n, opened+1, closed, s + "(");
        innerParenthesisGenerator(n, opened, closed+1, s + ")");
    }


    public static int coinChange(int[] values, int sum) {
        System.out.println("call with sum " + sum);
        if (sum == 0) {
            return 1;
        }
        int results = 0;
        for (int value : values) {
            System.out.println("Looping on " + value);
            if (sum - value >= 0) {
                results += coinChange(values, sum - value);
                System.out.println("results is now "+ results);
            }
        }

        System.out.println("returning " + results);
        return results;
    }


    private static String deleteAt(int index, String s) {
        if (index == 0) return s.substring(1);
        if (index == s.length()-1) return s.substring(0, s.length()-1);
        return s.substring(0, index) + s.substring(index+1);
    }

    private static String swap(int a, int b, String s) {
        char[] chars = s.toCharArray();
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
        return new String(chars);
    }
}
