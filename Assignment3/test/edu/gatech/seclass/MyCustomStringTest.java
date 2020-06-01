package edu.gatech.seclass;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * You should implement your tests in this class.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    /*** name="[countNumbers] First example in the interface documentation", number="Student Test 1" ***/
    public void testCountNumbersS1() {
        mycustomstring.setString("My numbers are 11, 96, and thirteen");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test
    /*** name="[countNumbers] Count the amount of integers in the string with a Decimal", number="Student Test 2" ***/
    public void testCountNumbersS2() {
        mycustomstring.setString("My numbers are 11 and 96.12");
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test 
    /*** name="[addNumber] First example in the interface documentation", number="Student Test 3" ***/
    public void testAddNumberS1() {
        mycustomstring.setString("hello 90, bye 2");
        assertEquals("hello 110, bye 22", mycustomstring.addNumber(20, false));
    }

    @Test
    /*** name="[addNumber] Add number to an integer in the string without reversing", number="Student Test 4" ***/
    public void testAddNumbersS2() {
        mycustomstring.setString("hi 1234567890");
        assertEquals("hi 1234567901", mycustomstring.addNumber(11, false));
    }

    @Test
    /*** name="[addNumber] Add number to an integer in the string and reverse that number", number="Student Test 5" ***/
    public void testAddNumbersS3() {
        mycustomstring.setString("hello 90, bye 2");
        assertEquals("hello 801, bye 02", mycustomstring.addNumber(18, true));

    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring] First example in the interface documentation", number="Student Test 6" ***/
    public void testConvertDigitsToNamesInSubstringS1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZEROme dONESIX1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring Example Test Case but String has no spaces", number="Student Test 7" ***/
    public void testConvertDigitsToNamesInSubstringS2() {
        mycustomstring.setString("abc416d");
        mycustomstring.convertDigitsToNamesInSubstring(2, 7);
        assertEquals("abcFOURONESIXd", mycustomstring.getString());
    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring] Test but outside the specification zone", number="Student Test 8" ***/
    public void testConvertDigitsToNamesInSubstringS3(){
        mycustomstring.setString("Lets try some 5igits but 8utside the 193specifications");
        mycustomstring.convertDigitsToNamesInSubstring(45, 47);
        assertEquals("Lets try some 5igits but 8utside the 193specifications", mycustomstring.getString());
    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring] Test but only integers", number="Student Test 9" ***/
    public void testConvertDigitsToNamesInSubstringS4() {
        mycustomstring.setString("1283745971902837401234");
        mycustomstring.convertDigitsToNamesInSubstring(1, 22);
        assertEquals("ONETWOEIGHTTHREESEVENFOURFIVENINESEVENONENINEZEROTWOEIGHTTHREESEVENFOURZEROONETWOTHREEFOUR", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class)
    /*** name="[convertDigitsToNamesInSubstring] Test where we make it fail purposely", number="Student Test 10" ***/
    public void testConvertDigitsToNamesInSubstringS5() {
        mycustomstring.setString("");
        mycustomstring.convertDigitsToNamesInSubstring(1, 45);
        assertEquals("Hello there, this is a string with no integers", mycustomstring.getString());
    }

}
