import org.example.Prime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @Test
    void isPrimeWithNegativeNumberShouldReturnFalse() {
        boolean result = Prime.isPrime(-5);
        assertFalse(result, "Un nombre négatif n’est pas premier par définition");
    }

    @Test
    void isPrimeWithZeroShouldReturnFalse() {
        boolean result = Prime.isPrime(0);
        assertFalse(result, "Zéro n’est pas un nombre premier");
    }

    @Test
    void isPrimeWithOneShouldReturnFalse() {
        boolean result = Prime.isPrime(1);
        assertFalse(result, "Un n’a qu’un diviseur et n’est pas premier");
    }

    @Test
    void isPrimeWithTwoShouldReturnTrue() {
        boolean result = Prime.isPrime(2);
        assertTrue(result, "Deux est le plus petit nombre premier");
    }

    @Test
    void isPrimeWithThreeShouldReturnTrue() {
        boolean result = Prime.isPrime(3);
        assertTrue(result, "Trois est un nombre premier");
    }

    @Test
    void isPrimeWithFourShouldReturnFalse() {
        boolean result = Prime.isPrime(4);
        assertFalse(result, "Quatre est composé (divisible par 2)");
    }

    @Test
    void isPrimeWithSixShouldReturnFalse() {
        boolean result = Prime.isPrime(6);
        assertFalse(result, "Six est composé (divisible par 2 et 3)");
    }

    @Test
    void isPrimeWithNineShouldReturnFalse() {
        boolean result = Prime.isPrime(9);
        assertFalse(result, "Neuf est composé (divisible par 3)");
    }

    @Test
    void isPrimeWithSeventeenShouldReturnTrue() {
        boolean result = Prime.isPrime(17);
        assertTrue(result, "Dix-sept est un nombre premier");
    }

    @Test
    void isPrimeWithNinetySevenShouldReturnTrue() {
        boolean result = Prime.isPrime(97);
        assertTrue(result, "Quatre-vingt-dix-sept est un nombre premier");
    }

    @Test
    void isPrimeWithLargeCompositeShouldReturnFalse() {
        boolean result = Prime.isPrime(100);
        assertFalse(result, "Cent est composé (divisible par 2, 5, etc.)");
    }

    @Test
    void isPrimeWithMaxIntShouldHandleCorrectly() {
        // Integer.MAX_VALUE = 2,147,483,647 est un nombre premier
        boolean result = Prime.isPrime(Integer.MAX_VALUE);
        assertTrue(result, "Integer.MAX_VALUE est un nombre premier");
    }

    @Test
    void isPrimeWithLargeSquareShouldReturnFalse() {
        int square = 10000; // 100²
        boolean result = Prime.isPrime(square);
        assertFalse(result, "Un grand carré parfait comme 10000 n’est pas premier");
    }
}