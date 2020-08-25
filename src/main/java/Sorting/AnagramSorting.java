package sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class AnagramSorting {

    class Anagram implements Comparable {

        String value;
        String sortedValue;


        public Anagram(String value) {
            this.value = value;
            this.sortedValue = sort(value);
        }

        private String sort(String value) {
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Anagram) {
                return sortedValue.compareTo(((Anagram) o).sortedValue);
            }

            return -1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Anagram anagram = (Anagram) o;

            return value != null ? value.equals(anagram.value) : anagram.value == null;

        }

        @Override
        public int hashCode() {
            return value != null ? value.hashCode() : 0;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @Test
    public void test() {
        Anagram[] values = new Anagram[]{new Anagram("adg"), new Anagram("abc"), new Anagram("ccc"), new Anagram("gda"), new Anagram("feg"), new Anagram("dag"), new Anagram("tsh"), new Anagram("lts"), new Anagram("gad")};
        Anagram[] sorted = new Anagram[]{new Anagram("abc"), new Anagram("adg"), new Anagram("gda"), new Anagram("dag"), new Anagram("gad"), new Anagram("ccc"), new Anagram("feg"), new Anagram("tsh"), new Anagram("lts")};

        System.out.println("values=" + Arrays.toString(values));
        Arrays.sort(values, (a1,a2) -> a1.compareTo(a2));
        System.out.println("values=" + Arrays.toString(values));
        assertTrue(Arrays.equals(values, sorted));
    }
}
