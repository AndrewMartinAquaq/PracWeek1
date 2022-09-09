package com.aquaq.training;

public class CheckPalindrome {

    public static void IsPalindrome(String userWord){
        if(compareWord(userWord)){
            System.out.println(userWord + " is a Palindrome\n");
        }
        else{
            System.out.println(userWord + " is not a Palindrome\n");
        }
    }

    private static boolean compareWord(String userWord){
        userWord = userWord.toLowerCase();
        userWord = userWord.replaceAll("[^a-z0-9]", "");
        String userWordRevered = ReverseWord.reverseGivenWord(userWord);

        return userWord.equals(userWordRevered);
    }
}
