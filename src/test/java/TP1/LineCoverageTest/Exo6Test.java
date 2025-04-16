package TP1.LineCoverageTest;

import TP1.FizzBuzz;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo6Test {
    @Test
    public void testFizzBuzz() {
        // Test cases that ensure all lines are executed
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
    }
} 