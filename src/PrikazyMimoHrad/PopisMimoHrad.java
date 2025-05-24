package PrikazyMimoHrad;

import Armada.NacteniObrany;
import Armada.PocitaniJednotek;
import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;

import java.util.ArrayList;

public class PopisMimoHrad extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        NacteniObrany n = new NacteniObrany();
        String vypis = "";
        if (h.getSoucasnaLokace().contains("dul") || h.getSoucasnaLokace().contains("hrad")){
            for (int i = 0;i< inventar.getDoly().size();i++){
                if (inventar.getDoly().get(i).getNazev().equals(h.getSoucasnaLokace())){
                    return inventar.getDoly().get(i).toString();
                }
            }
            for (int i = 0;i< inventar.getMesta().size();i++){
                if (inventar.getMesta().get(i).getNazev().equals(h.getSoucasnaLokace())){
                    return "Toto je tve mesto";
                }
            }
            ArrayList<PocitaniJednotek> jednotky = n.vypis(h.getSoucasnaLokace());
            for (int i = 0; i < jednotky.size();i++){
                vypis += "\ntyp: " + jednotky.get(i).getJednotka().getNazev() + " pocet: " + jednotky.get(i).getPocet() + " sila: " + jednotky.get(i).getJednotka().getSila();
            }
            return vypis;
        }
        return "Zde neni co popisovat";
    }
    public  boolean exit(){
        return false;
    }
}
