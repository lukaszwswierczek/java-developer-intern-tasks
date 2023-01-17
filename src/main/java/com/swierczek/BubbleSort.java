package com.swierczek;
//Exercise 1: Bubble sort
// Create a “com.swierczek.BubbleSort” class with one public method called “sort” (You can create other private methods) which has to sort numbers in accordance with the “Bubble sort” algorithm. method should receive List of Comparable (parameter name = “input”) method should return List of Comparable, but the numbers should be sorted ascending if the input is null then method should throw an exception if the input contains null value in list then method should omit this element Create a “BubbleSortTest” class and create test methods for below cases: input = [1,4,5,6,8,3,8] result = [1,3,4,5,6,8,8] input = [-9.3,0.2,4,0.1,5,9] result = [-9.3,0.1,0.2,4,5,9] input = [] result = [] input = [null,5.0001] result = [5.0001] input = null result = RuntimeException

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BubbleSort {

    public static <T extends Comparable<T>> List<T> sort(List<T> input) {

        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        List<T> inputNoNullElements = input.stream().filter(Objects::nonNull).collect(Collectors.toList());
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < inputNoNullElements.size() - 1; i++) {
                if (inputNoNullElements.get(i).compareTo((T) inputNoNullElements.get(i + 1)) > 0) {
                    swapped = true;
                    T temp = inputNoNullElements.get(i);
                    inputNoNullElements.set(i, inputNoNullElements.get(i + 1));
                    inputNoNullElements.set(i + 1, temp);
                }
            }
        }
        return inputNoNullElements;
    }
}