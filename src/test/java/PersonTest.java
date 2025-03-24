import org.example.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PersonTest {
    @Test
    void getFullNameShouldReturnFirstNameAndLastNameWithSpace() {
        Person person = new Person("ilyes", "malki", 32);
        assertEquals("ilyes malki", person.getFullName());
    }

    @Test
    void getFullNameShouldReturnLastNameWhenFirstNameIsEmpty() {
        Person person = new Person("", "malki", 32);
        assertEquals("malki", person.getFullName());
    }

    @Test
    void getFullNameShouldReturnFirstNameWhenLastNameIsEmpty() {
        Person person = new Person("ilyes", "", 32);
        assertEquals("ilyes ", person.getFullName());
    }

    @Test
    void getFullNameShouldReturnSpaceWhenBothNamesAreEmpty() {
        Person person = new Person("", "", 32);
        assertEquals(" ", person.getFullName());
    }

    // Tests pour isAdult
    @Test
    void isAdultShouldReturnFalseWhenAgeIsNegative() {
        Person person = new Person("malki", "ilyes", -32);
        assertFalse(person.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseWhenAgeIsZero() {
        Person person = new Person("malki", "ilyes", 0);
        assertFalse(person.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseWhenAgeIsBelowEighteen() {
        Person person = new Person("malki", "ilyes", 12);
        assertFalse(person.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseWhenAgeIsSeventeen() {
        Person person = new Person("malki", "ilyes", 17);
        assertFalse(person.isAdult());
    }

    @Test
    void isAdultShouldReturnTrueWhenAgeIsEighteen() {
        Person person = new Person("malki", "ilyes", 18);
        assertTrue(person.isAdult());
    }

    @Test
    void isAdultShouldReturnTrueWhenAgeIsAboveEighteen() {
        Person person = new Person("malki", "ilyes", 32);
        assertTrue(person.isAdult());
    }
}
