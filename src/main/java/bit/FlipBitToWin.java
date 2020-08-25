package bit;

import java.util.ArrayList;
import java.util.List;

public class FlipBitToWin {

    int longestSub(List<Integer> values) {

        List<List<Integer>> subs = allSubs(values, 0, new ArrayList<>());
        int max = 0;
        for (List<Integer> subset: subs) {
            max = Math.max(max, subset.size());
        }

        return max;
    }


    List<List<Integer>> allSubs(List<Integer> values, int index, List<Integer> partial) {
        // base case
        if (index == values.size()) {
            return List.of(partial);
        }

        // recursive case
        return new ArrayList<>() {{
            addAll(allSubs(values, index+1, partial));
            addAll(allSubs(values, index+1, new ArrayList<>(partial) {{ add(values.get(index)); }}));
        }};
    }


}
