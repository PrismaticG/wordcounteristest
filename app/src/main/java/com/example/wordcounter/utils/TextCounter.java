package com.example.wordcounter.utils;

public class TextCounter {
    public static int getCharsCount(String userInput){
        return userInput.length();
    }
    public static int getWordsCount(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return 0;
        }
        String[] words = userInput.trim().split("\\s+|,|\\.");
        return words.length;
    }
}

