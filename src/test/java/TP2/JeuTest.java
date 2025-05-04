package TP2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JeuTest {

    @Mock
    private Banque banque;

    @Mock
    private Joueur joueur;

    @Mock
    private De de1;

    @Mock
    private De de2;

    @Test
    public void testJouerWhenGameIsClosed() throws JeuFermeException, DebitImpossibleException {
        Jeu jeu = new Jeu(banque);
        jeu.fermer();
        assertThrows(JeuFermeException.class, () -> jeu.jouer(joueur, de1, de2));
    }

    @Test
    public void testJouerWhenPlayerIsInsolvent() throws JeuFermeException, DebitImpossibleException {
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        doThrow(new DebitImpossibleException("Joueur insolvable")).when(joueur).debiter(100);
        assertThrows(DebitImpossibleException.class, () -> jeu.jouer(joueur, de1, de2));
        verify(de1, never()).lancer();
        verify(de2, never()).lancer();
    }

    @Test
    public void testJouerPlayerLoses() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(3);
        when(de2.lancer()).thenReturn(2); // Sum = 5 (not 7)

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(joueur, never()).crediter(anyInt());
        verify(banque, never()).debiter(anyInt());
        assertTrue(jeu.estOuvert());
    }

    @Test
    public void testJouerPlayerWinsBankSolvable() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // Sum = 7
        when(banque.est_solvable()).thenReturn(true);

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        assertTrue(jeu.estOuvert());
    }

    @Test
    public void testJouerPlayerWinsBankInsolvent() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // Sum = 7
        when(banque.est_solvable()).thenReturn(false);

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        verify(banque).crediter(100);
        verify(banque).debiter(200);
        verify(joueur).crediter(200);
        assertFalse(jeu.estOuvert());
    }

    @Test
    public void testJouerPlayerWinsBankInsolventWithRealBank() throws JeuFermeException, DebitImpossibleException {
        // Arrange
        BanqueImpl banque = new BanqueImpl(250, 200); // Initial funds 250, minimum 200
        Jeu jeu = new Jeu(banque);
        when(joueur.mise()).thenReturn(100);
        when(de1.lancer()).thenReturn(4);
        when(de2.lancer()).thenReturn(3); // Sum = 7

        // Act
        jeu.jouer(joueur, de1, de2);

        // Assert
        verify(joueur).debiter(100);
        // Banque credited 100, then debited 200, so funds = 250 + 100 - 200 = 150
        verify(joueur).crediter(200);
        assertFalse(jeu.estOuvert()); // Funds (150) < minimum (200)
    }
}