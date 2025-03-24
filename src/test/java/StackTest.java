import org.example.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(); // Réinitialise la pile avant chaque test
    }

    // Tests pour isEmpty
    @Test
    void newStackShouldBeEmpty() {
        assertTrue(stack.isEmpty(), "Une pile nouvellement créée doit être vide");
    }

    @Test
    void stackWithElementsShouldNotBeEmpty() {
        stack.push(42);
        assertFalse(stack.isEmpty(), "Une pile avec des éléments ne doit pas être vide");
    }

    // Tests pour size
    @Test
    void sizeOfNewStackShouldBeZero() {
        assertEquals(0, stack.size(), "La taille d'une pile vide doit être 0");
    }

    @Test
    void sizeShouldIncreaseAfterPush() {
        stack.push(7);
        assertEquals(1, stack.size(), "La taille doit augmenter après un push");
        stack.push(13);
        assertEquals(2, stack.size(), "La taille doit continuer à augmenter");
    }

    @Test
    void sizeShouldDecreaseAfterPop() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        assertEquals(1, stack.size(), "La taille doit diminuer après un pop");
    }

    // Tests pour push
    @Test
    void pushShouldAddElementToEmptyStack() {
        stack.push(99);
        assertEquals(99, stack.peek(), "Le premier élément poussé doit être au sommet");
    }

    @Test
    void pushShouldStackElementsInOrder() {
        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.peek(), "Le dernier élément poussé doit être au sommet");
    }

    @Test
    void pushBeyondInitialCapacityShouldExpandArray() {
        for (int i = 0; i < 11; i++) { // Capacité initiale = 10, donc 11 dépasse
            stack.push(i);
        }
        assertEquals(11, stack.size(), "La taille doit refléter tous les éléments ajoutés");
        assertEquals(10, stack.peek(), "Le dernier élément doit être accessible après expansion");
    }

    // Tests pour pop
    @Test
    void popShouldRemoveAndReturnTopElement() {
        stack.push(5);
        stack.push(10);
        int topElement = (int) stack.pop();
        assertEquals(10, topElement, "Pop doit renvoyer le dernier élément poussé");
        assertEquals(1, stack.size(), "La taille doit diminuer après pop");
        assertEquals(5, stack.peek(), "L'élément suivant doit devenir le sommet");
    }

    @Test
    void popOnEmptyStackShouldThrowException() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> stack.pop(),
                "Pop sur une pile vide doit lever une exception"
        );
        assertEquals("Stack is empty", exception.getMessage());
    }

    // Tests pour peek
    @Test
    void peekShouldReturnTopElementWithoutRemovingIt() {
        stack.push(77);
        int topElement = (int) stack.peek();
        assertEquals(77, topElement, "Peek doit renvoyer l'élément au sommet");
        assertEquals(1, stack.size(), "Peek ne doit pas modifier la taille");
    }

    @Test
    void peekOnEmptyStackShouldThrowException() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> stack.peek(),
                "Peek sur une pile vide doit lever une exception"
        );
        assertEquals("Stack is empty", exception.getMessage());
    }

    // Test combiné pour vérifier le comportement global
    @Test
    void stackShouldMaintainLifoOrderAfterMultipleOperations() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop(), "Premier pop doit renvoyer 3");
        assertEquals(2, stack.pop(), "Deuxième pop doit renvoyer 2");
        assertEquals(1, stack.peek(), "Peek doit montrer 1 restant");
        assertEquals(1, stack.size(), "Il doit rester un élément");
        stack.pop();
        assertTrue(stack.isEmpty(), "La pile doit être vide après avoir tout retiré");
    }
}
