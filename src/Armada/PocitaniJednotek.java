package Armada;

public class PocitaniJednotek {
    private int pocet;
    private Jednotka jednotka;

    public PocitaniJednotek(Jednotka jednotka) {
        this.jednotka = jednotka;
        pocet = 1;
    }

    public int getPocet() {
        return pocet;
    }

    public Jednotka getJednotka() {
        return jednotka;
    }
    public void zvysPocet(){
        pocet++;
    }
}
