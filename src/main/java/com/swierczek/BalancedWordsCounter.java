package com.swierczek;
//Exercise 2: Balanced words counter
// Balanced words definition: The word is balanced if every letter that occurs in it occurs in the same number of time. E.g. the words: “mama”, “ear”, “aabbcbcccbaa” are balanced but the words “dad”, “elephant”, “abcba” are not. Additionally, the balanced word is not empty. Create a “BalancedWordsCounter” class with one public method called “count” (you can create other private methods) which has to count how many balanced subwords exist in the input word. method should receive String (parameter name = “input”) method should return Integer the input should contain the letters only, throw an exception if the text contains other characters. if the input is null then method should throw an exception Create a “BalancedWordsCounterTest” and create a test methods for below cases: input = “aabbabcccba” result = 28 input = “” result = 0 input = “abababa1” result = RuntimeException input = null result = RuntimeException

import java.util.HashMap;

public class BalancedWordsCounter {

    public static int count(String input) {

        if(input == null){
            throw new IllegalArgumentException("Input cannot be null");
        }
        if (!input.matches("$|[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input must contain letters only");
        }

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String subword = input.substring(i, j);
                if (isBalanced(subword)) {
                    count++;
                }
            }
        }
        System.out.println("Balanced subwords: " + count);
        return count;
    }

    private static boolean isBalanced(String input) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        int count = charCount.get(input.charAt(0));
        for (char c : charCount.keySet()) {
            if (charCount.get(c) != count) {
                return false;
            }
        }
        return true;
    }
}