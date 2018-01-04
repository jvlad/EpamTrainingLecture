package com.freeraven.datastructures.stack.implementation;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by zvlad on 7/5/16.
 */
public class StackImpl<T> implements Stack<T> {
    private LinkedList<T> container;

    StackImpl(){
        container = new LinkedList<>();
    }

    @Override
    public void push(T obj) {
        container.addLast(obj);
    }

    @Override
    public void pop() {
        if (container.getLast() == null){
            throw new NoSuchElementException();
        }
        container.removeLast();
    }

    @Override
    public T pick() {
        if (container.getLast() == null){
            throw new NoSuchElementException();
        }
        return container.getLast();
    }

    @Override
    public String toString() {
        return container.toString();
    }
}
