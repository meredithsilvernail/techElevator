package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {
    private Lucky13 subject;
    private int[] numbers;

    @Before
    public void setUp() throws Exception {
        subject = new Lucky13();
        numbers = new int[3];

    }

    //true if array has no 1's or 3's
    //false if array has 1 or 3

    @Test
    public void getLuckyHasNoOneOrThree() {
        numbers[0] = 0;
        numbers[1] = 2;
        numbers[2] = 4;

        assertTrue(subject.getLucky(numbers));
    }

    @Test
    public void getLuckyHasOneOrThree() {
        numbers[0] = 0;
        numbers[1] = 1;
        numbers[2] = 3;

        assertFalse(subject.getLucky(numbers));
    }

    @Test
    public void getLuckyIsNull() {

        assertTrue(subject.getLucky(numbers));
    }
}