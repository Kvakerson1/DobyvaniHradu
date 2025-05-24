package PrikazyHrad;

import Armada.Jednotky;
import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;
import MestaADoly.Budova;
import MestaADoly.Mesto;

public class VylepsiBudovu extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        Mesto m = new Mesto();
        for (int i = 0; i < inventar.getMesta().size();i++){
            if (inventar.getMesta().get(i).getNazev().equals(h.getLokaceNaMape())){
                m = inventar.getMesta().get(i);
            }
        }
        if (h.getSoucasnaLokace().contains("budova")) {
            if (m.getBudova(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6))) - 1) == null) {
                return "Zde nestoji zadna budova";
            }
            Budova b = m.getBudova(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6))) - 1);
            if (b.getCena()*8/10 <= inventar.getPenize()){
                b.zvysLvl();
            }
        }
        return "Budova vylepsena";
    }
    public  boolean exit(){
        return false;
    }
}
