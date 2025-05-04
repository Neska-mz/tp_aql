package TP2;

public class Jeu {
    private Banque banque;
    private boolean estOuvert;

    public Jeu(Banque banque) {
        this.banque = banque;
        this.estOuvert = true;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if (!estOuvert) {
            throw new JeuFermeException("Le jeu est fermé");
        }

        int mise = joueur.mise();
        joueur.debiter(mise);
        banque.crediter(mise);

        int roll1 = de1.lancer();
        int roll2 = de2.lancer();
        int sum = roll1 + roll2;

        if (sum == 7) {
            int gain = mise * 2;
            banque.debiter(gain);
            joueur.crediter(gain);
            if (!banque.est_solvable()) {
                fermer();
            }
        }
    }

    public void fermer() {
        this.estOuvert = false;
    }

    public boolean estOuvert() {
        return estOuvert;
    }
}
