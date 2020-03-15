package com.techelevator.biz;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class YardSaleManagerTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {-1, "negative one"},
                {0, "zero"},
                {1, "one"},
                {2, "two"},
                {4, "four"}
        });
    }

    private YardSaleManager subject;
    private final int number;
    private final String expectedResult;

    public YardSaleManagerTest(int number, String expectedResult){
        this.subject = new YardSaleManager();
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Test
    public void numberToWord() {
        assertEquals(expectedResult, subject.numberToWord(number));
    }
}