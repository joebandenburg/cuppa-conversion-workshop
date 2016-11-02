package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.StringJoiner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringJoinerParameterisedTest {
    @Parameters
    public static Collection<Object[]> inputs() {
        return Arrays.asList(new Object[][] {
                { "a-b-c", new String[] { "a", "b", "c" } },
                { "test-another-test", new String[] { "test", "another-test" } },
                { "bing-bong", new String[] { "bing", "bong" } }
        });
    }

    @Parameter
    public String expected;

    @Parameter(1)
    public String[] inputs;

    @Test
    public void test() {
        StringJoiner joiner = new StringJoiner("-");
        for (String input : inputs) {
            joiner.add(input);
        }

        assertThat(joiner.toString()).isEqualTo(expected);
    }
}
