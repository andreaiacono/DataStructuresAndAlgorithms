package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeOverlapping {

    @Test
    public void test() {
        ArrayList<Interval> input = new ArrayList<Interval>() {{
            add(new Interval(1, 10));
            add(new Interval(2, 9));
            add(new Interval(3, 8));
            add(new Interval(4, 7));
            add(new Interval(5, 6));
            add(new Interval(6, 6));
        }};
        List<Interval> output = new ArrayList<Interval>() {{
            add(new Interval(1, 10));
        }};

        System.out.println("Solution: " + merge(input) + " for " + input);

        input = new ArrayList<Interval>() {{
            add(new Interval(1, 10));
            add(new Interval(4, 100));
            add(new Interval(48, 94));
            add(new Interval(16, 21));
            add(new Interval(58, 71));
            add(new Interval(36, 53));
            add(new Interval(49, 68));
            add(new Interval(18, 42));
            add(new Interval(37, 90));
            add(new Interval(68, 75));
            add(new Interval(6, 57));
            add(new Interval(25, 78));
            add(new Interval(58, 79));
            add(new Interval(18, 29));
            add(new Interval(69, 94));
            add(new Interval(5, 31));
            add(new Interval(10, 87));
            add(new Interval(21, 35));
            add(new Interval(1, 32));
            add(new Interval(7, 24));
            add(new Interval(17, 85));
            add(new Interval(30, 95));
            add(new Interval(5, 63));
            add(new Interval(1, 17));
            add(new Interval(67, 100));
            add(new Interval(53, 55));
            add(new Interval(30, 63));
            add(new Interval(7, 76));
            add(new Interval(33, 51));
            add(new Interval(62, 68));
            add(new Interval(78, 83));
            add(new Interval(12, 24));
            add(new Interval(31, 73));
            add(new Interval(64, 74));
            add(new Interval(33, 40));
            add(new Interval(51, 63));
            add(new Interval(17, 31));
            add(new Interval(14, 29));
            add(new Interval(9, 15));
            add(new Interval(39, 70));
            add(new Interval(13, 67));
            add(new Interval(27, 100));
            add(new Interval(10, 71));
            add(new Interval(18, 47));
            add(new Interval(48, 79));
            add(new Interval(70, 73));
            add(new Interval(44, 59));
            add(new Interval(68, 78));
            add(new Interval(24, 67));
            add(new Interval(32, 70));
            add(new Interval(29, 94));
            add(new Interval(45, 90));
            add(new Interval(10, 76));
            add(new Interval(12, 28));
            add(new Interval(31, 78));
            add(new Interval(9, 44));
            add(new Interval(29, 83));
            add(new Interval(21, 35));
            add(new Interval(46, 93));
            add(new Interval(66, 83));
            add(new Interval(21, 72));
            add(new Interval(29, 37));
            add(new Interval(6, 11));
            add(new Interval(56, 87));
            add(new Interval(10, 26));
            add(new Interval(11, 12));
            add(new Interval(15, 88));
            add(new Interval(3, 13));
            add(new Interval(56, 70));
            add(new Interval(40, 73));
            add(new Interval(25, 62));
            add(new Interval(63, 73));
            add(new Interval(47, 74));
            add(new Interval(8, 36));
        }};

        System.out.println("Solution: " + merge(input) + " for " + input);

        input = new ArrayList<Interval>() {{
            add(new Interval(47, 76));
            add(new Interval(51, 99));
            add(new Interval(28, 78));
            add(new Interval(54, 94));
            add(new Interval(12, 72));
            add(new Interval(31, 72));
            add(new Interval(12, 55));
            add(new Interval(24, 40));
            add(new Interval(59, 79));
            add(new Interval(41, 100));
            add(new Interval(46, 99));
            add(new Interval(5, 27));
            add(new Interval(13, 23));
            add(new Interval(9, 69));
            add(new Interval(39, 75));
            add(new Interval(51, 53));
            add(new Interval(81, 98));
            add(new Interval(14, 14));
            add(new Interval(27, 89));
            add(new Interval(73, 78));
            add(new Interval(28, 35));
            add(new Interval(19, 30));
            add(new Interval(39, 87));
            add(new Interval(60, 94));
            add(new Interval(71, 90));
            add(new Interval(9, 44));
            add(new Interval(56, 79));
            add(new Interval(58, 70));
            add(new Interval(25, 76));
            add(new Interval(18, 46));
            add(new Interval(14, 96));
            add(new Interval(43, 95));
            add(new Interval(70, 77));
            add(new Interval(13, 59));
            add(new Interval(52, 91));
            add(new Interval(47, 56));
            add(new Interval(63, 67));
            add(new Interval(28, 39));
            add(new Interval(51, 92));
            add(new Interval(30, 66));
            add(new Interval(4, 4));
            add(new Interval(29, 92));
            add(new Interval(58, 90));
            add(new Interval(6, 20));
            add(new Interval(31, 93));
            add(new Interval(52, 75));
            add(new Interval(41, 41));
            add(new Interval(64, 89));
            add(new Interval(64, 66));
            add(new Interval(24, 90));
            add(new Interval(25, 46));
            add(new Interval(39, 49));
            add(new Interval(15, 99));
            add(new Interval(50, 99));
            add(new Interval(9, 34));
            add(new Interval(58, 96));
            add(new Interval(85, 86));
            add(new Interval(13, 68));
            add(new Interval(45, 57));
            add(new Interval(55, 56));
            add(new Interval(60, 74));
            add(new Interval(89, 98));
            add(new Interval(23, 79));
            add(new Interval(16, 59));
            add(new Interval(56, 57));
            add(new Interval(54, 85));
            add(new Interval(16, 29));
            add(new Interval(72, 86));
            add(new Interval(10, 45));
            add(new Interval(6, 25));
            add(new Interval(19, 55));
            add(new Interval(21, 21));
            add(new Interval(17, 83));
            add(new Interval(49, 86));
            add(new Interval(67, 84));
            add(new Interval(8, 48));
            add(new Interval(63, 85));
            add(new Interval(5, 31));
            add(new Interval(43, 48));
            add(new Interval(57, 62));
            add(new Interval(22, 68));
            add(new Interval(48, 92));
            add(new Interval(36, 77));
            add(new Interval(27, 63));
            add(new Interval(39, 83));
            add(new Interval(38, 54));
            add(new Interval(31, 69));
            add(new Interval(36, 65));
            add(new Interval(52, 68));
        }};

        System.out.println("Solution: " + merge(input) + " for " + input);


        input = new ArrayList<Interval>() {{
            add(new Interval(5, 28));
            add(new Interval(7, 70));
            add(new Interval(54, 93));
            add(new Interval(5, 98));
            add(new Interval(46, 70));
            add(new Interval(42, 63));
            add(new Interval(5, 91));
            add(new Interval(30, 49));
            add(new Interval(36, 57));
            add(new Interval(31, 95));
            add(new Interval(86, 88));
            add(new Interval(9, 90));
            add(new Interval(5, 53));
            add(new Interval(42, 62));
            add(new Interval(14, 100));
            add(new Interval(59, 75));
            add(new Interval(32, 100));
            add(new Interval(5, 79));
            add(new Interval(31, 31));
            add(new Interval(7, 42));
            add(new Interval(13, 47));
            add(new Interval(44, 87));
            add(new Interval(61, 83));
            add(new Interval(100, 100));
            add(new Interval(96, 98));
            add(new Interval(47, 51));
            add(new Interval(34, 44));
            add(new Interval(6, 53));
            add(new Interval(30, 92));
            add(new Interval(50, 64));
            add(new Interval(37, 57));
            add(new Interval(49, 67));
            add(new Interval(2, 67));
            add(new Interval(36, 50));
            add(new Interval(55, 100));
            add(new Interval(54, 78));
            add(new Interval(58, 70));
            add(new Interval(2, 37));
            add(new Interval(13, 54));
            add(new Interval(7, 60));
            add(new Interval(16, 79));
            add(new Interval(35, 78));
            add(new Interval(17, 57));
            add(new Interval(16, 84));
            add(new Interval(60, 80));
            add(new Interval(10, 54));
            add(new Interval(54, 59));
            add(new Interval(62, 85));
            add(new Interval(7, 37));
            add(new Interval(31, 99));
            add(new Interval(40, 41));
            add(new Interval(4, 99));
            add(new Interval(28, 45));
            add(new Interval(27, 71));
            add(new Interval(14, 64));
        }};
        System.out.println("Solution: " + merge(input) + " for " + input);

        input = new ArrayList<Interval>() {{
                add(new Interval(92, 98));
                add(new Interval(10, 86));
                add(new Interval(61, 91));
                add(new Interval(8, 71));
                add(new Interval(53, 65));
                add(new Interval(19, 79));
                add(new Interval(20, 50));
            }
        };
        System.out.println("Solution: " + merge(input) + " for " + input);

    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() { return start + "," + end; }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        ArrayList<Interval> result = new ArrayList<>();
        int last = 0;
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= result.get(last).end) {
                if (result.get(last).end < intervals.get(i).end) {
                    result.set(last, new Interval(intervals.get(last).start, intervals.get(i).end));
                }
                continue;
            }
            last = i;
            result.add(intervals.get(last));
        }

        return result;
    }
}
