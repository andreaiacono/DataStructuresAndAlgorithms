package elements;

public class Advancement {

    public static boolean isCompletbable(int[] vals) {

        int furthest = 0;

        for (int i=0; i<vals.length; i++) {

            if (furthest < i) {
                return false;
            }
            furthest = Math.max(furthest, i + vals[i]);
        }

        return true;
    }
}
