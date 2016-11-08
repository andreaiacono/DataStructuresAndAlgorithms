package datastructures;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HashMapTest {

    @Test
    public void testInsert() {
        HashMap<String> map = new HashMap<>();
        map.insert("pippo");
        assertTrue(map.search("pippo").equals("pippo"));
    }

    @Test
    public void testRemove() {
        HashMap<String> map = new HashMap<>();
        map.insert("pippo");
        assertTrue(map.remove("pippo"));
        assertNull(map.search("pippo"));
    }



}