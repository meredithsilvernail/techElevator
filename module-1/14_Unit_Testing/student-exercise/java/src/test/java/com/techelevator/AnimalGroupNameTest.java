package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    private AnimalGroupName subject;

    @Before
    public void setUp() throws Exception {
        subject = new AnimalGroupName();
    }

    @Test
    public void getHerdShouldReturnCorrectTerm() {
        String expected = "Crash";
        String actual = subject.getHerd("rhino");
        assertEquals("Should be Crash", expected, actual);
    }

    @Test
    public void getHerdShouldReturnUnknown(){
        String expected = "unknown";
        String actual = subject.getHerd("banana");
        assertEquals("Should be Unknown", expected, actual);
    }

    @Test
    public void getHerdShouldReturnUnknownIfNull(){
        String expected = "unknown";
        String actual = subject.getHerd(null);
        assertEquals("Should be Unknown", expected, actual);
    }

    @Test
    public void getHerdShouldAcceptMixedCase(){
        String expected = "Tower";
        String actual = subject.getHerd("GiRaFFe");
        assertEquals("Should be Tower", expected, actual);
    }
}