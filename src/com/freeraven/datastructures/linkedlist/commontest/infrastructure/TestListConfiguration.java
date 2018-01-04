package com.freeraven.datastructures.linkedlist.commontest.infrastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zvlad on 7/2/16.
 */
public class TestListConfiguration<TypeOfListItem, TypeOfTestOutput> {
    private List<TypeOfListItem> dataItemsToPutInCollection;
    private List<Integer> positionsOfElementsToPerformTestActionOn;
    private TypeOfTestOutput expectedTestOutput;

    public TestListConfiguration(List<TypeOfListItem> dataItemsToPutInList,
                                 List<Integer> positionsOfElementsToPerformTestActionOn,
                                 TypeOfTestOutput expectedOutput) {
        this.dataItemsToPutInCollection = dataItemsToPutInList;
        this.expectedTestOutput = expectedOutput;
        this.positionsOfElementsToPerformTestActionOn = positionsOfElementsToPerformTestActionOn;
    }

    public List<TypeOfListItem> getDataItemsToPutInList() {
        return dataItemsToPutInCollection;
    }

    public ArrayList<Integer> getTestElementPositionList() {
        return positionsOfElementsToPerformTestActionOn == null ?
               null : new ArrayList<>(positionsOfElementsToPerformTestActionOn);
    }

    public TypeOfTestOutput getExpectedTestOutput() {
        return expectedTestOutput;
    }
}
