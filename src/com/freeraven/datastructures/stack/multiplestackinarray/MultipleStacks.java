package com.freeraven.datastructures.stack.multiplestackinarray;

import java.util.ArrayList;

/**
 * Created by zvlad on 7/7/16.
 */
// implementation is not ready yet
public class MultipleStacks {
    private final int SINGLE_STACK_INIT_CAPACITY = 10;
    private final int numberOfStacks;
    private int singleStackCapacity;
    private Integer[] data;
    private ArrayList<StackInArray> stackList;

    public MultipleStacks(int numberOfStacks) {
        singleStackCapacity = SINGLE_STACK_INIT_CAPACITY;
        data = new Integer[singleStackCapacity * numberOfStacks];
        this.numberOfStacks = numberOfStacks;
        stackList = initStacks(this.numberOfStacks);
    }

    private ArrayList<StackInArray> initStacks(int numberOfStacks) {
        ArrayList<StackInArray> stackList = new ArrayList<>();
        int newStackBottomIndex = 0;
        for (int i = 0; i < numberOfStacks; i++) {
            int currentStackTopIndex = newStackBottomIndex + singleStackCapacity - 1;
            stackList.add(new StackInArray(newStackBottomIndex, currentStackTopIndex));
            newStackBottomIndex = currentStackTopIndex + 1;
        }
        return stackList;
    }

    void pushToStack(int stackNumber, Integer data){

    }
}
