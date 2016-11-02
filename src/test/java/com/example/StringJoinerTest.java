package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.StringJoiner;

import org.junit.Before;
import org.junit.Test;

public class StringJoinerTest {

    StringJoiner joiner;

    @Before
    public void setup() {
        joiner = new StringJoiner("-");
    }

    // #add() tests

    @Test
    public void addReturnsReferenceToSameJoiner() {
        assertThat(joiner.add("a")).isSameAs(joiner);
    }

    // #setEmptyValue() tests

    @Test(expected = NullPointerException.class)
    public void whenPassedNullSetEmptyValueThrowsNullPointerException() {
        joiner.setEmptyValue(null);
    }

    // #toString() tests

    @Test
    public void whenNoItemsAreAddedAndNoEmptyValueIsSetThenToStringReturnsTheEmptyString() {
        assertThat(joiner.toString()).isEmpty();
    }

    @Test
    public void whenNoItemsAreAddedAndThereIsAnEmptyValueSetThenToStringReturnsTheEmptyValue() {
        joiner.setEmptyValue("empty!");

        assertThat(joiner.toString()).isEqualTo("empty!");
    }

    @Test
    public void whenASingleItemIsAddedThenToStringReturnsTheItemVerbatim() {
        joiner.add("a");

        assertThat(joiner.toString()).isEqualTo("a");
    }

    @Test
    public void whenTwoItemsAreAddedThenToStringReturnsAStringOfTheConcatenatedItemsWithADelimiter() {
        joiner.add("a");
        joiner.add("b");

        assertThat(joiner.toString()).isEqualTo("a-b");
    }

    @Test
    public void whenManyItemsAreAddedThenToStringReturnsAStringOfTheConcatenatedItemsWithDelimiters() {
        joiner.add("a");
        joiner.add("b");
        joiner.add("c");

        assertThat(joiner.toString()).isEqualTo("a-b-c");
    }

    @Test
    public void whenAnEmptyItemIsAddedThenToStringIncludesItInTheOutput() {
        joiner.add("a");
        joiner.add("");
        joiner.add("b");

        assertThat(joiner.toString()).isEqualTo("a--b");
    }

    @Test
    public void whenANullItemIsAddedThenToStringPrintsNull() {
        joiner.add(null);

        assertThat(joiner.toString()).isEqualTo("null");
    }

    // #length() tests

    @Test
    public void whenNoItemsAreAddedThenLengthReturnsZero() {
        assertThat(joiner.length()).isEqualTo(0);
    }

    @Test
    public void whenSeveralItemsHaveBeenAddedThenLengthReturnsTotalLengthOfJoinedString() {
        joiner.add("a");
        joiner.add("b");

        assertThat(joiner.length()).isEqualTo(3);
    }

    // #merge() tests

    @Test(expected = NullPointerException.class)
    public void whenOtherIsNullThenThrowsNullPointerException() {
        joiner.merge(null);
    }
}
