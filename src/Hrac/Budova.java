package Hrac;

public class Budova {
    private String typBudovy;
    private int lvl;

    public Budova(String typBudovy, int lvl) {
        this.typBudovy = typBudovy;
        this.lvl = lvl;
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
}
