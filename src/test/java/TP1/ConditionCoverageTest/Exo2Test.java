package TP1.ConditionCoverageTest;

import TP1.Anagram;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo2Test {
    @Test
    public void testAnagramConditions() {
        // Test cases that ensure all conditions are covered
        
        // Null conditions
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));  // s1 null, s2 not null
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));  // s1 not null, s2 null
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));    // both null
        
        // Empty string conditions
        assertTrue(Anagram.isAnagram("", ""));  // both empty
        assertFalse(Anagram.isAnagram("", "a")); // s1 empty, s2 not empty
        assertFalse(Anagram.isAnagram("a", "")); // s1 not empty, s2 empty
        
        // Length conditions
        assertFalse(Anagram.isAnagram("cat", "cats"));    // s1 shorter
        assertFalse(Anagram.isAnagram("cats", "cat"));    // s1 longer
        assertTrue(Anagram.isAnagram("cat", "act"));      // same length, anagram
        assertFalse(Anagram.isAnagram("cat", "dog"));     // same length, not anagram
        
        // Case sensitivity conditions
        assertTrue(Anagram.isAnagram("Listen", "Silent"));  // mixed case
        assertTrue(Anagram.isAnagram("LISTEN", "SILENT"));  // all uppercase
        assertTrue(Anagram.isAnagram("listen", "silent"));  // all lowercase
        
        // Special characters conditions
        assertTrue(Anagram.isAnagram("Dormitory", "Dirty room"));  // with spaces
        assertTrue(Anagram.isAnagram("School master", "The classroom"));  // with spaces and different lengths
        assertTrue(Anagram.isAnagram("A decimal point", "I'm a dot in place"));  // with punctuation
        
        // Character frequency conditions
        assertTrue(Anagram.isAnagram("aabbcc", "ccbbaa"));  // multiple occurrences
        assertFalse(Anagram.isAnagram("aabbcc", "aabbc"));  // different frequencies
        assertFalse(Anagram.isAnagram("aabbcc", "aabbcd")); // different characters
    }
} 