package TP1;
// TP1/Exo6Test.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0)); // Line: exception; Branch: n < 1 true
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-1));
    }

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15)); // Line: return "FizzBuzz"; Branch: n % 15 == 0 true
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
    }

    @Test
    void testFizz() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3)); // Line: return "Fizz"; Branch: n % 3 == 0 true, n % 15 == 0 false
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    void testBuzz() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5)); // Line: return "Buzz"; Branch: n % 5 == 0 true, others false
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
    }

    @Test
    void testNumber() {
        assertEquals("1", FizzBuzz.fizzBuzz(1)); // Line: return String.valueOf(n); Branch: all conditions false
        assertEquals("2", FizzBuzz.fizzBuzz(2));
    }
}
