package TP1.BranchCoverageTest;

import TP1.QuadraticEquation;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exo4Test {
    @Test
    public void testQuadraticEquationBranches() {
        // Test cases that ensure all branches are covered
        
        // Invalid input branch
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 1, 1));
        
        // No real roots branch (delta < 0)
        assertNull(QuadraticEquation.solve(1, 0, 1));
        assertNull(QuadraticEquation.solve(2, 1, 2));
        
        // One root branch (delta = 0)
        assertArrayEquals(new double[]{-1.0}, QuadraticEquation.solve(1, 2, 1), 0.001);
        assertArrayEquals(new double[]{0.0}, QuadraticEquation.solve(1, 0, 0), 0.001);
        
        // Two roots branch (delta > 0)
        assertArrayEquals(new double[]{-2.0, -4.0}, QuadraticEquation.solve(1, 6, 8), 0.001);
        assertArrayEquals(new double[]{1.0, -3.0}, QuadraticEquation.solve(1, 2, -3), 0.001);
    }
} 