package com.aquaq.training;

public class CheckAnagram {

    public static void isAnagram(String userWord1, String userWord2){
        if(compareWords(userWord1, userWord2)){
            System.out.println(userWord1 + " and " + userWord2 + " are Anagrams\n");
        }
        else{
            System.out.println(userWord1 + " and " + userWord2 + " are not Anagrams\n");
        }
    }

    private static boolean compareWords(String userWord1, String userWord2){
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
                counter1 = countChar(userWord1, counter1, currentChar, j);
                counter2 = countChar(userWord2, counter2, currentChar, j);
            }
            if(counter1 != counter2) return false;

            userWord1 = userWord1.replace(Character.toString(currentChar), "");
            userWord2 = userWord2.replace(Character.toString(currentChar), "");
            counter1 = counter2 = 0;
        }
        return true;
    }

    public static int countChar(String userWord, int counter, char currentChar, int i) {
        if(currentChar == userWord.charAt(i)){
            counter++;
        }
        return counter;
    }
}
