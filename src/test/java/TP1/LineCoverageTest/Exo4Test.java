package TP1.LineCoverageTest;

import TP1.QuadraticEquation;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo4Test {
    @Test
    public void testQuadraticEquation() {
        // Test cases that ensure all lines are executed
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
        assertNull(QuadraticEquation.solve(1, 0, 1));
        assertArrayEquals(new double[]{-1.0}, QuadraticEquation.solve(1, 2, 1), 0.001);
        assertArrayEquals(new double[]{-2.0, -4.0}, QuadraticEquation.solve(1, 6, 8), 0.001);
    }
} 