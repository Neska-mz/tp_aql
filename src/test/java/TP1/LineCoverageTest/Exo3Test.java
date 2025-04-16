package TP1.LineCoverageTest;

import TP1.BinarySearch;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo3Test {
    @Test
    public void testBinarySearch() {
        // Test cases that ensure all lines are executed
        int[] array = {1, 2, 3, 4, 5};
        
        // Test existing elements
        assertEquals(0, BinarySearch.binarySearch(array, 1));
        assertEquals(2, BinarySearch.binarySearch(array, 3));
        assertEquals(4, BinarySearch.binarySearch(array, 5));
        
        // Test non-existing elements
        assertEquals(-1, BinarySearch.binarySearch(array, 0));
        assertEquals(-1, BinarySearch.binarySearch(array, 6));
        
        // Test empty array
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }
} 