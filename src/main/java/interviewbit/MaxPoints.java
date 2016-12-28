package interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 */
public class MaxPoints {

    @Test
    public void test() {

        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(-2, -9, 4, -7, 5, 10, 1));
        ArrayList<Integer> y = new ArrayList<>(Arrays.asList(-17, -19, -12, -15, -3, 11, 4));
        assertEquals(2, maxPoints(x, y));

        x = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        y = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        assertEquals(5, maxPoints(x, y));

        x = new ArrayList<>(Arrays.asList(0, 1, -1));
        y = new ArrayList<>(Arrays.asList(0, 1, -1));
        assertEquals(3, maxPoints(x, y));

        x = new ArrayList<>(Arrays.asList(4, 8, -4));
        y = new ArrayList<>(Arrays.asList(-4, -4, -4));
        assertEquals(3, maxPoints(x, y));

        x = new ArrayList<>(Arrays.asList(-4, 0, 19));
        y = new ArrayList<>(Arrays.asList(-2, 7, -11));
        assertEquals(2, maxPoints(x, y));

        x = new ArrayList<>(Arrays.asList(-6, 5, -18, 2, 5, -2));
        y = new ArrayList<>(Arrays.asList(-17, -16, -17, -4, -13, 20));
        assertEquals(2, maxPoints(x, y));

        x = new ArrayList<>(Arrays.asList(18, 15, -10, 15, -11, 4, 13, -7, 5, -4, 3, -12, 20, -18, 19, -4, -13, -11, 10, 1, -8));
        y = new ArrayList<>(Arrays.asList(-3, 14, -9, 18, 14, 17, -18, 1, -18, -18, 18, 3, -16, 12, -2, -15, -2, 20, -14, 19, 10));
        assertEquals(4, maxPoints(x, y));
    }

    int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {

        int n = x.size();

        if (n < 3) {
            return n;
        }

        Map<Double, Integer> slopes = new HashMap<>();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int p1x = x.get(i);
            int p1y = y.get(i);
            slopes.clear();
            for (int j = 0; j < n; j++) {

                if (j == i) {
                    continue;
                }

                int p2x = x.get(j);
                int p2y = y.get(j);

                Double slope = p2x == p1x ? Double.POSITIVE_INFINITY : (p2y - p1y) / (double) (p2x - p1x);
                int val = 1;
                if (slopes.containsKey(slope)) {
                    val += slopes.get(slope);
                }
                slopes.put(slope, val);
            }

            for (Map.Entry<Double, Integer> entry : slopes.entrySet()) {
                int val = entry.getValue();
                max = Math.max(max, val);
            }
        }
        return max+1;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Point)) {
                return false;
            }
            Point other = (Point) o;
            return other.x == x && other.y == y;
        }

        public int hashCode() {
            return 31 * x + y;
        }

        public boolean liesOn(Line line) {
            if (line.slopeDen == 0) {
                return line.couple.p1.x == x;
            }
            return x * (line.slopeNum / line.slopeDen) + line.intercept == y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    class Couple {
        Point p1;
        Point p2;

        public Couple(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Couple)) {
                return false;
            }
            Couple other = (Couple) o;
            return other.p1.equals(p1) && other.p2.equals(p2);
        }

        public int hashCode() {
            return p1.hashCode() + p2.hashCode();
        }

        @Override
        public String toString() {
            return "{" + p1 + "/" + p2 + "}";
        }
    }

    class Line {
        int slopeNum;
        int slopeDen;
        int intercept;
        Couple couple;

        public Line(Couple couple) {

            this.couple = couple;
            int tmpSlopeNum = couple.p2.y - couple.p1.y;
            int tmpSlopeDen = couple.p2.x - couple.p1.x;

            int gcd = gcd(tmpSlopeNum, tmpSlopeDen);

            slopeNum = tmpSlopeNum / (gcd != 0 ? gcd : 1);
            slopeDen = tmpSlopeDen / (gcd != 0 ? gcd : 1);

            this.intercept = couple.p1.y - (int) (((slopeNum / (float) slopeDen)) * couple.p1.x);
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof Line)) {
                return false;
            }
            Line other = (Line) o;
            return other.slopeNum == slopeNum && other.slopeDen == slopeDen && other.intercept == intercept;
        }

        public int hashCode() {
            return 31 * slopeNum + slopeDen * 17 + intercept;
        }

        @Override
        public String toString() {
            return "y = " + slopeNum + "/" + slopeDen + (intercept != 0 ? (intercept < 0 ? "" : "+") + intercept : "") + "  " + couple;
        }
    }

    public int maxPointsOld(ArrayList<Integer> a, ArrayList<Integer> b) {

        if (a.size() == 0 || a.size() != b.size()) {
            return 0;
        }

        if (a.size() == 1) {
            return 1;
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            points.add(new Point(a.get(i), b.get(i)));
        }

        Set<Couple> couples = new HashSet<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                couples.add(new Couple(points.get(i), points.get(j)));
            }
        }

        Set<Line> lines = new HashSet<>();
        for (Couple couple : couples) {
            lines.add(new Line(couple));
        }

        int max = 2;
        for (Line line : lines) {
            int pointsOnLine = 0;
            for (Point point : points) {
                if (point.liesOn(line)) {
                    pointsOnLine++;
                }
            }

            if (pointsOnLine > max) {
                max = pointsOnLine;
            }
        }
        return max;
    }

    int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

}
