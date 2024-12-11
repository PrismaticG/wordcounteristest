package com.example.wordcounter;

import static org.junit.Assert.assertEquals;

import com.example.wordcounter.utils.TextCounter;

import org.junit.Test;

public class WordCounterUnitTest {

    @Test
    public void testCountWords() {
        int result = TextCounter.getWordsCount("Hello world!");
        assertEquals(2, result);
    }

    @Test
    public void testCountEmptyString() {
        int result = TextCounter.getWordsCount("");
        assertEquals(0, result);
    }

    @Test
    public void testCountPunctuation() {
        int result = TextCounter.getWordsCount("Hello, world!");
        assertEquals(2, result);
    }
}
