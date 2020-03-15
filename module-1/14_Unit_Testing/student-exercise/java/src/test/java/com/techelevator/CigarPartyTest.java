package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {

    private CigarParty subject;
    private int cigars;
    private boolean isWeekend;

    @Before
    public void setUp() throws Exception {
        subject = new CigarParty();
    }

    //cigar party success: cigars between 40 - 60
    //if weekend success: cigars 40+


    @Test
    public void havePartyOnWeekdayWhenCigarsInRange() {
        cigars = 50;
        isWeekend = false;

        assertTrue(subject.haveParty(cigars, isWeekend));


    }

    @Test
    public void havePartyOnWeekendWhenCigarsInRange() {
        cigars = 50;
        isWeekend = true;

        assertTrue(subject.haveParty(cigars, isWeekend));
    }

    @Test
    public void havePartyOnWeekdayWithTooFewCigars() {
        cigars = 5;
        isWeekend = false;

        assertFalse(subject.haveParty(cigars, isWeekend));
    }

    @Test
    public void havePartyOnWeekendWithTooFewCigars() {
        cigars = 5;
        isWeekend = true;

        assertFalse(subject.haveParty(cigars, isWeekend));
    }

    @Test
    public void havePartyOnWeekendWithManyCigars() {
        cigars = 500;
        isWeekend = true;

        assertTrue(subject.haveParty(cigars, isWeekend));
    }
}