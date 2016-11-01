package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by andrea on 27/09/16.
 */
public class StackOfBoxes {

    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        boxes.add(new Box(1,2,3));
        boxes.add(new Box(2,2,1));
        boxes.add(new Box(4,2,2));
        boxes.add(new Box(1,5,1));
        boxes.add(new Box(3,3,4));
        boxes.add(new Box(4,5,6));
        boxes.add(new Box(2,2,3));

        Comparator<Box> widthComparator = (i1, i2) -> -Integer.compare(i1.w, i2.w);
        Comparator<Box> heightComparator = (i1, i2) -> -Integer.compare(i1.h, i2.h);
        Comparator<Box> depthComparator = (i1, i2) -> -Integer.compare(i1.d, i2.d);

        Collections.sort(boxes, widthComparator);
        int val = findMax(boxes);
        Collections.sort(boxes, heightComparator);
        val = Math.max(val, findMax(boxes));
        Collections.sort(boxes, depthComparator);
        val = Math.max(val, findMax(boxes));
        System.out.println("Max = " + val);
    }

    private static int findMax(List<Box> boxes) {
        System.out.println(boxes);
        int max = 1;
        Box actualBox = boxes.get(0);
        for (Box box: boxes) {
            if (actualBox.w > box.w && actualBox.h > box.h && actualBox.d > box.d) {
                max++;
                actualBox = box;
            }
        }
        return max;
    }

    static class Box {
        int w,h,d;

        public Box(int w, int h, int d) {
            this.w = w;
            this.h = h;
            this.d = d;
        }

        @Override
        public String toString() {
            return "[" + w + ", " + h + ", " + d + "]";
        }
    }
}
