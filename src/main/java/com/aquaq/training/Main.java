package com.aquaq.training;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        String userWord = "";


        while(loop){
            System.out.println("Enter Which Option you would like to use: \n" +
                    "1. Find the max occurring char in a String.\n" +
                    "2. Check two Strings are anagrams of each other.\n" +
                    "3. Reverse an entered String\n" +
                    "4. Check if a string is a palindrome\n" +
                    "5. Exit\n");

            int option;

            try{
                option = scan.nextInt();
            }
            catch (InputMismatchException e){
                option = 0;
            }
            scan.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter word to get the highest occurring character\n");

                    userWord = scan.nextLine();

                    System.out.println("The highest occurring character in " + userWord + " is " + MaxChar(userWord) + "\n");
                    break;
                case 2:
                    System.out.println("Enter two words to check if they are anagrams of each other\n");
                    System.out.println("Enter first word\n");
                    userWord = scan.nextLine();

                    System.out.println("Enter second word\n");
                    String userWord2 = scan.nextLine();
                    if(CheckAnagram(userWord, userWord2)){
                        System.out.println(userWord + " and " + userWord2 + " are Anagrams\n");
                    }
                    else{
                        System.out.println(userWord + " and " + userWord2 + " are not Anagrams\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter word to reverse\n");

                    userWord = scan.nextLine();

                    System.out.println(userWord + " reversed is " + ReverseWord(userWord) + "\n");
                    break;
                case 4:
                    System.out.println("Enter word to check if its a palindrome\n");

                    userWord = scan.nextLine();
                    if(CheckPalindrome(userWord)){
                        System.out.println(userWord + " is a Palindrome\n");
                    }
                    else{
                        System.out.println(userWord + " is not a Palindrome\n");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1-5\n");
            }
        }
    }

    private static char MaxChar(String userWord){
        userWord = userWord.toLowerCase();
        userWord = userWord.replace(" ", "");
        int highestValue = 0;
        char highestChar = userWord.charAt(0);
        int counter = 0;


        for (int i = 0; i < userWord.length(); i++){
            char currentChar = userWord.charAt(i);

            for (int j = 0; j < userWord.length(); j++){
                if(currentChar == userWord.charAt(j)){
                    counter++;
                }
            }
            if(counter > highestValue){
                highestValue = counter;
                highestChar = currentChar;
            }
            userWord = userWord.replace(Character.toString(currentChar), "");
            counter = 0;
        }

        return highestChar;
    }

    private static boolean CheckAnagram(String userWord1, String userWord2){
        userWord1 = userWord1.toLowerCase();
        userWord1 = userWord1.replaceAll("[^a-z0-9]", "");
        userWord2 = userWord2.toLowerCase();
        userWord2 = userWord2.replaceAll("[^a-z0-9]", "");
        if(userWord1.length() != userWord2.length()){
            return false;
        }

        int counter1 = 0;
        int counter2 = 0;

        for (int i = 0; i < userWord1.length(); i++){
            char currentChar = userWord1.charAt(i);

            for (int j = 0; j < userWord1.length(); j++){
                if(currentChar == userWord1.charAt(j)){
                    counter1++;
                }
                if(currentChar == userWord2.charAt(j)){
                    counter2++;
                }
            }
            if(counter1 != counter2){
                return false;
            }
            userWord1 = userWord1.replace(Character.toString(currentChar), "");
            userWord2 = userWord2.replace(Character.toString(currentChar), "");
            counter1 = 0;
            counter2 = 0;
        }

        return true;
    }

    private static String ReverseWord(String userWord){

        String reverseWord = "";
        int wordLength = userWord.length();


        for (int i = 0; i < wordLength; i++){
            reverseWord += userWord.substring(wordLength - i - 1, wordLength - i);
        }
        return reverseWord;
    }

    private static boolean CheckPalindrome(String userWord){
        userWord = userWord.toLowerCase();
        userWord = userWord.replaceAll("[^a-z0-9]", "");
        String userWordRevered = ReverseWord(userWord);

        return userWord.equals(userWordRevered);
    }

}