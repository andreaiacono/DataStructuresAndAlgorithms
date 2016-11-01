package misc;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrea on 03/09/16.
 */
public class BestItemsForCredit {

    public static Pair<Integer, Integer> getBestItems(List<Integer> items, int credit) {
        for (int j=0; j<items.size(); j++) {
            for (int i=j+1; i<items.size(); i++) {
                if (items.get(i) + items.get(j) == credit) return i<j ? new Pair<>(i, j) : new Pair<>(j, i);
            }
        }
        return new Pair<>(0,0);
    }

    public static Pair getBestItemsUsingSort(List<Integer> items, int credit) {
        Collections.sort(items);
        int left = 0;
        int right = items.size()-1;
        while (items.get(left) + items.get(right) != credit && left != right) {
            System.out.println("left=" + left + " right=" + right + " g(l) =" + items.get(left) + " g(r)=" + items.get(right));
            if (items.get(left) + items.get(right) > credit) right--;
            else left++;
        }
        if (left == right) return new Pair(0,0);
        else return new Pair(left, right);
    }


    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(41);
        values.add(1);
        values.add(13);
        values.add(38);
        values.add(8);
        values.add(16);
        values.add(71);
        values.add(14);
        values.add(10);
        values.add(21);
        values.add(19);
        values.add(15);
        values.add(7);
        values.add(24);
        System.out.println("Pair is " + getBestItems(values, 40));
        System.out.println("Sorted Pair is " + getBestItemsUsingSort(values, 40));

    }

}
