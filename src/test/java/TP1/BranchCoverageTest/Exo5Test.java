package TP1.BranchCoverageTest;

import TP1.RomanNumeral;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo5Test {
    @Test
    public void testRomanNumeralBranches() {
        // Test cases that ensure all branches are covered
        
        // Invalid input branches
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
        
        // Single symbol branches
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("V", RomanNumeral.toRoman(5));
        
        // Multiple symbol branches
        assertEquals("III", RomanNumeral.toRoman(3));
        assertEquals("VIII", RomanNumeral.toRoman(8));
        
        // Subtraction branches
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        
        // Complex number branches
        assertEquals("XLV", RomanNumeral.toRoman(45));
        assertEquals("XCIX", RomanNumeral.toRoman(99));
        assertEquals("CDXCIX", RomanNumeral.toRoman(499));
        assertEquals("CMXCIX", RomanNumeral.toRoman(999));
    }
} 