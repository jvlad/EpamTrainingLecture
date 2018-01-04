package com.freeraven.datastructures.stack.multiplestackinarray;

import java.util.NoSuchElementException;

/**
 * Created by zvlad on 7/7/16.
 */
class StackInArray {
    private int bottomLimitIndex;
    private int topLimitIndex;
    private Integer headIndex;

    StackInArray(int bottomIndex, int topIndex) {
        this.bottomLimitIndex = bottomIndex;
        this.topLimitIndex = topIndex;
        headIndex = null;
    }

    int getBottomLimitIndex() {
        return bottomLimitIndex;
    }

    int getTopLimitIndex() {
        return topLimitIndex;
    }

    public Integer getHeadIndex() {
        return headIndex;
    }

    void onPush(){
        if (headIndex == null){
            headIndex = bottomLimitIndex;
        } else {
            headIndex++;
        }
    }

    void onPop(){
        if (headIndex == null){
            throw new NoSuchElementException();
        }

        if (headIndex == bottomLimitIndex){
            headIndex = null;
        } else {
            headIndex--;
        }
    }
}
