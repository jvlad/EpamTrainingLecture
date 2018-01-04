package com.freeraven.datastructures.strings.uniqueness;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

/**
 * Created by zvlad on 6/29/16.
 */
@RunWith(Parameterized.class)
public class CharactersUniquenessCheckerTest {
    private String input;
    private boolean expectedResult;

    public CharactersUniquenessCheckerTest(String input, boolean expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][]{
                {"abc", true},
                {"abb", false},
                {"aab", false},
                {"aba", false},
                {"some crazy wd", false},
                {"wrf 096_", true},
        });
    }

    @Test
    public void implWithSetDSTest() {
        CharactersUniquenessChecker instance = new ImplWithSetDS();
        boolean actualResult = instance.check(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }

    @Test
    public void implWithoutSetTest() {
        CharactersUniquenessChecker instance = new ImplWithoutSetDS();
        boolean actualResult = instance.check(this.input);
        assertThat(actualResult, is(this.expectedResult));
    }

}