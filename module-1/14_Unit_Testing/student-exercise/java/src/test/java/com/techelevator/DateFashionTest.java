package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateFashionTest {
    private DateFashion subject;
    private int you;
    private int date;

    @Before
    public void setUp() throws Exception {
        subject = new DateFashion();
    }

    //One over 8 = 2/yes
    //One has 2 or less = 0/no
    //both over 2 and less than 8 = 1/maybe

    @Test
    public void getATableIfStyleOver8() {
        you = 8;
        date = 5;

        int expected = 2;
        int actual = subject.getATable(you, date);
        assertEquals("Should be 2/Yes",expected, actual);
    }

    @Test
    public void getATableIfStyle2OrLess() {
        you = 2;
        date = 5;

        int expected = 0;
        int actual = subject.getATable(you, date);
        assertEquals("Should be 0/no",expected, actual);
    }

    @Test
    public void getTableIfInStyleRange() {
        you = 3;
        date = 6;

        int expected = 1;
        int actual = subject.getATable(you, date);
        assertEquals("Should be 1/Maybe",expected, actual);
    }
}