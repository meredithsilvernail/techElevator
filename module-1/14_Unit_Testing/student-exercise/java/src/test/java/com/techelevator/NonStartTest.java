package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {
    private NonStart subject;

    @Before
    public void setUp() throws Exception {
        subject = new NonStart();
    }

    @Test
    public void getPartialStringWithTwoStrings() {
        String expected = "ellohere";
        String actual = subject.getPartialString("Hello", "There");
        assertEquals("Hello and There should produce ellohere",expected, actual);
    }

    @Test
    public void getPartialStringFirstStringEmpty() {
        String expected = "ello";
        String actual = subject.getPartialString("Hello", "");
        assertEquals("Hello should become ello",expected, actual);
    }

    @Test
    public void getPartialStringSecondStringEmpty() {
        String expected = "ello";
        String actual = subject.getPartialString("", "Hello");
        assertEquals("Hello should become ello",expected, actual);
    }
}