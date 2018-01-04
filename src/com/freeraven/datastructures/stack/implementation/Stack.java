package com.freeraven.datastructures.stack.implementation;

/**
 * Created by zvlad on 7/5/16.
 */
public interface Stack<T> {
    void push(T obj);

    void pop();

    T pick();
}
