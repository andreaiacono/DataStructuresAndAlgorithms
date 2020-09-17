package misc;

import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapUtils {

    @Test
    public void test() {

        Map<String, Integer> map = new HashMap<>() {{
           put("A", 5);
           put("H", 10);
           put("D", 1);
           put("F", 12);
           put("T", 7);
           put("K", 5);
        }};

        System.out.println(map);
        System.out.println(sortByValue(map));
    }

    static Map<String, Integer> sortByValue(Map<String, Integer> map) {
        Map<String, Integer> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return result;
    }
}
