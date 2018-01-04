package com.freeraven.unsorted;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zvlades on 5/19/17.
 */
class SummandsPairCounter {
    public static int numberOfAllPairs(int[] a, long k) {

        HashMap<Long, Integer> store = new HashMap<>();
        int counter = 0;
        for (int i : a) {
            Long secondSummand = k - i;
            if (store.containsKey(secondSummand) && store.get(secondSummand) > 0) {
                counter++;
                decrease(store, secondSummand);
            } else {
                increase(store, (long)i);
            }
        }
        return counter;
    }

    private static void decrease(HashMap<Long, Integer> store, Long secondSummand) {
        int currentNumber = store.get(secondSummand);
        store.put(secondSummand, --currentNumber);
    }

    private static void increase(HashMap<Long, Integer> store, Long firstSummand) {
        Integer currentNumber = store.get(firstSummand);
        if (currentNumber == null) {
            store.put(firstSummand, 1);
        } else {
            store.put(firstSummand, ++currentNumber);
        }
    }


    public static int numberOfUniquePairs(int[] array, long sum) {
        HashSet<Long> candidates = new HashSet<>();
        HashSet<Long> matched = new HashSet<>();

        int counter = 0;
        for (int candidate : array) {
            if (matched.contains((long) candidate)) {
                continue;
            }

            Long secondSummand = sum - candidate;
            if (candidates.contains(secondSummand)) {
                counter++;
//                matched.add(secondSummand);
                matched.add((long) candidate);
            } else {
                candidates.add((long) candidate);
            }
        }
        return counter;
    }

}
