package TP1.ConditionCoverageTest;

import TP1.RomanNumeral;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo5Test {
    @Test
    public void testRomanNumeralConditions() {
        // Test cases that ensure all conditions are covered
        
        // Boundary conditions
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
        
        // Conditions for each symbol
        assertEquals("I", RomanNumeral.toRoman(1));    // Single I
        assertEquals("II", RomanNumeral.toRoman(2));   // Multiple I
        assertEquals("IV", RomanNumeral.toRoman(4));   // I before V
        assertEquals("V", RomanNumeral.toRoman(5));    // Single V
        assertEquals("VI", RomanNumeral.toRoman(6));   // V followed by I
        assertEquals("IX", RomanNumeral.toRoman(9));   // I before X
        assertEquals("X", RomanNumeral.toRoman(10));   // Single X
        assertEquals("XL", RomanNumeral.toRoman(40));  // X before L
        assertEquals("L", RomanNumeral.toRoman(50));   // Single L
        assertEquals("XC", RomanNumeral.toRoman(90));  // X before C
        assertEquals("C", RomanNumeral.toRoman(100));  // Single C
        assertEquals("CD", RomanNumeral.toRoman(400)); // C before D
        assertEquals("D", RomanNumeral.toRoman(500));  // Single D
        assertEquals("CM", RomanNumeral.toRoman(900)); // C before M
        assertEquals("M", RomanNumeral.toRoman(1000)); // Single M
        
        // Complex conditions
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999)); // Maximum valid number
        assertEquals("MCMXC", RomanNumeral.toRoman(1990));     // Complex combination
    }
} 