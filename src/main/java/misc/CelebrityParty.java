package misc;

import org.junit.Test;

import java.util.List;
import java.util.Random;

public class CelebrityParty {

//    At a party, there is a single person who everyone knows, but who does not know anyone in return (the "celebrity").
//    To help figure out who this is, you have access to an O(1) method called knows(a, b), which returns True
//    if person a knows person b, else False.
//    Given a list of N people and the above operation, find a way to identify the celebrity in O(N) time.

    // returns the index of the celebrity
    int getCelebrity(int[] people) {

        // assumes at least 2 people
        for (int i = 1; i < people.length; i++) {
            if (knows(0, i)) {
                return i;
            }
        }

        return knows(1,0) ? 0 : -1;
    }

    boolean knows(int a, int b) {
        return new Random().nextBoolean();
    }
}
