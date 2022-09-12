package com.aquaq.training;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        String userWord = "";

        do{
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
                    StringHelper.getHighestCharacter(userWord);
                    break;
                case 2:
                    System.out.println("Enter two words to check if they are anagrams of each other\n");
                    System.out.println("Enter first word\n");
                    userWord = scan.nextLine();

                    System.out.println("Enter second word\n");
                    String userWord2 = scan.nextLine();
                    StringHelper.isAnagram(userWord, userWord2);
                    break;
                case 3:
                    System.out.println("Enter word to reverse\n");
                    userWord = scan.nextLine();
                    StringHelper.getReverseWord(userWord);
                    break;
                case 4:
                    System.out.println("Enter word to check if its a palindrome\n");
                    userWord = scan.nextLine();
                    StringHelper.IsPalindrome(userWord);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input, please enter a number from 1-5\n");
            }
        }
        while (loop);
    }
}