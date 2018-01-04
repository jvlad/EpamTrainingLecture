package com.freeraven.datastructures.strings.reverse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by zvlad on 6/29/16.
 */
@RunWith(Parameterized.class)
public class StringReverseTest {
    private String input;
    private String expectedResult;

    public StringReverseTest(String input, String expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {"abc", "cba"},
                {"aaa", "aaa"},
                {"aga", "aga"},
                {"aaaaax", "xaaaaa"},
                {"dcdcdc", "cdcdcd"}
        });
    }

    @Test
    public void builtInReverseTest() throws Exception {
        StringReverse instance = new BuiltInReverseImpl();
        String actualResult = instance.reverse(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }

    @Test
    public void customReverseTest() throws Exception {
        StringReverse instance = new ReverseImpl();
        String actualResult = instance.reverse(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }
}