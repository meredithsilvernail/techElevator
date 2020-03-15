package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {
    private FrontTimes subject;

    @Before
    public void setUp() throws Exception {
        subject = new FrontTimes();
    }

    //full string is length less than 3
    //first three letters number of times indicated in new string
    //empty string if null

    @Test
    public void generateStringWithLengthLessThan3() {
        String expected = "ChChCh";
        String actual = subject.generateString("Ch", 3);
        assertEquals("Ch, 3 should produce ChChCh",expected, actual);
    }

    @Test
    public void generateStringWithLengthMoreThan3() {
        String expected = "ChoChoChoCho";
        String actual = subject.generateString("Chocolate", 4);
        assertEquals("Chocolate, 4 should produce ChoChoChoCho",expected, actual);
    }

    @Test
    public void generateStringWithNull() {
        String expected = "";
        String actual = subject.generateString("", 1);
        assertEquals("Null, 1 should produce empty string",expected, actual);
    }
}