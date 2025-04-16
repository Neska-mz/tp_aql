package TP1.ConditionCoverageTest;

import TP1.QuadraticEquation;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo4Test {
    @Test
    public void testQuadraticEquationConditions() {
        // Test cases that ensure all conditions are covered
        
        // a = 0 condition
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 0, 0));
        
        // delta < 0 conditions
        assertNull(QuadraticEquation.solve(1, 0, 1));  // b = 0, c > 0
        assertNull(QuadraticEquation.solve(1, 1, 1));  // b > 0, c > 0
        assertNull(QuadraticEquation.solve(1, -1, 1)); // b < 0, c > 0
        
        // delta = 0 conditions
        assertArrayEquals(new double[]{-1.0}, QuadraticEquation.solve(1, 2, 1), 0.001);  // b > 0
        assertArrayEquals(new double[]{1.0}, QuadraticEquation.solve(1, -2, 1), 0.001);  // b < 0
        assertArrayEquals(new double[]{0.0}, QuadraticEquation.solve(1, 0, 0), 0.001);   // b = 0, c = 0
        
        // delta > 0 conditions
        assertArrayEquals(new double[]{-2.0, -4.0}, QuadraticEquation.solve(1, 6, 8), 0.001);    // b > 0, c > 0
        assertArrayEquals(new double[]{1.0, -3.0}, QuadraticEquation.solve(1, 2, -3), 0.001);    // b > 0, c < 0
        assertArrayEquals(new double[]{3.0, -1.0}, QuadraticEquation.solve(1, -2, -3), 0.001);   // b < 0, c < 0
    }
} 