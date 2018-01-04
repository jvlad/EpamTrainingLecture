package com.freeraven.maths.arithmetic;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by zvlad on 7/11/16.
 */
public class OperationsTest {
    private OperationsWithSummation test;

    @Before
    public void init(){
        test = new OperationsWithSummation();
    }

    @Test
    public void subtract(){
        assertThat(test.subtract(0, -3), is(3));
        assertThat(test.subtract(-3, 0), is(-3));
        assertThat(test.subtract(17, 8), is(9));
        assertThat(test.subtract(4, 17), is(-13));
        assertThat(test.subtract(-4, -4), is(-0));
        assertThat(test.subtract(4, 4), is(-0));
    }

    @Test
    public void multiply(){
        assertThat(test.multiply(-3, 2), is(-6));
        assertThat(test.multiply(0, 0), is(0));
        assertThat(test.multiply(0, 3), is(0));
        assertThat(test.multiply(3, 0), is(0));
        assertThat(test.multiply(-3, 0), is(0));
        assertThat(test.multiply(2, 3), is(6));
        assertThat(test.multiply(3, 2), is(6));
        assertThat(test.multiply(-3, -2), is(6));
    }

    @Rule
    public ExpectedException divideByZeroException = ExpectedException.none();

    @Test
    public void divideByZero() throws Exception {
        divideByZeroException.expect(ArithmeticException.class);
        test.divide(5, 0);
    }

    @Test
    public void divide() throws Exception {
        assertThat(test.divide(18, -6), is(-3));
        assertThat(test.divide(3, 5), is(0));
        assertThat(test.divide(0, -5), is(0));
        assertThat(test.divide(0, 5), is(0));
        assertThat(test.divide(5, 3), is(1));
        assertThat(test.divide(18, 6), is(3));
        assertThat(test.divide(18, -1), is(-18));
    }
}