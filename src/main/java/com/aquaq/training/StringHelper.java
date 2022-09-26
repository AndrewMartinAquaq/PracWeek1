package com.aquaq.training;

public class StringHelper {

    public String getReverseWord(String userWord) {
        return userWord + " reversed is " + reverseGivenWord(userWord) + "\n";
    }

    public String getHighestCharacter(String userWord){
        return "The highest occurring character in " + userWord + " is " + maxChar(userWord) + "\n";
    }

    public String isAnagram(String userWord1, String userWord2){
        if(checkIfWordsAreAnagrams(userWord1, userWord2)){
            return userWord1 + " and " + userWord2 + " are Anagrams\n";
        }
        else{
            return userWord1 + " and " + userWord2 + " are not Anagrams\n";
        }
    }

    public String  IsPalindrome(String userWord){
        if(checkIfWordIsPalindrome(userWord)){
            return userWord + " is a Palindrome\n";
        }
        else{
            return userWord + " is not a Palindrome\n";
        }
    }

    private static boolean checkIfWordsAreAnagrams(String userWord1, String userWord2){
        userWord1 = userWord1.toLowerCase();
        userWord1 = userWord1.replaceAll("[^a-z0-9]", "");
        userWord2 = userWord2.toLowerCase();
        userWord2 = userWord2.replaceAll("[^a-z0-9]", "");


        if(userWord1.length() != userWord2.length()) return false;

        int counter1 = 0, counter2 = 0;

        return compareCharCount(userWord1, userWord2, counter1, counter2) ? true : false;
    }

    private static boolean compareCharCount(String userWord1, String userWord2, int counter1, int counter2) {
        for (int i = 0; i < userWord1.length(); i++){
            char currentChar = userWord1.charAt(i);

            for (int j = 0; j < userWord1.length(); j++){
                counter1 = iterateCounterIfCharsMatch(userWord1, counter1, currentChar, j);
                counter2 = iterateCounterIfCharsMatch(userWord2, counter2, currentChar, j);
            }
            if(counter1 != counter2) return false;

            userWord1 = userWord1.replace(Character.toString(currentChar), "");
            userWord2 = userWord2.replace(Character.toString(currentChar), "");
            counter1 = counter2 = 0;
        }
        return true;
    }

    private static int iterateCounterIfCharsMatch(String userWord, int counter, char currentChar, int i) {
        if(currentChar == userWord.charAt(i)){
            counter++;
        }
        return counter;
    }

    private static boolean checkIfWordIsPalindrome(String userWord){
        userWord = userWord.toLowerCase();
        userWord = userWord.replaceAll("[^a-z0-9]", "");
        double lengthDouble = Math.ceil(userWord.length() / 2);
        int wordLength = (int)lengthDouble;
        for (int i = 0; i < wordLength; i++){
            String wordEnd = userWord.substring(userWord.length() - i - 1, userWord.length() - i);
            if(!userWord.substring(i, i + 1).equals(wordEnd)){
                return false;
            }
        }

        return true;
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

            counter = countMatchingChars(userWord, counter, currentChar);
            if(counter > highestValue){
                highestValue = counter;
                highestChar = currentChar;
            }
            userWord = userWord.replace(Character.toString(currentChar), "");
            counter = 0;
        }
        return highestChar;
    }

    private static int countMatchingChars(String userWord, int counter, char currentChar) {
        for (int j = 0; j < userWord.length(); j++){
            counter = iterateCounterIfCharsMatch(userWord, counter, currentChar, j);
        }
        return counter;
    }

    private static String reverseGivenWord(String userWord){
        String reverseWord = "";
        int wordLength = userWord.length();

        for (int i = 0; i < wordLength; i++){
            reverseWord += userWord.substring(wordLength - i - 1, wordLength - i);
        }
        return reverseWord;
    }
}
