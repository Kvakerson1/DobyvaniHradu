package PrikazyHrad;

import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;
import MestaADoly.Mesto;

public class Popis extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        Mesto m = new Mesto();
        for (int i = 0; i < inventar.getMesta().size();i++){
            if (inventar.getMesta().get(i).getNazev().equals(h.getLokaceNaMape())){
                m = inventar.getMesta().get(i);
            }
        }
        if (h.getSoucasnaLokace().contains("budova") && m.getBudova(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6)))-1) != null){
            return m.vypisKonkretniBudovy(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6)))-1);
        }
        return "Neni co popisovat";
    }
    public  boolean exit(){
        return false;
    }
}
