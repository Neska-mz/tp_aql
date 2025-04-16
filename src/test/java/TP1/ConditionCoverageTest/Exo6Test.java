package TP1.ConditionCoverageTest;

import TP1.FizzBuzz;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo6Test {
    @Test
    public void testFizzBuzzConditions() {
        // Test cases that ensure all conditions are covered
        // Test both true and false conditions for divisibility by 3 and 5
        
        // Neither condition true
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        
        // First condition true (divisible by 3), second false
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        
        // First condition false, second true (divisible by 5)
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        
        // Both conditions true
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        
        // Edge cases
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-15));
    }
} 