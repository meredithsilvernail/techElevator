package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {
    private WordCount subject;
    String[] words;

    @Before
    public void setUp() throws Exception {
        subject = new WordCount();

    }

    @Test
    public void getCountWithFullMap() {
        words = new String[]{"ba", "ba", "black", "sheep"};

        Map<String,Integer> actual = subject.getCount(words);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("ba", 2);
        expected.put("black", 1);
        expected.put("sheep", 1);

        assertEquals(expected, actual);

    }

    @Test
    public void getCountNull(){
        words = null;
        Map<String, Integer> expected = new HashMap<>();
        Map<String, Integer> actual = subject.getCount(words);
        assertEquals(expected,actual);
    }
}