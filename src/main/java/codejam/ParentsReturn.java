package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class ParentsReturn {


    static String input = "5\n" +
            "3\n" +
            "360 480\n" +
            "420 540\n" +
            "600 660\n" +
            "3\n" +
            "0 1440\n" +
            "1 3\n" +
            "2 4\n" +
            "5\n" +
            "99 150\n" +
            "1 100\n" +
            "100 301\n" +
            "2 5\n" +
            "150 250\n" +
            "2\n" +
            "0 720\n" +
            "720 1440\n" +
            "4\n" +
            "20 35\n" +
            "30 40\n" +
            "10 25\n" +
            "10 20\n";

    public static void main(String[] args) {
//     ?Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner in = new Scanner(new BufferedReader(new StringReader(input)));

        long n = in.nextLong(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 0; i < n; i++) {
            int size = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                activities.add(new Activity(in.nextInt(), in.nextInt()));
            }
            Planning planning = parenting(new Planning(new Parent(), new Parent()), 0, activities);
            String result = schedule(planning, activities);
            System.out.println("Case #" + (i + 1) + ": " + result + " " +  planning);
        }
    }
    
    private static Planning parenting(Planning partial, int currentIdx, List<Activity> activities) {

        if (currentIdx >= activities.size()) {
            return new Planning(partial.cameron, partial.jamie);
        }

        Activity currentActivity = activities.get(currentIdx);
        if (!partial.cameron.isFreeFor(currentActivity) && !partial.jamie.isFreeFor(currentActivity)) {
            return null;
        }

        if (partial.cameron.isFreeFor(currentActivity)) {
            partial.cameron.add(currentActivity);
            Planning result = parenting(partial, currentIdx + 1, activities);
            if (result != null) {
                return result;
            };
            partial.cameron.remove(currentActivity);
        }
        if (partial.jamie.isFreeFor(currentActivity)) {
            partial.jamie.add(currentActivity);
            Planning result = parenting(partial, currentIdx + 1, activities);
            if (result != null) {
                return result;
            }
            partial.jamie.remove(currentActivity);
        }
        return null;
    }

    private static String schedule(Planning planning, List<Activity> activities) {
        if (planning == null) {
            return "IMPOSSIBLE";
        }
        StringBuilder result = new StringBuilder();
        for (Activity activity: activities) {
            if (planning.cameron.plan.contains(activity)) {
                result.append("C");
            }
            else {
                result.append("J");
            }
        }
        return result.toString();
    }

    static class Planning {
        Parent cameron;
        Parent jamie;

        public Planning(Parent cameron, Parent jamie) {
            this.cameron = new Parent();
            this.cameron.plan = cameron.plan;
            this.jamie = new Parent();
            this.jamie.plan = jamie.plan;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Planning{");
            sb.append("cameron=").append(cameron);
            sb.append(", jamie=").append(jamie);
            sb.append('}');
            return sb.toString();
        }
    }
    
    static class Parent {
        List<Activity> plan = new ArrayList<>();

        public void add(Activity activity) {
            plan.add(activity);
        }

        public boolean isFreeFor(Activity toAdd) {
            for (Activity planned : plan) {
                if ((toAdd.start >= planned.start && toAdd.start < planned.end) ||
                        (toAdd.end > planned.start && toAdd.end <= planned.end)) {
                    return false;
                }
            }
//            System.out.println("is Free to add " + toAdd + " in plan " + plan);
            return true;
        }

        @Override
        public String toString() {
            return plan.toString();
        }

        public void remove(Activity activity) {
            plan.remove(activity);
        }
    }

    static class Activity {
        int start;
        int end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Activity activity = (Activity) o;

            if (start != activity.start) return false;
            return end == activity.end;
        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
