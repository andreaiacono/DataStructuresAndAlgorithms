package pramp;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FlattenDictionary {

    @Test
    public void test() {

        Map<String, Object> result = flattenDictionary(new HashMap<>());
        assertEquals(0, result.size());

        Map<String, Object> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        Map<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("sub_one", 11);
        nestedMap.put("sub_two", 12);
        Map<String, Object> nestedNestedMap = new HashMap<>();
        nestedNestedMap.put("sub_sub_one", 111);
        nestedNestedMap.put("sub_sub_two", 112);
        map.put("nested", nestedMap);
        nestedMap.put("nested2", nestedNestedMap);

        result = flattenDictionary(map);
        assertEquals(6, result.size());
        assertEquals(1, result.get("one"));
        assertEquals(2, result.get("two"));
        assertEquals(11, result.get("nested.sub_one"));
        assertEquals(12, result.get("nested.sub_two"));
        assertEquals(111, result.get("nested.nested2.sub_sub_one"));
        assertEquals(112, result.get("nested.nested2.sub_sub_two"));


        map = new HashMap<>();
        nestedMap = new HashMap<>();
        nestedNestedMap = new HashMap<>();
        nestedNestedMap.put("sub_sub_one", 111);
        nestedMap.put("nested2", nestedNestedMap);
        map.put("nested", nestedMap);

        result = flattenDictionary(map);
        assertEquals(1, result.size());
        assertEquals(111, result.get("nested.nested2.sub_sub_one"));
    }

    Map<String,Object> flattenDictionary(Map<String,Object> dict) {

        Map<String, Object> map = new HashMap<>();

        for (String key: dict.keySet()) {
            Object obj = dict.get(key);
            if (obj instanceof Map) {
                Map<String, Object> subMap = flattenDictionary((Map<String, Object>) obj);
                for (String subKey: subMap.keySet()) {
                    map.put(key + "." + subKey, subMap.get(subKey));
                }
            }
            else {
                map.put(key, obj);
            }
        }

        return map;
    }

}
