package MestaADoly;

import MestaADoly.Budova;

public class Mesto {
    private String nazev;
    Budova[] budovy = new Budova[3];

    public Mesto() {
    }

    public Mesto(String nazev) {
        this.nazev = nazev;
    }
    public void postavBudovu(int index,Budova b){
        budovy[index] = b;
    }

    public String getNazev() {
        return nazev;
    }

    public Budova getBudova(int index){
        return budovy[index];
    }
    public String vypisKonkretniBudovy(int index){
        return budovy[index].toString();
    }
}
