package Armada;

import MestaADoly.BudovyVeKterychSeCvici;
import MestaADoly.Dul;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Jednotky {
    private static ArrayList<Jednotka> jednotky = new ArrayList<>();
    private static ArrayList<Jednotka> vycvik = new ArrayList<>();

    private static ArrayList<BudovyVeKterychSeCvici> budovy = new ArrayList<>();

    /**
     * Metoda co nacte jednotky ze souboru
     * @return doslo k chybe?
     */
    public boolean nacteniJednotky(){
        try (BufferedReader br = new BufferedReader(new FileReader("jednotky.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(" ");
                jednotky.add(new Jednotka(lines[0],Integer.parseInt(lines[1]),Integer.parseInt(lines[2])));
            }
        }catch (IOException e){
            return false;
        }
        return true;
    }

    public ArrayList<Jednotka> getJednotky() {
        return jednotky;
    }

    /**
     * metoda na pridani jednotky do arraylistu
     * @param j jednotka co má byt pridana
     * @return byla jednotka pridana?
     */
    public boolean pridatJednotkuNaVycvik(Jednotka j){
        try {
            vycvik.add(j);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public ArrayList<Jednotka> getVycvik() {
        return vycvik;
    }

    public ArrayList<BudovyVeKterychSeCvici> getBudovy() {
        return budovy;
    }

    public void setVycvik(ArrayList<Jednotka> vycvik) {
        Jednotky.vycvik = vycvik;
    }

    public void setBudovy(ArrayList<BudovyVeKterychSeCvici> budovy) {
        Jednotky.budovy = budovy;
    }
}
