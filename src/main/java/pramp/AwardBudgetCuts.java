package pramp;

public class AwardBudgetCuts {


    //  maximum cap c only one c possible
    int findCap(int[] g, int budget) {

        int prevSum = 0;
        int n = g.length;
        int c = 0;
        for (int i=0; i<n; i++) {
            c = (budget-prevSum) / (n - i);
            if (i > 0 && c < g[i-1]) {//
                continue;
            }
            if (prevSum + (n-i) * c == budget) {
                return c;
            }
            prevSum += g[i];
        }

        return c;
    }


/*
sum_prev, b, i
c = (b - sum_prev) / (n - i)// is c a vlid cap

   if (prev_sum + c * (n-i) == b)

      i, ... n - 1

      leave 0, ,,  i - 1
         c >= g[i - 1]

*/



}
