package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainingHashTableTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPut() throws Exception {

        ChainingHashTable<Integer, String> table = new ChainingHashTable(10);
        Assert.assertNull(table.get(10));
        table.put(10, "ten");
        Assert.assertEquals("ten", table.get(10));

        table.put(10, "ten2");
        Assert.assertEquals("ten2", table.get(10));

    }
}