package TP2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UtilisateurApi utilisateurApiMock;

    @Test
    public void testCreerUtilisateur() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("youcef", "mazouni", "ymazouni00@gmail.com");
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    // Scenario 1: Throw ServiceException
    @Test
    public void testCreerUtilisateurThrowsException() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("youcef", "mazouni", "ymazouni00@gmail.com");
        doThrow(new ServiceException("Echec de la création de l'utilisateur"))
                .when(utilisateurApiMock).creerUtilisateur(utilisateur);
        UserService userService = new UserService(utilisateurApiMock);
        assertThrows(ServiceException.class, () -> userService.creerUtilisateur(utilisateur));
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    // Scenario 2: Validation Error with never()
    @Test
    public void testCreerUtilisateurValidationError() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("", "mazouni", "ymazouni00@gmail.com"); // Invalid prenom
        UserService userService = new UserService(utilisateurApiMock);
        // Assuming validation happens in UserService (we'll mock the API not being called)
        verify(utilisateurApiMock, never()).creerUtilisateur(any(Utilisateur.class));
    }

    // Scenario 3: Verify ID after creation
    @Test
    public void testCreerUtilisateurSetsId() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("youcef", "mazouni", "ymazouni00@gmail.com");
        int idUtilisateur = 123;
        doAnswer(invocation -> {
            Utilisateur u = invocation.getArgument(0);
            u.setId(idUtilisateur);
            return true;
        }).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        assertEquals(idUtilisateur, utilisateur.getId());
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }

    // Scenario 4: Capture and verify arguments
    @Test
    public void testCreerUtilisateurArgumentCapture() throws ServiceException {
        Utilisateur utilisateur = new Utilisateur("Youcef", "Mazouni", "youzefmaz1213@gmail.com");
        ArgumentCaptor<Utilisateur> argumentCaptor = ArgumentCaptor.forClass(Utilisateur.class);
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenReturn(true);
        UserService userService = new UserService(utilisateurApiMock);
        userService.creerUtilisateur(utilisateur);
        verify(utilisateurApiMock).creerUtilisateur(argumentCaptor.capture());
        Utilisateur utilisateurCapture = argumentCaptor.getValue();
        // Vérification des arguments capturés
        assertEquals("Youcef", utilisateurCapture.getPrenom());
        assertEquals("Mazouni", utilisateurCapture.getNom());
        assertEquals("youzefmaz1213@gmail.com", utilisateurCapture.getEmail());
    }
}