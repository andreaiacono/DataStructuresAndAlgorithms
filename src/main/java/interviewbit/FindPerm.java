package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FindPerm {

    @Test
    public void test() {
        List<Integer> result = new ArrayList<>();
        result.add(2);
        result.add(3);
        result.add(1);

        assertEquals(result, findPerm("ID", 3));

        result = new ArrayList<>();
        result.add(2);
        result.add(1);
        result.add(3);

        assertEquals(result, findPerm("DI", 3));

        result = new ArrayList<>();
        result.add(3);
        result.add(4);
        result.add(2);
        result.add(5);
        result.add(1);
        result.add(6);

        assertEquals(result, findPerm("IDIDI", 3));

        result = new ArrayList<>();
        for (int j=354; j>0; j--) {
            result.add(j);
        }

        assertEquals(result, findPerm("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD", 354));

        assertEquals(result, findPerm("DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDID", 818));
    }

    public ArrayList<Integer> findPerm(final String A, int B) {

        ArrayList<Integer> result = new ArrayList<>();
Math.pow(2,2);
        if (A.indexOf('I') < 0) {
            for (int j=B; j>0; j--) {
                result.add(j);
            }
            return result;
        }

        if (A.indexOf('D') < 0) {
            for (int j=1; j<=B; j++) {
                result.add(j);
            }
            return result;
        }

        int d = 1;
        for (int j=0; j<A.length(); j++) {
            if (A.charAt(j) == 'D') {
                d++;
            }
        }

        int indexD = d;
        int indexI = d+1;


        result.add(indexD);

        for (int j=0; j<A.length(); j++) {
            if (A.charAt(j) == 'D') {
                indexD --;
                result.add(indexD);
            }
            else {
                result.add(indexI);
                indexI ++;
            }
        }

        return result;

    }
}
