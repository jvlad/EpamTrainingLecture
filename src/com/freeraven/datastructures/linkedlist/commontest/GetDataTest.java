package com.freeraven.datastructures.linkedlist.commontest;

import com.freeraven.datastructures.linkedlist.LinkedList;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.ListTypeParameterSupplier;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListConfiguration;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListFactory;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class GetDataTest {
    @DataPoints
    public static TestListConfiguration[] inputAndExpectedOutput = {
            /* 0 */ new TestListConfiguration<>(Arrays.asList(2, 78, 13, 42), Arrays.asList(1), 78),
            /* 1 */ new TestListConfiguration<>(Arrays.asList(435, 0, 0, 1), Arrays.asList(0), 435),
            /* 2 */ new TestListConfiguration<>(Arrays.asList(435, 0, 0, 1, 32), Arrays.asList(4), 32),
            };

    @Theory
    public void test(@ListTypeParameterSupplier.ListTypes Class<LinkedList> listType,
                     TestListConfiguration<Integer, Object> testListConfiguration)
            throws Exception {
        LinkedList list = TestListFactory.createLinkedList(listType, testListConfiguration);
        invokeTestLogic(testListConfiguration, list);
    }

    private void invokeTestLogic(TestListConfiguration<Integer, Object> testListConfiguration, LinkedList list) {
        int testElementPosition = testListConfiguration.getTestElementPositionList().get(0);
        Object testElementValue = list.getData(testElementPosition);
        assertThat(testListConfiguration.getExpectedTestOutput(), is(testElementValue));
    }
}