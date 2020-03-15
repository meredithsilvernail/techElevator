package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TellerMachineTest {

    private TellerMachine subject;

    @Before
    public void setUp() throws Exception {
        subject = new TellerMachine("Subject", new BigDecimal(100.00), new BigDecimal(50.00));
    }

    @Test
    public void getBalance() {
        BigDecimal expected = new BigDecimal(50.00);
        BigDecimal actual = subject.getBalance();
        assertEquals(expected,actual);
    }

    @Test
    public void isCardValidStarts5and16digits(){
        assertTrue(subject.isCardValid("5555555555555555"));
    }

    @Test
    public void isCardValidStarts4and13or16digits(){
        assertTrue(subject.isCardValid("4555555555555555"));
        assertTrue(subject.isCardValid("4555555555555"));
    }

    @Test
    public void isCardValidStarts34or37(){
        assertTrue(subject.isCardValid("3400001234"));
        assertTrue(subject.isCardValid("3700123"));
    }

    @Test
    public void isCardValidNonValidCardNumber(){
        assertFalse(subject.isCardValid("123"));
    }



}