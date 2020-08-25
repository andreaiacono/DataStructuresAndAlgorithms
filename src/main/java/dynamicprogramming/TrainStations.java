package dynamicprogramming;

// Dynamic programming for coding interviews
// Example 4.2
public class TrainStations {

    public static void main(String[] args) {
        int[][] cost = new int[][] { {0, 10, 75, 94, 105}, {-1, 0, 35, 50, 130}, {-1, -1, 0, 80, 15}, {-1, -1, -1, 0, 20},  {-1, -1, -1, -1, 0} };
        System.out.println("Minimum cost: " + findMinimumCost(cost, 0, 0 ) + " - counter=" + counter);
    }
    static int counter = 0;
    static int findMinimumCost(int[][] cost, int current, int partial) {
        counter ++;
        if (current == cost.length-1) {
            return partial;
        }
        int min = Integer.MAX_VALUE;
        for (int i=current+1; i<cost.length; i++) {
            System.out.println("current = " + current +  " - computing "+cost[current][i] + "+" +  partial);
            min = Math.min(min, findMinimumCost(cost, i, cost[current][i] + partial));
        }
        return min;
    }
}
