package com.aquaq.training;

public class MaxCharacter {

    public static void getHighestCharacter(String userWord){
        System.out.println("The highest occurring character in " + userWord + " is " + maxChar(userWord) + "\n");
    }

    private static char maxChar(String userWord){
        userWord = userWord.toLowerCase();
        userWord = userWord.replace(" ", "");
        char highestChar = userWord.charAt(0);
        int counter = 0, highestValue = 0;
        
        return getHighestChar(userWord, highestChar, counter, highestValue);
    }

    private static char getHighestChar(String userWord, char highestChar, int counter, int highestValue) {
        for (int i = 0; i < userWord.length(); i++){
            char currentChar = userWord.charAt(i);

            counter = countChars(userWord, counter, currentChar);
            if(counter > highestValue){
                highestValue = counter;
                highestChar = currentChar;
            }
            userWord = userWord.replace(Character.toString(currentChar), "");
            counter = 0;
        }
        return highestChar;
    }

    private static int countChars(String userWord, int counter, char currentChar) {
        for (int j = 0; j < userWord.length(); j++){
            counter = CheckAnagram.countChar(userWord, counter, currentChar, j);
        }
        return counter;
    }
}
