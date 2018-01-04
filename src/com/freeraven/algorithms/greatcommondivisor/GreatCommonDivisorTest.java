package com.freeraven.algorithms.greatcommondivisor;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by zvlades on 4/1/17.
 */
public class GreatCommonDivisorTest {
    private final List<GreatCommonDivisor> implementationsToTest = new ArrayList<>();

    @Test
    public void testBasicCorrectness() throws Exception {
        implementationsToTest.add(new NaiveGreatCommonDivisor());
        implementationsToTest.add(new EuclidGreatCommonDivisor());

        for (GreatCommonDivisor item : implementationsToTest) {
            basicCorrectness(item);
        }
    }

    private void basicCorrectness(GreatCommonDivisor item) throws Exception {
        assertThat(item.gcd(5, 0), is(5));
        assertThat(item.gcd(5, 3), is(1));
        assertThat(item.gcd(6, 3), is(3));
        assertThat(item.gcd(6, 3), is(3));
        assertThat(item.gcd(24, 54), is(6));
        assertThat(item.gcd(24, 8), is(8));
    }

}