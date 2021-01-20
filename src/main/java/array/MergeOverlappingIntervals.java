package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MergeOverlappingIntervals {

    /**
     * You are given an array (list) of interval pairs as input where each interval has a start and end timestamp.
     * The input array is sorted by starting timestamps. You are required to merge overlapping intervals and
     * return a new output array.
     */

    @Test
    public void test() {

        List<Interval> intervals = List.of(
                new Interval(1, 5),
                new Interval(3, 7),
                new Interval(4, 6),
                new Interval(6, 8)
        );
        List<Interval> expected = List.of(
                new Interval(1, 8)
        );
        assertEquals(expected, mergeIntervals(intervals));

        intervals = List.of(
                new Interval(1, 5),
                new Interval(3, 7),
                new Interval(4, 6),
                new Interval(6, 8),
                new Interval(9, 10),
                new Interval(12, 20)
        );
        expected = List.of(
                new Interval(1, 8),
                new Interval(9, 10),
                new Interval(12, 20)
        );
        assertEquals(expected, mergeIntervals(intervals));

        intervals = List.of(
                new Interval(1, 3),
                new Interval(3, 7),
                new Interval(9, 10)
        );
        expected = List.of(
                new Interval(1, 7),
                new Interval(9, 10)
        );
        assertEquals(expected, mergeIntervals(intervals));

        intervals = List.of(
                new Interval(1, 3),
                new Interval(5, 7),
                new Interval(9, 10)
        );
        expected = List.of(
                new Interval(1, 3),
                new Interval(5, 7),
                new Interval(9, 10)
        );
        assertEquals(expected, mergeIntervals(intervals));
    }

    private List<Interval> mergeIntervals(List<Interval> intervals) {

        // basic checks

        List<Interval> result = new ArrayList<>();
        int currentStart = intervals.get(0).start;
        int currentEnd = intervals.get(0).end;

        for (Interval current: intervals) {
            if (current.start <= currentEnd) {
                currentEnd = Math.max(currentEnd, current.end);
            }
            else {
                result.add(new Interval(currentStart, currentEnd));
                currentStart = current.start;
                currentEnd = current.end;
            }
        }
        result.add(new Interval(currentStart, currentEnd));

        return result;

    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Interval interval = (Interval) o;

            if (start != interval.start) return false;
            return end == interval.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }
    }
}
