package TP0;

import org.example.TP0.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void addShouldHandleNegativeNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    void addShouldHandleZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void addShouldHandleMixedNumbers() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.add(-2, 3));
    }
}