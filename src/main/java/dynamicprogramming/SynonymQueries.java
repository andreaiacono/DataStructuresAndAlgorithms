package dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

// https://medium.com/@alexgolec/google-interview-problems-synonymous-queries-36425145387c
public class SynonymQueries {

    static Map<String, String> synonyms = new HashMap<>() {{
        put("rate", "ratings");
        put("approval", "popularity");
        put("ratings", "rate");
        put("popularity", "approval");
    }};
    
    class Queries {
        String first;
        String second;

        public Queries(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
    
    @Test
    public void test() {
        Queries queries = new Queries("obama approval rate", "popularity ratings obama");
        assertTrue(isSynonym(queries.first, queries.second));
    }

    public boolean isSynonym(String s1, String s2) {
        List<String> terms1 = tokenize(s1);
        List<String> terms2 = tokenize(s2);

        for (int i=0; i<terms1.size(); i++) {
            String t1 = terms1.get(i);
            if (!terms2.contains(t1)) {
                boolean found = false;
                for (int j = 0; j < terms2.size(); j++) {
                    String t2 = terms2.get(j);
                    if (t2.equals(synonyms.get(t1))) {
                        found = true;
                    }
                }
                if (!found) {
                    return false;
                }
            }
        }

        return true;
    }

    public List<String> tokenize(String s) {
        return Arrays.asList(s.split((" ")));
    }
}
