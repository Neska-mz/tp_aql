package TP1.LineCoverageTest;

import TP1.Anagram;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo2Test {
    @Test
    public void testAnagram() {
        // Test cases that ensure all lines are executed
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
        
        assertTrue(Anagram.isAnagram("", ""));
        assertTrue(Anagram.isAnagram("chien", "niche"));
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
        
        assertFalse(Anagram.isAnagram("cat", "dog"));
        assertFalse(Anagram.isAnagram("cat", "cats"));
    }
} 