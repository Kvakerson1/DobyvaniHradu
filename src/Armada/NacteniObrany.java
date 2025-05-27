package Armada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NacteniObrany {
    private static ArrayList<Obrana> obrana = new ArrayList<>();

    public boolean nacteniObrany(){
        Jednotky jednotky = new Jednotky();
        try (BufferedReader br = new BufferedReader(new FileReader("obrana.txt"))){
            String line;
            while ((line = br.readLine()) != null) {

                String[] lines = line.split(" ");
                Obrana o = new Obrana(lines[0],new ArrayList<>());
                for (int i = 1; i < lines.length;i++){
                    for (int j = 0; j < Integer.parseInt(lines[i]);j++){
                        o.pridejJednotku(jednotky.getJednotky().get(i-1));
                    }
                }
                obrana.add(o);
            }
        }catch (IOException e){
            return false;
        }
        return true;
    }

    public ArrayList<Obrana> getObrana() {
        return obrana;
    }

    public ArrayList<PocitaniJednotek> vypis(String lokace){
        ArrayList<PocitaniJednotek> pocetJednotek = new ArrayList<>();
        boolean bylPridan;
        int cislo = 0;
        for (int i = 0; i < obrana.size();i++){
            if (obrana.get(i).getNazev().equals(lokace)){
                cislo = i;
            }
        }
        for (int i = 0;i < obrana.get(cislo).getJednotky().size();i++){
            bylPridan = false;
            for (int j = 0;j < pocetJednotek.size();j++){
                if (pocetJednotek.get(j).getJednotka().equals(obrana.get(cislo).getJednotky().get(i))){
                    pocetJednotek.get(j).zvysPocet();
                    bylPridan = true;
                }
            }
            if (!bylPridan){
                pocetJednotek.add(new PocitaniJednotek(obrana.get(cislo).getJednotky().get(i)));
            }
        }
        return pocetJednotek;

    }
}
