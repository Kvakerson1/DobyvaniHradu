package Armada;

import java.util.ArrayList;

public class Obrana {
    private String nazev;
    private ArrayList<Jednotka> jednotky;

    public Obrana(String nazev, ArrayList<Jednotka> jednotky) {
        this.nazev = nazev;
        this.jednotky = jednotky;
    }
    public void setJednotky(ArrayList<Jednotka> jednotky) {
        this.jednotky = jednotky;
    }

    public String getNazev() {
        return nazev;
    }

    public ArrayList<Jednotka> getJednotky() {
        return jednotky;
    }
    public void pridejJednotku(Jednotka j){
        jednotky.add(j);
    }
}
