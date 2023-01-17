package com.swierczek;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.swierczek.BubbleSort.sort;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    //input = [1,4,5,6,8,3,8] result = [1,3,4,5,6,8,8]
    @Test
    public void testSortIntegers() {
        List<Integer> input = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        List<Integer> expected = Arrays.asList(1, 3, 4, 5, 6, 8, 8);
        assertEquals(expected, sort(input));
    }

    //input = [-9.3,0.2,4,0.1,5,9] result = [-9.3,0.1,0.2,4,5,9]
    @Test
    public void testSortDecimals() {
        List<Double> input = Arrays.asList(-9.3, 0.2, 4.0, 0.1, 5.0, 9.0);
        List<Double> expected = Arrays.asList(-9.3, 0.1, 0.2, 4.0, 5.0, 9.0);
        assertEquals(expected, sort(input));
    }

    //input = [] result = []
    @Test
    public void testEmptyList() {
        List<Double> input = new ArrayList<>();
        List<Double> expected = new ArrayList<>();
        assertEquals(expected, sort(input));
    }

    //input = [null,5.0001] result = [5.0001]
    @Test
    public void testNullAndDecimal() {
        List<Double> input = Arrays.asList(null, 5.0001);
        List<Double> expected = Arrays.asList(5.0001);
        assertEquals(expected, sort(input));
    }

    //input = null result = RuntimeException
    @Test
    public void testNullInput() {
        assertThrows(RuntimeException.class, () -> sort(null));
    }
}