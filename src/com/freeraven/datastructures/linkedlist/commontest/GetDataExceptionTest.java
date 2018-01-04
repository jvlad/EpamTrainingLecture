package com.freeraven.datastructures.linkedlist.commontest;

import com.freeraven.datastructures.linkedlist.LinkedList;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.ListTypeParameterSupplier;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListConfiguration;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListFactory;
import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(Theories.class)
public class GetDataExceptionTest {
    @DataPoints
    public static TestListConfiguration[] inputAndExpectedOutput = {
            /* 0 */ new TestListConfiguration<>(Arrays.asList(2, 78, 13, 42), Arrays.asList(-1), null),
            /* 1 */ new TestListConfiguration<>(Arrays.asList(2, 78, 13, 42), Arrays.asList(4), null),
            /* 2 */ new TestListConfiguration<>(Arrays.asList(2, 78, 13, 42), Arrays.asList(-50), null),
            /* 3 */ new TestListConfiguration<>(Arrays.asList(2, 78, 13, 42), Arrays.asList(50), null)
            };

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Theory
    public void test(@ListTypeParameterSupplier.ListTypes Class<LinkedList> listType,
                     TestListConfiguration<Integer, Object> testListConfiguration)
            throws Exception {
        LinkedList list = TestListFactory.createLinkedList(listType, testListConfiguration);
        invokeTestLogic(testListConfiguration, list);
    }

    private void invokeTestLogic(TestListConfiguration<Integer, Object> testListConfiguration, LinkedList list) {
        int testElementPosition = testListConfiguration.getTestElementPositionList().get(0);

        exception.expect(IndexOutOfBoundsException.class);
        list.getData(testElementPosition);
    }

}