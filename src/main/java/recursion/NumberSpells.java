package recursion;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class NumberSpells {

    @Test
    public void test() {
        assertEquals("8 88", insertSpaceAt(1, "888"));
        assertEquals("88 8", insertSpaceAt(2, "888"));
        assertEquals("8 8 8", insertSpaceAt(2, "8 88"));
        assertEquals("88 8", insertSpaceAt(2, "88 8"));
        assertEquals("88 8", insertSpaceAt(2, "888"));
        assertEquals("8 8 88", insertSpaceAt(2, "8 888"));
        assertEquals("8 8 8 8", insertSpaceAt(3, "8 8 88"));
        Set<String> set = new HashSet<>();
        set.add("888");
        set.add("8 88");
        set.add("8 8 8");
        set.add("88 8");
        assertEquals(set, getSpells("888", 1));

        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        Set<String> set2 = new HashSet<>();
        set2.add("a");
        set2.add("b");
        set2.add("c");
        Set<String> product = new HashSet<>();
        product.add("a a");
        product.add("a b");
        product.add("a c");
        product.add("b a");
        product.add("b b");
        product.add("b c");
        product.add("c a");
        product.add("c b");
        product.add("c c");
        assertEquals(product, product(set1, set2));

        Set<String> result = new HashSet<>();
        result.add("1 1 1 1 2");
        result.add("11 1 1 2");
        result.add("1 11 1 2");
        result.add("1 1 11 2");
        result.add("11 11 2");
        result.add("1 111 2");
        result.add("111 1 2");
        result.add("1111 2");

        assertEquals(result, getAllSpells("11112"));
    }

    public Set<String> getAllSpells(String num) {
        Set<String> result = new HashSet<>();
        char previous = '_';
        int counter = 0;
        int start = 0;

        for (int j=0; j<num.length(); j++) {
            if (num.charAt(j) == previous) {
                counter++;
                if (counter == 0) {
                    start = j-1;
                }
            }
            else if (counter != 0) {
                String sequence = num.substring(start, j);
                Set<String> spells = getSpells(sequence, 1);
                String remaining = num.substring(j);
                Set<String> allSpells = getAllSpells(remaining);
                result.addAll(product(spells, allSpells));
            }
            previous = num.charAt(j);
        }
        if (result.isEmpty()) {
            result.add(num);
        }
        return result;
    }

    private Set<String> product(Set<String> pre, Set<String> post) {
        Set<String> result = new HashSet<>();
        Iterator<String> preIterator = pre.iterator();
        while (preIterator.hasNext()) {
            String prefix = preIterator.next();
            Iterator<String> postIterator = post.iterator();
            while (postIterator.hasNext()) {
                result.add(prefix + " " + postIterator.next());
            }
        }

        return result;
    }

    private Set<String> getSpells(String num, int index) {
        Set<String> spells = new HashSet<>();
        spells.add(num);
        for (int j=index; j<num.length(); j++) {
            spells.addAll(getSpells(insertSpaceAt(j, num), index+1));
        }
        return spells;
    }

    private String insertSpaceAt(int digit, String num) {

        int counter = 0;
        for (int j=0; j<num.length(); j++) {
            if (counter == digit) {
                if (num.charAt(j) == ' ') {
                    return num;
                }
                return num.substring(0, j) + " " + num.substring(j);
            }
            if (num.charAt(j) != ' ') {
                counter ++;
            }
        }
        return num;
    }

}
