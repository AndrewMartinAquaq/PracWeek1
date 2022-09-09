package com.aquaq.training;

public class ReverseWord {

    public static void getReverseWord(String userWord) {
        System.out.println(userWord + " reversed is " + reverseGivenWord(userWord) + "\n");
    }

    public static String reverseGivenWord(String userWord){
        String reverseWord = "";
        int wordLength = userWord.length();

        for (int i = 0; i < wordLength; i++){
            reverseWord += userWord.substring(wordLength - i - 1, wordLength - i);
        }
        return reverseWord;
    }
}
