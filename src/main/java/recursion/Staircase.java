package recursion;

public class Staircase {

    /**
     * A person wants to climb a staircase of N steps. On each step, there are two climbing choices; either
     * take 1 step or 2 steps. Find out the total number of ways to climb the staircase. What would the
     * programming concept(s) be required to implement a solution to the problem for finding out the various ways
     * in which the staircase can be climbed?
     */


    int climbWays(int n) {
        if (n <= 1) {
            return 1;
        }

        return climbWays(n-1) + climbWays(n-2);
    }

}
