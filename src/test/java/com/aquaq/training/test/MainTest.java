package com.aquaq.training.test;

import com.aquaq.training.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


//@ExtendWith(MockitoExtension.class)
public class MainTest {

    String userString1;

    String userString2;

    private static final PrintStream standardOut = System.out;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUp() {

        System.setOut(new PrintStream(outputStreamCaptor));

    }

    @Test
    public void testMainOption1(){
        userString1 = "millennium";
        String highestChar = "m";
        String expectedString = "The highest occurring character in " + userString1 + " is " + highestChar;

        String input = "1\n" + userString1 + "\n5\n";


        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);


        Main.main(null);

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


        Main.main(null);

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


        Main.main(null);

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


        Main.main(null);

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
}
