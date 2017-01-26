package interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/order-of-people-heights/
 */
public class OrderOfPeopleHeights {

    class Person {
        int height;
        int inFront;

        public Person(int height, int inFront) {
            this.height = height;
            this.inFront = inFront;
        }

        @Override
        public String toString() {
            return "(" + height + "," + inFront + ")";
        }
    }

    @Test
    public void test() {
        ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(86, 92, 49, 21, 62, 27, 90, 59));
        ArrayList<Integer> inFronts = new ArrayList<>(Arrays.asList(2, 0, 0, 2, 0, 2, 1, 3));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(49, 62, 21, 27, 92, 90, 59, 86));

        assertEquals(expected, order(heights, inFronts));
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {

        if (heights.size() != infronts.size()) {
            return null;
        }

        List<Person> people = new ArrayList<>();
        int maxInFront = 0;
        for (int i = 0; i < heights.size(); i++) {
            people.add(new Person(heights.get(i), infronts.get(i)));
            if (maxInFront < infronts.get(i)) {
                maxInFront = infronts.get(i);
            }
        }
        //Collections.sort(people, (p1,p2) -> Integer.compare(p1.inFront, p2.inFront));
        ArrayList<Person> partial = new ArrayList<>();

        List<Person> fronts = getInFronts(0, people);
        if (fronts.size() > 1) {
            Collections.sort(fronts, (p1, p2) -> Integer.compare(p1.height, p2.height));
        }
        for (Person person : fronts) {
            System.out.println("adding first persons " + person + " at last position");
            partial.add(person);
        }

        for (int i = 1; i <= maxInFront; i++) {
            fronts = getInFronts(i, people);
            for (Person person : fronts) {
                int taller = 0;
                for (int j = 0; j < partial.size(); j++) {
                    if (partial.get(j).height >= person.height) {
                        taller++;
                    }
                    if (j == taller) {
                        System.out.println("adding person " + person + " at positin " + j);
                        partial.add(j+1, person);
                        break;
                    }
                }

//                System.out.println("adding person " + person + " at last position");
//                partial.add(person);
            }

        }

        return new ArrayList<>(partial.stream().map(p -> p.height).collect(Collectors.toList()));
    }

    List<Person> getInFronts(int n, List<Person> people) {

        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.inFront == n) {
                result.add(person);
            }
        }

        return result;
    }
}
