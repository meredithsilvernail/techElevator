package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SameFirstLastTest {
    private SameFirstLast subject;
    int[] testArray;

    @Before
    public void setUp() throws Exception {
        subject = new SameFirstLast();
    }

    @Test
    public void isItTheSameWithDifferentNumbers() {
        testArray = new int[]{1,2,3};
        assertFalse(subject.isItTheSame(testArray));
    }

    @Test
    public void isItTheSameWithMatchingNums() {
        testArray = new int[]{1,2,1};
        assertTrue(subject.isItTheSame(testArray));
    }

    @Test
    public void isItTheSameNull() {
        assertFalse(subject.isItTheSame(testArray));
    }


}