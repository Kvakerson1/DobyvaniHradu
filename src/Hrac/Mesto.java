package Hrac;

import java.util.ArrayList;

public class Mesto {
    private String nazev;
    Budova[] budovy = new Budova[3];

    public Mesto(String nazev) {
        this.nazev = nazev;
    }
    public void postavBudovu(int index,Budova b){
        budovy[index] = b;
    }

    public String getNazev() {
        return nazev;
    }
}
