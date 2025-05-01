package Hrac;

import java.util.ArrayList;

public class Inventar {
    private static int penize;
    private static ArrayList<Mesto> mesta = new ArrayList<>();
    private static ArrayList<Dul> doly = new ArrayList<>();


    public  int getPenize() {
        return penize;
    }

    public  void setPenize(int penize) {
        penize = penize;
    }

    public ArrayList<Mesto> getMesta() {
        return mesta;
    }
    public void pridejMesto(Mesto m){
        mesta.add(m);
    }
    public void pridejDul(Dul d){
        doly.add(d);
    }
}
