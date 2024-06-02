package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isPalindrome() {
        boolean result =  StringUtils.isPalindrome("racecar");
        assertEquals(true,result);
        result =  StringUtils.isPalindrome("rote");
        assertEquals(false,result);
        result =  StringUtils.isPalindrome("rote");
        assertEquals(false,result);
    }
    @Test
    void isPalindromeAllCase() {
        boolean result =  StringUtils.isPalindrome("RACECAR");
        assertEquals(true,result);
        result =  StringUtils.isPalindrome("ROTE");
        assertEquals(false,result);
    }
    @Test
    void isPalindromeMixCase() {
        boolean result =  StringUtils.isPalindrome("RacecAr");
        assertEquals(true,result);
        result =  StringUtils.isPalindrome("roTE");
        assertEquals(false,result);
    }
    @Test
    void isPalindromeStringNull() {
        boolean result =  StringUtils.isPalindrome(null);
        assertEquals(false,result);
    }
    @Test
    void isPalindromeStringIsEmpty() {
        boolean result =  StringUtils.isPalindrome("");
        assertEquals(false,result);
    }
    @Test
    void isPalindromeStringIsBlank() {
        boolean result =  StringUtils.isPalindrome("   ");
        assertEquals(false,result);
    }
    @Test
    void isPalindromeSpecial() {
        boolean result =  StringUtils.isPalindrome("race-car");
        assertEquals(false,result);
        result =  StringUtils.isPalindrome("race car");
        assertEquals(false,result);
    }
}