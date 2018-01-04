package com.freeraven.algorithms.fibonacci;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by zvlades on 4/1/17.
 */
public class FibonacciTest {
    @Test
    public void basicCorrectnessOfRecursiveAlgorithm() throws Exception {
        Fibonacci fib = new Fibonacci();
        assertThat(fib.getItemAtPositionRecursively(0), is(0l));
        assertThat(fib.getItemAtPositionRecursively(1), is(1l));
        assertThat(fib.getItemAtPositionRecursively(2), is(1l));
        assertThat(fib.getItemAtPositionRecursively(5), is(5l));
        assertThat(fib.getItemAtPositionRecursively(6), is(8l));
        assertThat(fib.getItemAtPositionRecursively(20), is(6765l));
    }

    @Test
    public void basicCorrectness() throws Exception {
        Fibonacci fib = new Fibonacci();
        assertThat(fib.getItemAtPosition(0), is(0l));
        assertThat(fib.getItemAtPosition(1), is(1l));
        assertThat(fib.getItemAtPosition(2), is(1l));
        assertThat(fib.getItemAtPosition(5), is(5l));
        assertThat(fib.getItemAtPosition(6), is(8l));
        assertThat(fib.getItemAtPosition(20), is(6765l));
    }



    @Test(expected=IllegalArgumentException.class)
    public void exceptionShouldRiseIfNegativePassed1() throws Exception {
        Fibonacci fib = new Fibonacci();
        fib.getItemAtPositionRecursively(-1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void exceptionShouldRiseIfNegativePassed2() throws Exception {
        Fibonacci fib = new Fibonacci();
        fib.getItemAtPosition(-1);
    }
}