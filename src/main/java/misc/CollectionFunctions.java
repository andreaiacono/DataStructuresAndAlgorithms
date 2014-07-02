package misc;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: andrea
 * Date: 28/06/14
 * Time: 18.33
 */
public class CollectionFunctions {

    public static void main(String[] args) {

        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("pippo");
        list.add("foo");
        list.add("3.1");
        list.add("bar");
        list.add("5");
        removeNumbers(list);
    }

    public static void removeNumbers(List<String> list) {

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {

            String item = iterator.next();
            try {
                Long.parseLong(item);
                iterator.remove();
            }
            catch (NumberFormatException nfe) {

            }
        }
    }

    public static <E> Set<E> insersection(Set<E> first, Set<E> second) {

        Set<E> result = new HashSet<>();

        Iterator<E> firstIterator = first.iterator();
        while (firstIterator.hasNext()) {
            E item = firstIterator.next();
            if (second.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}
