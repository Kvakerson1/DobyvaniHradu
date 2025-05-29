package MestaADoly;

import Mapa.Lokace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Doly {
    private static ArrayList<Dul> doly = new ArrayList<>();

    /**
     * Nacte doly a kolik generuji ze souboru
     * @return byly doly nacteny uspesne?
     */
    public boolean nacteniDolu(){
        try (BufferedReader br = new BufferedReader(new FileReader("doly.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(" ");
                doly.add(new Dul(lines[0],Integer.parseInt(lines[1])));
            }
        }catch (IOException e){
            return false;
        }
        return true;
    }

    public ArrayList<Dul> getDoly() {
        return doly;
    }
}
