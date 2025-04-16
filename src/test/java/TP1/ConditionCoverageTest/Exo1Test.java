package TP1.ConditionCoverageTest;

import TP1.Palindrome;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo1Test {
    @Test
    public void testPalindromeConditions() {
        // Test cases that ensure all conditions are covered
        
        // Null condition
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
        
        // Empty string conditions
        assertTrue(Palindrome.isPalindrome(""));  // Empty string
        assertTrue(Palindrome.isPalindrome(" ")); // Single space
        assertTrue(Palindrome.isPalindrome("  ")); // Multiple spaces
        
        // Single character conditions
        assertTrue(Palindrome.isPalindrome("a"));  // Lowercase
        assertTrue(Palindrome.isPalindrome("A"));  // Uppercase
        assertTrue(Palindrome.isPalindrome("1"));  // Number
        assertTrue(Palindrome.isPalindrome("!"));  // Special character
        
        // Even length conditions
        assertTrue(Palindrome.isPalindrome("abba"));     // All lowercase
        assertTrue(Palindrome.isPalindrome("ABBA"));     // All uppercase
        assertTrue(Palindrome.isPalindrome("AbBa"));     // Mixed case
        assertFalse(Palindrome.isPalindrome("abca"));    // Not palindrome
        assertTrue(Palindrome.isPalindrome("a b b a"));  // With spaces
        assertTrue(Palindrome.isPalindrome("a!b!b!a"));  // With special characters
        
        // Odd length conditions
        assertTrue(Palindrome.isPalindrome("kayak"));     // All lowercase
        assertTrue(Palindrome.isPalindrome("KAYAK"));     // All uppercase
        assertTrue(Palindrome.isPalindrome("KaYaK"));     // Mixed case
        assertFalse(Palindrome.isPalindrome("kayak!"));   // Not palindrome
        assertTrue(Palindrome.isPalindrome("k a y a k")); // With spaces
        assertTrue(Palindrome.isPalindrome("k!a!y!a!k")); // With special characters
        
        // Case sensitivity conditions
        assertTrue(Palindrome.isPalindrome("Kayak"));    // First letter uppercase
        assertTrue(Palindrome.isPalindrome("kayaK"));    // Last letter uppercase
        assertTrue(Palindrome.isPalindrome("KaYaK"));    // Mixed case
        
        // Whitespace conditions
        assertTrue(Palindrome.isPalindrome("A man a plan a canal Panama"));  // Multiple words
        assertTrue(Palindrome.isPalindrome("Was it a car or a cat I saw"));  // Multiple words with spaces
        assertFalse(Palindrome.isPalindrome("A man, a plan, a canal: Panama")); // With punctuation
        
        // Special character conditions
        assertFalse(Palindrome.isPalindrome("A man, a plan, a canal: Panama!")); // With punctuation
        assertFalse(Palindrome.isPalindrome("Madam, I'm Adam"));  // With apostrophe
        assertTrue(Palindrome.isPalindrome("Able was I ere I saw Elba"));  // With spaces and case
    }
} 