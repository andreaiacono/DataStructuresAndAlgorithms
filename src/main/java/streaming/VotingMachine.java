package streaming;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class VotingMachine {

    /**
     * On election day, a voting machine writes data in the form (voter_id, candidate_id) to a text file. Write a
     * program that reads this file as a stream and returns the top 3 candidates at any given time. If you find a
     * voter voting more than once, report this as fraud.
     */

    @Test
    public void test() {
        assertTrue(Arrays.equals(getTop3(), new String[]  {"0", "0", "0"} ));
        assertTrue(addAndCheckVote("1", "10"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "0", "0" }));
        
        assertTrue(addAndCheckVote("2", "10"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "0", "0" }));

        assertFalse(addAndCheckVote("2", "10"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "0", "0" }));
        
        assertTrue(addAndCheckVote("3", "20"));
        System.out.println(Arrays.toString(getTop3()));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "20", "0" }));
        
        assertTrue(addAndCheckVote("4", "20"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "20", "10", "0" }));
        
        assertTrue(addAndCheckVote("5", "20"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "20", "10", "0" }));

        assertTrue(addAndCheckVote("6", "10"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "20", "0" }));
        
        assertFalse(addAndCheckVote("6", "30"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "20", "0" }));

        assertTrue(addAndCheckVote("7", "30"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "20", "30" }));

        assertTrue(addAndCheckVote("8", "40"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "20", "40" }));
        
        assertTrue(addAndCheckVote("9", "40"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "20", "40" }));
        
        assertTrue(addAndCheckVote("10", "40"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "40", "10", "20" }));
        
        assertTrue(addAndCheckVote("11", "10"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "10", "40", "20" }));

        assertTrue(addAndCheckVote("12", "20"));
        assertTrue(Arrays.equals(getTop3(), new String[] { "20", "10", "40" }));
    }

    HashSet<String> voters = new HashSet<>();
    Map<String, Integer> votes = new HashMap<>() {{
        put("0", -1);
    }};
    String[] top = new String[] {"0", "0", "0"};

    boolean addAndCheckVote(String voterId, String candidateId) {
        if (voters.contains(voterId)) {
            return false;
        }
        voters.add(voterId);

        int newVotes = 1;
        if (votes.containsKey(candidateId)) {
            newVotes = votes.get(candidateId) + 1;
        }
        votes.put(candidateId, newVotes);

        if (newVotes >= votes.get(top[0])) {
            // the top one receives one vote more
            if (top[0].equals(candidateId)) {
                return true;
            }
            // the second one receives a vote for a tie
            else if (top[1].equals(candidateId)) {
                top[1] = top[0];
                top[0] = candidateId;
            }
            else {
                top[2] = top[1];
                top[1] = top[0];
                top[0] = candidateId;
            }
        }
        else if (newVotes >= votes.get(top[1])) {
            if (top[1].equals(candidateId)) {
                return true;
            }
            else {
                top[1] = top[0];
                top[0] = candidateId;
            }
        }
        else if (newVotes >= votes.get(top[2])) {
            top[2] = candidateId;
        }

        return true;
    }

    String[] getTop3() {
        return top;
    }


}
