package com.freeraven.datastructures.linkedlist.commontest;

import com.freeraven.datastructures.linkedlist.LinkedList;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.ListTypeParameterSupplier;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListConfiguration;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListFactory;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by zvlad on 7/4/16.
 */
@RunWith(Theories.class)
public class AppendTest {
    @DataPoints
    public static TestListConfiguration[] inputAndExpectedOutput =
            new TestListConfiguration[]{null};

    @Theory
    public void test(@ListTypeParameterSupplier.ListTypes Class<LinkedList> listType)
            throws Exception {
        LinkedList list = TestListFactory.createLinkedList(listType);
        invokeTestLogic(list);
    }

    private void invokeTestLogic(LinkedList list) {
        assertThat(list.toString(), is("[]"));
        list.append(3);
        assertThat(list.toString(), is("[3]"));
        assertThat(list.getSize(), is(1));

        list.append(5);
        assertThat(list.toString(), is("[3, 5]"));
        assertThat(list.getSize(), is(2));

        list.append(532);
        assertThat(list.toString(), is("[3, 5, 532]"));
        assertThat(list.getSize(), is(3));
    }
}
