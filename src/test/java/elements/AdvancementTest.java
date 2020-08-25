package elements;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdvancementTest {

    @Test
    public void advancement() {

        int[] vals = new int[] {
            2, 4, 1, 1, 0, 2, 3
        } ;
        assertTrue(Advancement.isCompletbable(vals));

        vals = new int[] {
            3, 3, 1, 0, 2, 0, 1
        } ;
        assertTrue(Advancement.isCompletbable(vals));

        vals = new int[] {
            3, 2, 0, 0, 2, 0, 1
        } ;
        assertFalse(Advancement.isCompletbable(vals));

    }

}