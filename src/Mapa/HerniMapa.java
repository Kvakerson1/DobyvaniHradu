package Mapa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HerniMapa {

    private static ArrayList<Lokace> mapa = new ArrayList<>();
    private static String soucasnaLokace = "";
    private static String lokaceNaMape = "hrad1";

    /**
     * nacte herni mapu ze souboru
     * @param index mapa kterou ma nacist(1 mapa sveta, 2 mapa hradu)
     * @return nacetla se mapa?
     */
    public boolean NactiMapu(int index){
        String soubor;
        mapa = new ArrayList<>();
        switch (index){
            case 1:
                soubor = "mapa.txt";
                break;
            case 2:
                soubor = "hrad.txt";
                lokaceNaMape = soucasnaLokace;
                break;
            default:
                return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(" ");
                mapa.add(new Lokace(lines[0],lines[1],lines[2],lines[3],lines[4]));
            }
            switch (index){
                case 1:
                    soucasnaLokace = lokaceNaMape;
                    break;
                case 2:
                    soucasnaLokace = "ulice1";
                    break;
            }
            return true;
        }catch (IOException e){
            return false;
        }
    }

    /**
     * posune hrace zadanym smerem
     * @param smer smer kterym se ma posunout
     * @return posunul se hrac?
     */
    public boolean posun(int smer){
        Lokace lokace = new Lokace();
        for (int i = 0; i < mapa.size();i++){
            if (mapa.get(i).getNazevLokace().equals(soucasnaLokace)){
                lokace = mapa.get(i);
            }
        }
        switch (smer){
            case 1:
                if (!lokace.getSever().equals("null")){
                    soucasnaLokace = lokace.getSever();
                    return true;
                }else {
                    break;
                }
            case 2:
                if (!lokace.getVychod().equals("null")){
                    soucasnaLokace = lokace.getVychod();
                    return true;
                }else {
                    break;
                }
            case 3:
                if (!lokace.getJih().equals("null")){
                    soucasnaLokace = lokace.getJih();
                    return true;
                }else {
                    break;
                }
            case 4:
                if (!lokace.getZapad().equals("null")){
                    soucasnaLokace = lokace.getZapad();
                    return true;
                }else {
                    break;
                }
        }
        return false;
    }

    /**
     * vypise soucasnou polohu
     * @return soucasna poloha
     */
    public String vypisSoucasnePolohy(){
        for (int i = 0; i< mapa.size();i++){
            if (mapa.get(i).getNazevLokace().equals(soucasnaLokace)){
                return mapa.get(i).toString();
            }
        }
        return null;
    }
    public  String getSoucasnaLokace() {
        return soucasnaLokace;
    }

    public String getLokaceNaMape() {
        return lokaceNaMape;
    }
}
