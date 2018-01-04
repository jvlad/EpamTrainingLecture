package com.freeraven.datastructures.linkedlist.removeduplicates;

import java.util.*;

/**
 * Created by zvlad on 7/5/16.
 */
// problem 2.1, p.86
public class RemoveDuplicates {
    public static void removeFrom(List<Integer> list) {
        ArrayList<Integer> duplicatesIndexList = findDuplicatesIndexesIn(list);
        removeFromListByIndex(list, duplicatesIndexList);
    }

    private static ArrayList<Integer> findDuplicatesIndexesIn(List<Integer> list) {
        ArrayList<Integer> duplicatesIndexList = new ArrayList<>();
        HashSet<Integer> uniqueValues = new HashSet<>();
        Iterator<Integer> iterator = list.iterator();
        Integer currentIndex = 0;
        while (iterator.hasNext()) {
            Integer currentItem = iterator.next();
            if (uniqueValues.contains(currentItem)){
                duplicatesIndexList.add(currentIndex);
            }
            uniqueValues.add(currentItem);
            currentIndex++;
        }
        return duplicatesIndexList;
    }

    private static void removeFromListByIndex(List<Integer> list, ArrayList<Integer> duplicatesIndexList) {
        for (int deletionCounter = 0; deletionCounter < duplicatesIndexList.size(); deletionCounter++) {
            int duplicateIndex = duplicatesIndexList.get(deletionCounter);
            list.remove(duplicateIndex - deletionCounter);
        }
    }
}
