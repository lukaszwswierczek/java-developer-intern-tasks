package com.swierczek;

import org.junit.jupiter.api.Test;
import static com.swierczek.BalancedWordsCounter.count;
import static org.junit.jupiter.api.Assertions.*;

class BalancedWordsCounterTest {

    //input = “aabbabcccba” result = 28
    @Test
    void testCountString() {
        String input = "aabbabcccba";
        int expected = 28;
        int result = count(input);
        assertEquals(expected, result);
    }

    //    input = “” result = 0
    @Test
    void testCountEmptyString() {
        String input = "";
        int expected = 0;
        int result = count(input);
        assertEquals(expected, result);
    }

    //    input = “abababa1” result = RuntimeException
    @Test
    void testCountIllegalCharacter() {
        assertThrows(RuntimeException.class, () -> count("abababa1"));
    }

    //    input = null result = RuntimeException
    @Test
    void testCountNull() {
        assertThrows(RuntimeException.class, () -> count(null));
    }
}