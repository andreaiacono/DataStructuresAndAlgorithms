package DailyCodingProblem;

public class CheckDataStructure {
    public static void main(String[]args){

        Check check = new Check();
        assert check.check(10) == false;
        check.add(10);
        assert check.check(10) == true;
        assert check.check(11) == false;
        check.add(11);
        assert check.check(11) == true;
    }
}

class Check {

    final int SIZE = 1000;
    private final boolean[] values = new boolean[SIZE];

    void add(int value) {
        int hash = Integer.valueOf(value).hashCode();
        values[hash % SIZE] = true;
    }

    boolean check(int value) {
        int hash = Integer.valueOf(value).hashCode();
        return values[hash % SIZE];
    }

}
