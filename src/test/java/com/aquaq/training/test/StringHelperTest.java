package com.aquaq.training.test;

import com.aquaq.training.StringHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringHelperTest {

    String userString1;

    String userString2;

    StringHelper stringHelper = new StringHelper();

    private static PrintStream standardOut;
    private static ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        standardOut = System.out;
        System.setOut(standardOut);
    }

    @Test
    public void getReverseWordTest(){
        userString1 = "little";
        String reverseWord = "elttil";
        String expectedString = userString1 + " reversed is " + reverseWord + "\n";

        String actualString = stringHelper.getReverseWord(userString1);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void getHighestCharacterTests(){
        userString1 = "millennium";
        String highestChar = "m";
        String expectedString = "The highest occurring character in " + userString1 + " is " + highestChar + "\n";

        String actualString = stringHelper.getHighestCharacter(userString1);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void isAnagramTest(){
        userString1 = "inch";
        userString2 = "chin";
        String expectedString = userString1 + " and " + userString2 + " are Anagrams" + "\n";

        String actualString = stringHelper.isAnagram(userString1, userString2);

        assertEquals(expectedString,actualString);
    }

    @Test
    public void isNotAnagramTest(){
        userString1 = "inches";
        userString2 = "chins";
        String expectedString = userString1 + " and " + userString2 + " are not Anagrams" + "\n";

        String actualString = stringHelper.isAnagram(userString1, userString2);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void isPalindromeTest(){
        userString1 = "Was it a car or a cat I saw?";
        String expectedString = userString1 + " is a Palindrome" + "\n";

        String actualString = stringHelper.IsPalindrome(userString1);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void isNotPalindromeTest(){
        userString1 = "Was it a truck or a dog I saw!";
        String expectedString = userString1 + " is not a Palindrome" + "\n";

        String actualString = stringHelper.IsPalindrome(userString1);

        assertEquals(expectedString, actualString);
    }
}
