package Hrac;

import MestaADoly.Dul;
import MestaADoly.Mesto;

import java.util.ArrayList;

public class Inventar {
    private static int penize = 50;
    private static ArrayList<Mesto> mesta = new ArrayList<>();
    private static ArrayList<Dul> doly = new ArrayList<>();


    public  int getPenize() {
        return penize;
    }

    public  void setPenize(int penize) {
        penize = penize;
    }
    public void odebraniPenez(int p){
        penize-=p;
    }
    public void pridaniPenez(int p){
        penize+=p;
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

    @Override
    public String toString() {
        String vypis = "";
        vypis += "Peníze: " + penize + "\nVlastněná města: ";
        for (int i = 0; i < mesta.size();i++){
            vypis+= mesta.get(i).getNazev();
        }
        vypis += "\nVlastněné doly: ";
        for (int i = 0; i < doly.size();i++){
            vypis+= doly.get(i).getNazev();
        }
        return vypis;
    }
}
