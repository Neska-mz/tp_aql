package TP2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatriceTest {

    @Mock
    private Calculatrice calculatrice;

    @Test
    public void testAdditionner() {
        // Définition du comportement de la méthode "additionner"
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // TODO: Appel de la méthode à tester
        int result = calculatrice.additionner(2, 3);

        // TODO: Vérification du résultat
        assertEquals(5, result);

        // TODO: Vérification que la méthode "additionner" a été appelée avec les arguments 2 et 3
        verify(calculatrice).additionner(2, 3);

        // TODO: Vérification qu'aucune autre méthode n'a été appelée sur l'objet après l'appel de la méthode "additionner"
        verifyNoMoreInteractions(calculatrice);

        // TODO: Vérification de l'état de l'objet après l'appel de la méthode "additionner"
        // We assume getResult() is the "getState()" equivalent as per the exercise hint
        when(calculatrice.getResult()).thenReturn(5); // Stub the state
        assertEquals(5, calculatrice.getResult());
        verify(calculatrice).getResult(); // Verify the state was checked
    }
}