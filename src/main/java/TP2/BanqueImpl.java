package TP2;
public class BanqueImpl implements Banque {
    private int fonds;
    private final int fondsMinimum;

    public BanqueImpl(int fondsInitial, int fondsMinimum) {
        this.fonds = fondsInitial;
        this.fondsMinimum = fondsMinimum;
    }

    @Override
    public void crediter(int somme) {
        this.fonds += somme;
    }

    @Override
    public boolean est_solvable() {
        return fonds >= fondsMinimum;
    }

    @Override
    public void debiter(int somme) {
        this.fonds -= somme;
    }
}