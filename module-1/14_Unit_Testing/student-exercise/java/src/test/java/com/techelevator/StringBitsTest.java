package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {
    private StringBits subject;

    @Before
    public void setUp() throws Exception {
        subject = new StringBits();
    }

    @Test
    public void getBitsStringLongerThanTwo() {
        String expected = "Hlo";
        String actual = subject.getBits("Hello");
        assertEquals("Hello should produce Hlo",expected, actual);
    }

    @Test
    public void getBitsStringOfTwo() {
        String expected = "H";
        String actual = subject.getBits("Hi");
        assertEquals("Hi should produce H",expected, actual);
    }

    @Test
    public void getBitsNull() {
        String expected = "";
        String actual = subject.getBits(null);
        assertEquals("Null should return empty string",expected, actual);
    }
}