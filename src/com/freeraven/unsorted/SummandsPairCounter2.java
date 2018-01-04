package com.freeraven.unsorted;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zvlades on 5/19/17.
 */
class SummandsPairCounter2 {
    public int i;
    public int j;

    SummandsPairCounter2(int i, int j) {
        this.i = Math.min(i, j);
        this.j = Math.max(i, j);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + i;
        result = prime * result + j;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SummandsPairCounter2 other = (SummandsPairCounter2) obj;
        if (i != other.i)
            return false;
        if (j != other.j)
            return false;
        return true;
    }

    static int numberOfPairs2(int[] a, long k) {
        Arrays.sort(a);

        HashSet<SummandsPairCounter2> store = new HashSet<>();
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            long term = k - a[i];
            int iterm = (int) term;
            int index = Arrays.binarySearch(a, iterm);
            if (index > -1 && i != index) {
                SummandsPairCounter2 p = new SummandsPairCounter2(iterm, a[i]);
                if (!store.contains(p)) {
                    n++;
                    store.add(p);
                }
            }
        }
        return n;
    }

    public static int numberOfPairs(int[] Array, long sum) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < Array.length; i++)
            m.put(Array[i], i);

        HashSet<Integer> usedItems = new HashSet<>();

        int numPairs = 0;
        for (int i = 0; i < Array.length; i++) {
            int item = Array[i];
            int term = (int) (sum - item);
            if (usedItems.contains(item) || usedItems.contains(term))
                continue;

            Integer itemIndex = m.get(term);
            if (itemIndex != null && !itemIndex.equals(i)) {
                numPairs++;
                usedItems.add(item);
                usedItems.add(term);
            }
        }
        return numPairs;
    }
}