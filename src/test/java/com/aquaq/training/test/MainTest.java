package com.aquaq.training.test;

import com.aquaq.training.Main;
import com.aquaq.training.StringHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


public class MainTest {

    String userString1;
    String userString2;
    private static PrintStream standardOut;
    private static ByteArrayOutputStream outputStreamCaptor;

    @Mock
    StringHelper stringHelperMock;


    @BeforeEach
    public void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        stringHelperMock = mock(StringHelper.class);
    }

    @AfterEach
    public void tearDown() {
        standardOut = System.out;
        System.setOut(standardOut);
    }

    @Test
    public void testMainOption1(){
        userString1 = "millennium";
        String highestChar = "m";
        String expectedString = "The highest occurring character in " + userString1 + " is " + highestChar;

        String input = "1\n" + userString1 + "\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        when(stringHelperMock.getHighestCharacter(anyString())).thenReturn(expectedString);

        Main.stringHelper = stringHelperMock;

        Main.main(null);

        verify(stringHelperMock, times(1)).getHighestCharacter(anyString());

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString));

        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testMainOption2(){
        userString1 = "inch";
        userString2 = "chin";
        String expectedString = userString1 + " and " + userString2 + " are Anagrams";

        String input = "2\n" + userString1 + "\n" + userString2 + "\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        when(stringHelperMock.isAnagram(anyString(), anyString())).thenReturn(expectedString);

        Main.stringHelper = stringHelperMock;

        Main.main(null);

        verify(stringHelperMock, times(1)).isAnagram(anyString(), anyString());

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString));

        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testMainOption3(){
        userString1 = "little";
        String reverseWord = "elttil";
        String expectedString = userString1 + " reversed is " + reverseWord;

        String input = "3\n" + userString1 + "\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        when(stringHelperMock.getReverseWord(anyString())).thenReturn(expectedString);

        Main.stringHelper = stringHelperMock;

        Main.main(null);

        verify(stringHelperMock, times(1)).getReverseWord(anyString());

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString));

        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testMainOption4(){
        userString1 = "Was it a car or a cat I saw?";
        String expectedString = userString1 + " is a Palindrome";

        String input = "4\n" + userString1 + "\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        when(stringHelperMock.IsPalindrome(anyString())).thenReturn(expectedString);

        Main.stringHelper = stringHelperMock;

        Main.main(null);

        verify(stringHelperMock, times(1)).IsPalindrome(anyString());

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString));

        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testMainOption5(){

        String input = "5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        Main.main(null);


        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testMainDefaultNotNumber(){

        String expectedString = "Invalid input, please enter a number from 1-5";

        String input = "not a number\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        Main.main(null);

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString));

        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testMainDefaultNumber(){

        String expectedString = "Invalid input, please enter a number from 1-5";

        String input = "7r\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        Main.main(null);

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString));

        assertTrue(outputStreamCaptor.toString()
                .trim().endsWith("Exiting..."));
    }

    @Test
    public void testEndToEnd(){
        String input = "1\nmillennium\n2\nchin\nitch\n3\nlittle\n4\nWas it a car or a cat I saw?\n5\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String expectedString1 = "The highest occurring character in millennium is m";
        String expectedString2 = "chin and inch are Anagrams";
        String expectedString3 = "little reversed is elttil";
        String expectedString4 = "Was it a car or a cat I saw? is a Palindrome";

        when(stringHelperMock.getHighestCharacter(anyString())).thenReturn(expectedString1);
        when(stringHelperMock.isAnagram(anyString(), anyString())).thenReturn(expectedString2);
        when(stringHelperMock.getReverseWord(anyString())).thenReturn(expectedString3);
        when(stringHelperMock.IsPalindrome(anyString())).thenReturn(expectedString4);

        Main.stringHelper = stringHelperMock;
        Main.main(null);

        verify(stringHelperMock, times(1)).getHighestCharacter(anyString());
        verify(stringHelperMock, times(1)).isAnagram(anyString(), anyString());
        verify(stringHelperMock, times(1)).getReverseWord(anyString());
        verify(stringHelperMock, times(1)).IsPalindrome(anyString());

        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString1));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString2));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString3));
        assertTrue(outputStreamCaptor.toString()
                .trim().contains(expectedString4));

    }
}
