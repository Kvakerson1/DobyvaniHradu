package Armada;

public class Jednotka {
    private String nazev;
    private int cena;
    private int sila;

    public Jednotka(String nazev, int cena, int sila) {
        this.nazev = nazev;
        this.cena = cena;
        this.sila = sila;
    }

    public Jednotka(String nazev, int sila) {
        this.nazev = nazev;
        this.sila = sila;
    }

    public Jednotka() {
    }

    public String getNazev() {
        return nazev;
    }

    public int getCena() {
        return cena;
    }

    public int getSila() {
        return sila;
    }
}
