package Hrac;

import Armada.Jednotka;
import Armada.PocitaniJednotek;
import MestaADoly.Dul;
import MestaADoly.Mesto;

import java.util.ArrayList;

public class Inventar {
    private static int penize = 50;
    private static ArrayList<Mesto> mesta = new ArrayList<>();
    private static ArrayList<Dul> doly = new ArrayList<>();
    private static ArrayList<Jednotka> jednotky = new ArrayList<>();

    public  int getPenize() {
        return penize;
    }

    public  void setPenize(int penize) {
        penize = penize;
    }

    public void setJednotky(ArrayList<Jednotka> jednotky) {
        Inventar.jednotky = jednotky;
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

    public ArrayList<Dul> getDoly() {
        return doly;
    }

    public ArrayList<Jednotka> getJednotky() {
        return jednotky;
    }

    public void pridejMesto(Mesto m){
        mesta.add(m);
    }
    public void pridejDul(Dul d){
        doly.add(d);
    }
    public void pridejJednotku(Jednotka j){
        jednotky.add(j);
    }

    public ArrayList<PocitaniJednotek> pocetJednotek(){
        ArrayList<PocitaniJednotek> pocetJednotek = new ArrayList<>();
        boolean bylPridan;
        for (int i = 0;i < jednotky.size();i++){
            bylPridan = false;
            for (int j = 0;j < pocetJednotek.size();j++){
                if (pocetJednotek.get(j).getJednotka().equals(jednotky.get(i))){
                    pocetJednotek.get(j).zvysPocet();
                    bylPridan = true;
                }
            }
            if (!bylPridan){
                pocetJednotek.add(new PocitaniJednotek(jednotky.get(i)));
            }
        }
        return pocetJednotek;
    }
    @Override
    public String toString() {
        String vypis = "";
        vypis += "Peníze: " + penize + "\nVlastněná města: ";
        for (int i = 0; i < mesta.size();i++){
            vypis+= mesta.get(i).getNazev() + ", ";
        }
        vypis += "\nVlastněné doly: ";
        for (int i = 0; i < doly.size();i++){
            vypis+= doly.get(i).getNazev() + " " + doly.get(i).getGeneruje() + ", ";
        }
        ArrayList<PocitaniJednotek> pocetJednotek = pocetJednotek();
        vypis += "\nJednotky: ";
        for (int i = 0; i < pocetJednotek.size(); i++){
            vypis += "\ntyp: " + pocetJednotek.get(i).getJednotka().getNazev() + " pocet: " + pocetJednotek.get(i).getPocet() + " sila: " + pocetJednotek.get(i).getJednotka().getSila();
        }

        return vypis;
    }
}
