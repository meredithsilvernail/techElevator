package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {
    private MaxEnd3 subject;
    private int[] testArray;

    @Before
    public void setUp() throws Exception {
        subject = new MaxEnd3();
        testArray = new int[3];
    }

    //array sets all elements to the larger of 1st and last number

    @Test
    public void makeArrayFirstNumHigh() {
        testArray[0] = 11;
        testArray[1] = 5;
        testArray[2] = 9;
        int[] expected = new int[] {11,11,11};
        int[] actual = subject.makeArray(testArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void makeArrayLastNumHigh() {
        testArray[0] = 9;
        testArray[1] = 5;
        testArray[2] = 15;
        int[] expected = new int[] {15,15,15};
        int[] actual = subject.makeArray(testArray);
        assertArrayEquals(expected, actual);
    }
}