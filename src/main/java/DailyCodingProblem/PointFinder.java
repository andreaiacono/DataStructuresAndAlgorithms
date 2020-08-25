package DailyCodingProblem;

import util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.awt.*;

public class PointFinder {

    /**
     * Given a set of points (x, y) on a 2D cartesian plane, find the two closest points.
     * For example, given the points [(1, 1), new Point(-1, -1), new Point(3, 4), new Point(6, 1), new Point(-1, -6), new Point(-4, -3)],
     * return [(-1, -1), new Point(1, 1)].
     */

    public static void main(String[] args) {
        PointFinder pf = new PointFinder();
        var points = List.of(new Point(1, 1), new Point(-1, -1), new Point(3, 4), new Point(6, 1), new Point(-1, -6), new Point(-4, -3));
        var closest = pf.getClosest(points);
        System.out.println(closest);
    }

//    Comparator<Point> categoryNameComparator = Comparator.comparing((Point arg) -> getDistance(arg);
//
//    Comparator<Point> comparator = new Comparator<Point>() {
//        @Override
//        public int compare(Point o1, Point o2) {
//            return  Comparator.comparingDouble(getDistance(o1));
//        }
//    }
    List<Point> getClosest(List<Point> points) {
//        Arrays.stream(points.toArray()).sort();
        Pair<Point, Point> minPair = new Pair(new Point(Integer.MAX_VALUE, Integer.MAX_VALUE), new Point(Integer.MIN_VALUE, Integer.MIN_VALUE));
        double minDistance = Integer.MAX_VALUE;
        for (int i=0; i<points.size(); i++) {
            Point p1 = points.get(i);
            for (int j=i+1; j<points.size(); j++) {
                Point p2 = points.get(j);
                double distance = getDistance(p1, p2);
                if (distance < minDistance) {
                    minDistance = distance;
                    minPair = new Pair(p1, p2);
                }
            }
        }

        return List.of(minPair.first, minPair.second);
    }

    private double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }
}
