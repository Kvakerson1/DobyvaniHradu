package MestaADoly;

public class Dul {
    private String nazev;
    private int generuje;
    private int lvl;

    public Dul(String nazev, int generuje, int lvl) {
        this.nazev = nazev;
        this.generuje = generuje;
        this.lvl = lvl;
    }

    public Dul(String nazev, int generuje) {
        this.nazev = nazev;
        this.generuje = generuje;
        this.lvl = 1;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getGeneruje() {
        return generuje;
    }

    public void setGeneruje(int generuje) {
        this.generuje = generuje;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
