package com.freeraven.algorithms.fibonacci;

/**
 * Created by zvlades on 4/1/17.
 */
public class Fibonacci {

    public long getItemAtPositionRecursively(int position) {
        if (position < 0) throw new IllegalArgumentException("position < 0");

        if (position < 2) {
            return position;
        }

        return getItemAtPositionRecursively(position - 1)
                + getItemAtPositionRecursively(position - 2);
    }

    public long getItemAtPosition(int position) {
        if (position < 0) throw new IllegalArgumentException("position < 0");

        if (position < 2) {
            return position;
        }

        int previous = 0;
        int current = 1;
        int oldPrevious;
        for (int i = 1; i < position; i++) {
            oldPrevious = previous;
            previous = current;
            current = current + oldPrevious;
        }
        return current;
    }
}
