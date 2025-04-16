package TP1.BranchCoverageTest;

import TP1.FizzBuzz;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo6Test {
    @Test
    public void testFizzBuzzBranches() {
        // Test cases that ensure all branches are covered
        // Not divisible by 3 or 5
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        
        // Divisible by 3 only
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
        
        // Divisible by 5 only
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        
        // Divisible by both 3 and 5
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }
} 