package pramp;

import java.util.HashSet;
import java.util.Set;

public class HTree {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Set<Point> drawH(int x, int y, int length) {

        int left = x - length / 2;
        int right = x + length / 2;
        int top = y - length / 2;
        int bottom = y + length / 2;

        if (left < 0 || top < 0) {
            System.out.println("Drawn out of borders.");
        }

//        drawLine(left, y, right, y);
//        drawLine(left, top, left, bottom);
//        drawLine(right, top, right, bottom);

        Set<Point> corners = new HashSet<>();
        corners.add(new Point(left, top));
        corners.add(new Point(left, bottom));
        corners.add(new Point(right, top));
        corners.add(new Point(right, bottom));

        return corners;
    }

    void htree(int x, int y, int starting_length, int depth) {

        Set<Point> corners = new HashSet<>();
        corners.add(new Point(x, y));
        int step = 0;
        int length = starting_length;
        while (step < depth) {
            Set<Point> newCorners = new HashSet<>();
            for (Point point : corners) {
                newCorners.addAll(drawH(point.x, point.y, length));
            }
            corners = newCorners;
            length /= 2;
            step++;
        }
    }
}
