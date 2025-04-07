package TP0;

import org.example.TP0.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    // Equivalence classes:
    // 1. Negative numbers (should throw exception)
    // 2. Zero (should return 1)
    // 3. Positive numbers (should return correct factorial)
    // Boundary cases: 0, 1, maximum value before overflow

    @Test
    void testNegativeInput() {
        // Test for negative numbers - should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-5);
        });
    }

    @Test
    void testZero() {
        // Test for 0! = 1
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void testSmallPositiveNumbers() {
        // Test for positive numbers in normal range
        assertEquals(1, Factorial.factorial(1));
        assertEquals(2, Factorial.factorial(2));
        assertEquals(6, Factorial.factorial(3));
        assertEquals(24, Factorial.factorial(4));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void testIntegerOverflow() {
        // Test for large numbers that cause integer overflow
        // Note: In Java int, factorial(12) = 479001600 is fine
        // but factorial(13) = 6227020800 exceeds Integer.MAX_VALUE (2147483647)
        assertEquals(479001600, Factorial.factorial(12));

    }
}
