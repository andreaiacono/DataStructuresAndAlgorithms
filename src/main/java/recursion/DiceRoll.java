package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {

    @Test
    public void test() {
        diceRoll(3, 6, "").stream().forEach(s -> System.out.println(s));
    }

    List<String> diceRoll(int dices, int faces, String tmp) {

        if (dices == 0) {
            return List.of(tmp.substring(1));
        }

        List<String> result = new ArrayList<>();
        for (int i=1; i<=faces; i++) {
            result.addAll(diceRoll(dices-1, faces, tmp +  " " + i));
        }

        return result;
    }

    //  1 1 1
    //  1 1 2
    // ...
    // 1 1 6
    // 1 2 1
}
