package com.freeraven.unsorted;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zvlades on 5/19/17.
 */
public class SummandsPairCounter2Test {
    @Test
    public void allPairCounter() throws Exception {
        int[] array = new int[]{1, 2, 3};
        int result = SummandsPairCounter2.numberOfPairs(array, 3);
        assertEquals(1, result);


        array = new int[]{6,6,3,9,3,5,1};
        result = SummandsPairCounter2.numberOfPairs(array, 12);
        assertEquals(2, result);

        array = new int[]{6,6,6,6};
        result = SummandsPairCounter2.numberOfPairs(array, 12);
        assertEquals(1, result);

        array = new int[]{6,6,6};
        result = SummandsPairCounter2.numberOfPairs(array, 12);
        assertEquals(1, result);

        array = new int[]{};
        result = SummandsPairCounter2.numberOfPairs(array, 12);
        assertEquals(0, result);

        array = new int[]{0, 12};
        result = SummandsPairCounter2.numberOfPairs(array, 12);
        assertEquals(1, result);

        array = new int[]{5, 3, 3 ,3 ,1, 3, 3, 3};
        result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(2, result);

        array = new int[]{1, 1, 1, 5, 5, 5};
        result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(1, result);
    }


    @Test
    public void uniquePair() throws Exception {
        int[] array = new int[]{1, 1, 1, 5, 5, 5};
        int result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(1, result);
    }

    @Test
    public void uniquePair2() throws Exception {
        int[] array = new int[]{3, 3, 3, 3};
        int result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(1, result);
    }

    @Test
    public void uniquePair3() throws Exception {
        int[] array = new int[]{3, 2, 1, 2};
        int result = SummandsPairCounter2.numberOfPairs(array, 4);
        assertEquals(2, result);
    }

    @Test
    public void uniquePair4() throws Exception {
        int[] array;
        int result;

        array = new int[]{6,6,3,9,3,5,1};
        result = SummandsPairCounter2.numberOfPairs(array, 12);
        assertEquals(2, result);
    }

    @Test
    public void uniquePair5() throws Exception {
        int[] array = new int[]{1, 5, 2, 1, 5};
        int result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(1, result);
    }

    @Test
    public void uniquePair6() throws Exception {
        int[] array = new int[]{1, 5};
        int result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(1, result);
    }

    @Test
    public void uniquePair7() throws Exception {
        int[] array = new int[]{1, 5, 5, 1};
        int result = SummandsPairCounter2.numberOfPairs(array, 6);
        assertEquals(1, result);
    }

    @Test
    public void uniquePair8() throws Exception {
        int[] array = new int[]{1, 5};
        int result = SummandsPairCounter2.numberOfPairs(array, 10);
        assertEquals(0, result);
    }

}