package MestaADoly;

public class Dul {
    private String nazev;
    private int zakladniGenerace;
    private int lvl;

    public Dul(String nazev, int zakladniGenerace, int lvl) {
        this.nazev = nazev;
        this.zakladniGenerace = zakladniGenerace;
        this.lvl = lvl;
    }

    public Dul(String nazev, int zakladniGenerace) {
        this.nazev = nazev;
        this.zakladniGenerace = zakladniGenerace;
        this.lvl = 1;
    }

    public String getNazev() {
        return nazev;
    }

    public int getZakladniGenerace() {
        return zakladniGenerace;
    }
    public int getGeneruje(){
        return zakladniGenerace*lvl;
    }

    public int getLvl() {
        return lvl;
    }
    public void zvysLvl(){
        lvl += 1;
    }
}