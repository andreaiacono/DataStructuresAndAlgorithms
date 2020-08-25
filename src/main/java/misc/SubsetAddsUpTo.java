package misc;

public class SubsetAddsUpTo {

    public static void main(String[] args) {

        int[] values = new int[] { 2, 4, 6, 10 };
        int wanted = 16;

        System.out.println("number of solutions: " + subsetsCount(0, 0, values, wanted));

        values = new int[] { 7, 3, 2, 5, 8 };
        wanted = 14;

        System.out.println("number of solutions: " + subsetsCount(0, 0, values, wanted));

        values = new int[] { 3, 34, 4, 12, 5, 2 };
        wanted = 9;

        System.out.println("number of solutions: " + subsetsCount(0, 0, values, wanted));
    }

    private static int subsetsCount(int current, int index, int[] values, int wanted) {
//        System.out.println("called with current=" + current + ", index=" + index);
        if (current == wanted) {
            System.out.println("found");
            return 1;
        }
        if (current > wanted || index >= values.length) {
            return 0;
        }

        return subsetsCount(current, index + 1, values, wanted) +
                subsetsCount(current + values[index], index + 1, values, wanted);
    }


}
