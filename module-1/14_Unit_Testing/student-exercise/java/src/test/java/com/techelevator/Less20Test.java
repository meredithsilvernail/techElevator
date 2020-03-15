package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {
    private Less20 subject;
    private int number;

    @Before
    public void setUp() throws Exception {
        subject = new Less20();
    }

    //number is 1 or 2 less than a multiple of 20
    //number is not 1 or 2 less than multiple of 20
    @Test
    public void isLessThanMultipleOf20With18() {
        number = 18;
        assertTrue(subject.isLessThanMultipleOf20(number));
    }

    @Test
    public void isLessThanMultipleOf20With20() {
        number = 20;
        assertFalse(subject.isLessThanMultipleOf20(number));
    }
}