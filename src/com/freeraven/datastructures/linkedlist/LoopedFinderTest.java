package com.freeraven.datastructures.linkedlist;

import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListConfiguration;
import com.freeraven.datastructures.linkedlist.commontest.infrastructure.TestListFactory;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Theories.class)
public class LoopedFinderTest {
    @DataPoints
    public static TestListConfiguration[] testListConfigurations = {
            /* 0 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4),null, false),
            /* 1 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 0), true),
            /* 2 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 1), true),
            /* 3 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(3, 1), true),
            /* 4 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(3, 2), true),
            /* 5 */ new TestListConfiguration<>(Arrays.asList(1, 2, 3, 4), Arrays.asList(3, 0), true)
    };

    @Theory
    public void test(TestListConfiguration<Integer, Boolean> testConfiguration) throws Exception {
        Class listType = LoopedLinkedListNode.class;
        LoopedLinkedListNode listToTest = (LoopedLinkedListNode) TestListFactory
                .createLinkedList(listType, testConfiguration);

        ArrayList<Integer> loopBoundaries = testConfiguration.getTestElementPositionList();
        if (loopBoundaries != null) {
            Integer sourceNodeIndex = loopBoundaries.get(0);
            Integer targetNodeIndex = loopBoundaries.get(1);
            listToTest.setLoop(sourceNodeIndex, targetNodeIndex);
        }

        boolean expectedTestOutput = testConfiguration.getExpectedTestOutput();
        boolean actualResult;

        actualResult = listToTest.hasLoop(listToTest.new TraversingLoopDetector());
        assertThat(actualResult, is(expectedTestOutput));

        actualResult = listToTest.hasLoop(listToTest.new RunnersLoopDetector());
        assertThat(actualResult, is(expectedTestOutput));
    }
}