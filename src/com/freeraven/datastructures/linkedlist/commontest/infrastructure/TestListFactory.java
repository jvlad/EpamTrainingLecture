package com.freeraven.datastructures.linkedlist.commontest.infrastructure;

import com.freeraven.datastructures.linkedlist.LinkedList;

import java.util.List;

/**
 * Created by zvlad on 7/2/16.
 */
public class TestListFactory {
    public static LinkedList createLinkedList(Class<LinkedList> listType,
                                              TestListConfiguration listConfiguration)
            throws IllegalAccessException, InstantiationException {
        LinkedList listToTest = listType.newInstance();
        List parameters = listConfiguration.getDataItemsToPutInList();
        parameters.forEach(listToTest::append);
        return listToTest;
    }

    public static LinkedList createLinkedList(Class<LinkedList> listType)
            throws IllegalAccessException, InstantiationException {
        return listType.newInstance();
    }
}
