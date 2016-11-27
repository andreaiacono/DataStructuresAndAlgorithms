package misc;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ViewingAngle {

    @Test
    public void test() {

        int[] x = new int[]{5, -11, 27, 12, 4, 1, -21};
        int[] y = new int[]{2, 21, -10, 28, 12, 7, -10};

        assertEquals(4d, getMaxDirection(x, y, 51), 0.0001);
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() { return x + "," + y; }
    }

    double getMaxDirection(int[] x, int[] y, int viewingAngle) {

        assert x.length == y.length;

        List<Point> points = getPointsFromCoords(x, y);
        List<Double> angles = getAnglesFromPoints(points);

        Collections.sort(angles);

        int maxPoints = 0;
        int firstPoint = 0;
        int lastPoint = 0;

        while (true) {
            while (lastPoint < angles.size() && angles.get(lastPoint) - angles.get(firstPoint) < viewingAngle) {
                lastPoint++;
            }

            if (lastPoint-firstPoint > maxPoints) {
                maxPoints = lastPoint-firstPoint;
            }

            if (lastPoint == angles.size()-1) {
                break;
            }
            firstPoint++;
        }

        return maxPoints;
    }

    private List<Double> getAnglesFromPoints(List<Point> points) {

        List<Double> angles = new ArrayList<>(points.size());
        for (Point point: points) {
            if (point.x == 0) {
                angles.add(90d);
            }
            else {
                angles.add(Math.toDegrees(Math.atan(point.y / (double) point.x)));
            }
        }

        return angles;
    }

    private List<Point> getPointsFromCoords(int[] x, int[] y) {
        List<Point> points = new ArrayList<>(x.length);
        for (int j = 0; j < x.length; j++) {
            points.add(new Point(x[j], y[j]));
        }

        return points;
    }
}
