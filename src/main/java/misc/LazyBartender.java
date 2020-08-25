package misc;

import java.util.*;

public class LazyBartender {

    // https://www.careercup.com/question?id=5672092990177280
    public static void main(String[] args) {
        List<Integer> c1 = new ArrayList<Integer>(Arrays.asList(1, 5, 3, 0, 4));
        List<Integer> c2 = new ArrayList<Integer>(Collections.singletonList(3));
        List<Integer> c3 = new ArrayList<Integer>(Arrays.asList(0, 1));
        List<Integer> c4 = new ArrayList<Integer>(Collections.singletonList(2));
        List<Integer> c5 = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 5, 2));
        List<List<Integer>> input = new ArrayList<>();
        input.add(c1);
        input.add(c2);
        input.add(c3);
        input.add(c4);
        input.add(c5);
        List<Integer> expectedResult = new ArrayList<Integer>(Arrays.asList(3, 4, 5));
        int result = lazyBartender(input);
        System.out.println("Result= " + result);
    }

    private static int lazyBartender(List<List<Integer>> input) {
        int n = input.size();
        List<Integer> allDrinks = new ArrayList<>();
        List<Map<Integer, Boolean>> favouriteDrinks = new ArrayList<>();
        Set<Integer> clients = new HashSet<>();

        for (int client = 0; client < n; client++) {
            clients.add(client);
            HashMap<Integer, Boolean> map = new HashMap<>();
            for (int j = 0; j < input.get(client).size(); j++) {
                int drink = input.get(client).get(j);
                map.put(drink, true);
                if (!allDrinks.contains(drink)) {
                    allDrinks.add(drink);
                }
            }
            favouriteDrinks.add(map);
        }
        System.out.println("all:" + allDrinks);

        for (List<Integer> drinksSubset : getSubsets(allDrinks)) {
            System.out.println("SUBSET: " + drinksSubset);
            Set<Integer> clientsDrinks = new HashSet<>(clients);
            for (Integer drink : drinksSubset) {
                for (int client = 0; client < n; client++) {
                    if (favouriteDrinks.get(client).containsKey(drink)) {
                        clientsDrinks.remove(client);
                    }
                }
            }
            System.out.println("remaining: " + clientsDrinks);
            if (clientsDrinks.size() == 0) {
                return drinksSubset.size();
            }
        }
        return 0;
    }

    private static List<List<Integer>> getSubsets(List<Integer> all) {
        List<List<Integer>> result = new ArrayList<>();
        int n = all.size();
        int subsets = (int) Math.pow(2, n);
        for (int i = 1; i < subsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) > 0) {
                    subset.add(j);
                }
            }
            result.add(subset);
        }
        System.out.println(result);
        return result;
    }
}
