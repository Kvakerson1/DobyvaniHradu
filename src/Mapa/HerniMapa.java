package Mapa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HerniMapa {

    private static ArrayList<Lokace> mapa = new ArrayList<>();
    private static String soucasnaLokace = "start";
    //nacte herni mapu ze souboru
    public boolean NactiMapu(){
        try (BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(" ");
                mapa.add(new Lokace(lines[0],lines[1],lines[2],lines[3],lines[4]));
            }
            return true;
        }catch (IOException e){
            return false;
        }
    }
    //posune hrace danym smerem
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
    //vypise soucasnou polohu
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

}
