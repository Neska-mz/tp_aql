package TP1.BranchCoverageTest;

import TP1.Palindrome;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo1Test {
    @Test
    public void testPalindromeBranches() {
        // Test cases that ensure all branches are covered

        // Null input branch
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));

        // Empty string branch
        assertTrue(Palindrome.isPalindrome(""));

        // Single character branch
        assertTrue(Palindrome.isPalindrome("a"));

        // Even length palindrome branch
        assertTrue(Palindrome.isPalindrome("abba"));
        assertTrue(Palindrome.isPalindrome("noon"));

        // Odd length palindrome branch
        assertTrue(Palindrome.isPalindrome("kayak"));
        assertTrue(Palindrome.isPalindrome("radar"));

        // Non-palindrome branches
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("world"));

        // Case sensitivity branch
        assertTrue(Palindrome.isPalindrome("Kayak"));
        assertTrue(Palindrome.isPalindrome("Racecar"));

        // Whitespace branch
        assertTrue(Palindrome.isPalindrome("A man a plan a canal Panama"));
        assertTrue(Palindrome.isPalindrome("Was it a car or a cat I saw"));
    }
}