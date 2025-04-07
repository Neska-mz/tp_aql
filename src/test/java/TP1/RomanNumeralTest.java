package TP1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0)); // Condition: n < 1 true
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000)); // Condition: n > 3999 true
    }

    @Test
    void testValidNumbers() {
        assertEquals("I", RomanNumeral.toRoman(1)); // Line: while loop; Branch: n >= values[i] true then false
        assertEquals("XLIX", RomanNumeral.toRoman(49)); // Line: sb.append; Branch: same
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999)); // Line: for loop; Branch: same
    }
}
