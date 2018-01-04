package com.freeraven.datastructures.linkedlist.removeduplicates;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by zvlad on 7/5/16.
 */
public class RemoveDuplicatesTest {
    @Test
    public void removeFromTest1() throws Exception {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 4, 6, 4, 46, 65, 23, 23, 54, 543, 345, 23, 46));
        RemoveDuplicates.removeFrom(list);
        assertThat(list.toString(), is("[1, 4, 6, 46, 65, 23, 54, 543, 345]"));
    }

    @Test
    public void removeFromTest2() throws Exception {
        List<Integer> list = new LinkedList<>(Arrays.asList(4, 4, 4, 4));
        RemoveDuplicates.removeFrom(list);
        assertThat(list.toString(), is("[4]"));
    }

    @Test
    public void removeFromTest3() throws Exception {
        List<Integer> list = new LinkedList<>(Arrays.asList(0, 4, 0, 4, 0, 4, 0, 4, 0, 4));
        RemoveDuplicates.removeFrom(list);
        assertThat(list.toString(), is("[0, 4]"));
    }

    @Test
    public void removeFromTest4() throws Exception {
        List<Integer> list = new LinkedList<>(Arrays.asList(0, 4, 0, 4, 0, 4, 0, 4, 0, 4, 7));
        RemoveDuplicates.removeFrom(list);
        assertThat(list.toString(), is("[0, 4, 7]"));
    }
}