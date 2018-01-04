package com.freeraven.datastructures.linkedlist.commontest;

import com.freeraven.datastructures.linkedlist.LinkedList;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.ListTypeParameterSupplier;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListConfiguration;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListFactory;
import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class DeleteTest {
    @DataPoints
    public static TestListConfiguration[] inputAndExpectedOutput = {
            /* 0 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(0), "[2, 3, 4]"),
            /* 1 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(1), "[1, 3, 4]"),
            /* 2 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(3), "[1, 2, 3]"),
            /* 3 */ new TestListConfiguration<>(Arrays.asList(3), Arrays.asList(0), "[]"),
            /* 4 */ new TestListConfiguration<>(Arrays.asList(3, 2), Arrays.asList(1), "[3]"),
            };

    @Theory
    public void test(@ListTypeParameterSupplier.ListTypes Class<LinkedList> listType,
                     TestListConfiguration<Integer, String> testListConfiguration)
            throws Exception {
        LinkedList list = TestListFactory.createLinkedList(listType, testListConfiguration);
        invokeTestLogic(testListConfiguration, list);
    }

    private void invokeTestLogic(TestListConfiguration<Integer, String> testListConfiguration, LinkedList list) {
        int originListSize = list.getSize();
        int targetElementPosition = testListConfiguration.getTestElementPositionList().get(0);
        list.deleteNodeAt(targetElementPosition);
        assertThat(list.toString(), is(testListConfiguration.getExpectedTestOutput()));
        assertThat(list.getSize(), is(originListSize - 1));
    }
}