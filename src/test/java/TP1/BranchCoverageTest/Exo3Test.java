package TP1.BranchCoverageTest;

import TP1.BinarySearch;
import org.junit.Test;
import static org.junit.Assert.*;

public class Exo3Test {
    @Test
    public void testBinarySearchBranches() {
        // Test cases that ensure all branches are covered
        int[] array = {1, 2, 3, 4, 5};
        
        // Test empty array branch
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
        
        // Test single element array branches
        assertEquals(0, BinarySearch.binarySearch(new int[]{1}, 1));
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1}, 2));
        
        // Test even length array branches
        int[] evenArray = {1, 2, 3, 4};
        assertEquals(1, BinarySearch.binarySearch(evenArray, 2));
        assertEquals(3, BinarySearch.binarySearch(evenArray, 4));
        assertEquals(-1, BinarySearch.binarySearch(evenArray, 5));
        
        // Test odd length array branches
        assertEquals(0, BinarySearch.binarySearch(array, 1));
        assertEquals(2, BinarySearch.binarySearch(array, 3));
        assertEquals(4, BinarySearch.binarySearch(array, 5));
        assertEquals(-1, BinarySearch.binarySearch(array, 6));
        
        // Test element not found branches
        assertEquals(-1, BinarySearch.binarySearch(array, 0));
        assertEquals(-1, BinarySearch.binarySearch(array, 6));
    }
} 