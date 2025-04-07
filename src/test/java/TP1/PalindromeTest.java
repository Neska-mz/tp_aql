package TP1;
// TP1/Exo1Test.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome("")); // Line: s.toLowerCase(), i < j false; Branch: i < j false
    }

    @Test
    void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a")); // Line: s.length() - 1; Branch: i < j false
    }

    @Test
    void testPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak")); // Line: while loop, i++, j--; Branch: i < j true, s.charAt(i) != s.charAt(j) false
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose")); // Line: replaceAll("\\s+"); Branch: same
    }

    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello")); // Line: return false; Branch: s.charAt(i) != s.charAt(j) true
    }
}

