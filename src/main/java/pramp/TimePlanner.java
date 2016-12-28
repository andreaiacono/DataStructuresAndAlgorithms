package pramp;

public class TimePlanner {

  /*
    dur = 2
    P1 : [ [1,3], [4,8] ]  index1
    P2 : [ [1,2], [2, 4], [4, 6] ] index2
  */

    int[] planner(int[][] timesA, int[][] timesB, int dur) {

        int index1 = 0;
        int index2 = 0;

        while (index1 < timesA.length && index2 < timesB.length) {

            //
            if (Math.max(timesA[index1][0], timesB[index2][0]) - Math.min(timesA[index1][1], timesB[index2][1]) >= dur ) {
                int start = Math.max(timesA[index1][0], timesB[index2][0]);
                return new int[] {start, start + dur };
            }
            // cehck array out of bounds
            if (index1+1 < timesA.length && index2+1 < timesB.length && timesA[index1+1][0] < timesB[index2+1][0]) {
                index1 ++;
            }
            else {
                index2 ++;
            }
        }

        return null;
    }
}
