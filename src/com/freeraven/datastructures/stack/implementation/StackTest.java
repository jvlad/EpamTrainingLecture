package com.freeraven.datastructures.stack.implementation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by zvlad on 7/5/16.
 */
public class StackTest {
    private Stack<Integer> stack;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        stack = new StackImpl<>();
    }

    @Test
    public void push() throws Exception {
        stack.push(2);
        assertThat(stack.toString(), is("[2]"));
        stack.push(3);
        assertThat(stack.toString(), is("[2, 3]"));
        stack.push(43);
        assertThat(stack.toString(), is("[2, 3, 43]"));
    }

    @Test
    public void pop() throws Exception {
        stack.push(2);
        stack.pop();
        assertThat(stack.toString(), is("[]"));

        stack.push(2);
        stack.push(2);
        stack.pop();
        stack.pop();
        assertThat(stack.toString(), is("[]"));

        stack.push(2);
        stack.push(4);
        stack.push(2);
        stack.pop();
        assertThat(stack.toString(), is("[2, 4]"));
    }

    @Test
    public void pick() throws Exception {
        stack.push(2);
        stack.push(4);
        stack.push(2);
        Integer result = stack.pick();
        assertThat(result, is(2));
        assertThat(stack.toString(), is("[2, 4, 2]"));

        stack.pop();
        result = stack.pick();
        assertThat(result, is(4));
    }

    @Test
    public void pickException() throws Exception {
        exception.expect(NoSuchElementException.class);
        stack.pick();
    }

    @Test
    public void popException() throws Exception {
        exception.expect(NoSuchElementException.class);
        stack.pop();
    }

    @Test
    public void popException2() throws Exception {
        stack.push(2);
        stack.push(2);
        stack.pop();
        stack.pop();

        exception.expect(NoSuchElementException.class);
        stack.pop();
    }
}