package TP1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuadraticEquationTest {

    @Test
    void testInvalidA() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1)); // Line: exception; Branch: a == 0 true
    }

    @Test
    void testNoRealRoots() {
        assertNull(QuadraticEquation.solve(1, 0, 1)); // Line: return null; Branch: delta < 0 true
    }

    @Test
    void testOneRoot() {
        assertArrayEquals(new double[]{-1.0}, QuadraticEquation.solve(1, 2, 1), 0.001); // Line: return single root; Branch: delta == 0 true
    }

    @Test
    void testTwoRoots() {
        assertArrayEquals(new double[]{-2.0, -4.0}, QuadraticEquation.solve(1, 6, 8), 0.001); // Line: return two roots; Branch: delta > 0
    }
}

