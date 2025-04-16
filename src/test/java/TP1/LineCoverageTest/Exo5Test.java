package TP1.LineCoverageTest;

import TP1.RomanNumeral;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo5Test {
    @Test
    public void testRomanNumeral() {
        // Test cases that ensure all lines are executed
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("X", RomanNumeral.toRoman(10));
        assertEquals("L", RomanNumeral.toRoman(50));
        assertEquals("C", RomanNumeral.toRoman(100));
        assertEquals("D", RomanNumeral.toRoman(500));
        assertEquals("M", RomanNumeral.toRoman(1000));
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
        assertEquals("XC", RomanNumeral.toRoman(90));
        assertEquals("CD", RomanNumeral.toRoman(400));
        assertEquals("CM", RomanNumeral.toRoman(900));
    }
} 