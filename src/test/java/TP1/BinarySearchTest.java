package TP1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 1)); // Line: exception; Branch: array == null true
    }

    @Test
    void testEmptyArray() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1)); // Line: return -1; Branch: low <= high false
    }

    @Test
    void testElementPresent() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(array, 1)); // Line: return mid; Branch: array[mid] == element true
        assertEquals(2, BinarySearch.binarySearch(array, 5));
        assertEquals(4, BinarySearch.binarySearch(array, 9));
    }

    @Test
    void testElementAbsent() {
        int[] array = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(array, 0)); // Line: high = mid - 1; Branch: array[mid] < element false
        assertEquals(-1, BinarySearch.binarySearch(array, 10)); // Line: low = mid + 1; Branch: array[mid] < element true
        assertEquals(-1, BinarySearch.binarySearch(array, 4));
    }

    @Test
    void testSingleElement() {
        int[] array = {1};
        assertEquals(0, BinarySearch.binarySearch(array, 1)); // Line: mid calculation; Branch: low <= high true
        assertEquals(-1, BinarySearch.binarySearch(array, 2));
    }
}

