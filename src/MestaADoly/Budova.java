package MestaADoly;

public class Budova {
    private String typBudovy;
    private String typJednotek;
    private int lvl;

    public Budova(String typBudovy, String typJedntek, int lvl) {
        this.typBudovy = typBudovy;
        this.typJednotek = typJedntek;
        this.lvl = lvl;
    }

    public Budova(String typBudovy, String typJedntek) {
        this.typBudovy = typBudovy;
        this.typJednotek = typJedntek;
        this.lvl = 1;
    }

    public String getTypBudovy() {
        return typBudovy;
    }

    public void setTypBudovy(String typBudovy) {
        this.typBudovy = typBudovy;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public String getTypJedntek() {
        return typJednotek;
    }

    public void setTypJedntek(String typJedntek) {
        this.typJednotek = typJedntek;
    }

    @Override
    public String toString() {
        return "Typ budovy " + typBudovy;
    }
}
