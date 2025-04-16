package TP1.LineCoverageTest;

import TP1.Palindrome;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo1Test {
    @Test
    public void testPalindrome() {
        // Test cases that ensure all lines are executed
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
        assertTrue(Palindrome.isPalindrome(""));
        assertTrue(Palindrome.isPalindrome("a"));
        assertTrue(Palindrome.isPalindrome("kayak"));
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
        assertFalse(Palindrome.isPalindrome("hello"));
    }
}