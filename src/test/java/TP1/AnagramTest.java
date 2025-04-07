package TP1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    @Test
    void testNullInputs() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test")); // Condition: s1 == null true, s2 == null false
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null)); // Condition: s1 == null false, s2 == null true
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null)); // Condition: s1 == null true, s2 == null true
    }

    @Test
    void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", "")); // Line: for loop skipped; Branch: s1.length() != s2.length() false
    }

    @Test
    void testAnagrams() {
        assertTrue(Anagram.isAnagram("chien", "niche")); // Line: for loops, return true; Branch: c != 0 false
        assertTrue(Anagram.isAnagram("Listen", "Silent")); // Line: replaceAll("[^a-z]"); Branch: same
    }

    @Test
    void testNonAnagrams() {
        assertFalse(Anagram.isAnagram("cat", "dog")); // Line: return false (c != 0); Branch: c != 0 true
    }

    @Test
    void testDifferentLengths() {
        assertFalse(Anagram.isAnagram("cat", "cats")); // Line: return false (length); Branch: s1.length() != s2.length() true
    }
}