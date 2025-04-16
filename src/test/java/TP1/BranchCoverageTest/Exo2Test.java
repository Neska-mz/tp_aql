package TP1.BranchCoverageTest;

import TP1.Anagram;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo2Test {
    @Test
    public void testAnagramBranches() {
        // Test cases that ensure all branches are covered
        
        // Null input branches
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
        
        // Empty string branches
        assertTrue(Anagram.isAnagram("", ""));
        
        // Different length branches
        assertFalse(Anagram.isAnagram("cat", "cats"));
        assertFalse(Anagram.isAnagram("cats", "cat"));
        
        // Anagram branches
        assertTrue(Anagram.isAnagram("chien", "niche"));
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
        assertTrue(Anagram.isAnagram("Dormitory", "Dirty room"));
        
        // Non-anagram branches
        assertFalse(Anagram.isAnagram("cat", "dog"));
        assertFalse(Anagram.isAnagram("hello", "world"));
        assertFalse(Anagram.isAnagram("test", "tests"));
    }
} 