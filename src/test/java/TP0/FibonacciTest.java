package TP0;

import org.example.TP0.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibonacciWithNegativeInputShouldThrowException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Fibonacci.fibonacci(-1),
                "Un n négatif doit provoquer une exception"
        );
        assertEquals("n must be positive", exception.getMessage(), "Le message d'erreur doit être correct");
    }

    @Test
    void fibonacciOfZeroShouldReturnZero() {
        int result = Fibonacci.fibonacci(0);
        assertEquals(0, result, "F(0) doit valoir 0 selon la définition");
    }

    @Test
    void fibonacciOfOneShouldReturnOne() {
        int result = Fibonacci.fibonacci(1);
        assertEquals(1, result, "F(1) doit valoir 1 selon la définition");
    }

    @Test
    void fibonacciOfTwoShouldReturnOne() {
        int result = Fibonacci.fibonacci(2);
        assertEquals(1, result, "F(2) = F(1) + F(0) doit valoir 1");
    }

    @Test
    void fibonacciOfThreeShouldReturnTwo() {
        int result = Fibonacci.fibonacci(3);
        assertEquals(2, result, "F(3) = F(2) + F(1) doit valoir 2");
    }

    @Test
    void fibonacciOfFourShouldReturnThree() {
        int result = Fibonacci.fibonacci(4);
        assertEquals(3, result, "F(4) = F(3) + F(2) doit valoir 3");
    }

    @Test
    void fibonacciOfFiveShouldReturnFive() {
        int result = Fibonacci.fibonacci(5);
        assertEquals(5, result, "F(5) = F(4) + F(3) doit valoir 5");
    }

    @Test
    void fibonacciOfTenShouldReturnFiftyFive() {
        int result = Fibonacci.fibonacci(10);
        assertEquals(55, result, "F(10) doit valoir 55 dans la suite de Fibonacci");
    }

    @Test
    void fibonacciShouldFollowRecursiveDefinition() {
        int n = 6;
        int expected = Fibonacci.fibonacci(n - 1) + Fibonacci.fibonacci(n - 2);
        int result = Fibonacci.fibonacci(n);
        assertEquals(expected, result, "F(n) doit égaler F(n-1) + F(n-2) pour n = 6");
    }

    @Test
    void fibonacciWithLargeInputShouldNotOverflowTooEarly() {
        int result = Fibonacci.fibonacci(20);
        assertEquals(6765, result, "F(20) doit valoir 6765 sans débordement prématuré");
    }

    @Test
    void fibonacciNearIntOverflowShouldStillBeAccurate() {
        int result = Fibonacci.fibonacci(46); // F(46) = 1,836,311,903 (juste avant débordement)
        assertEquals(1836311903, result, "F(46) doit être calculé correctement avant débordement");
    }

    @Test
    void fibonacciBeyondIntOverflowShouldWrapAround() {
        int result = Fibonacci.fibonacci(47); // F(47) = 2,971,215,073 dépasse int max
        assertTrue(result < 0, "F(47) doit déborder et donner une valeur négative avec int");
    }
}
