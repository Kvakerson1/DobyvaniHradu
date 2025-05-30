package PrikazyHrad;

import Armada.Jednotky;
import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;
import MestaADoly.Budova;
import MestaADoly.Mesto;

public class VylepsiBudovu extends Command {
    /**
     * metoda vylepsi danou budovu
     * @return Budova vylepsena nebo duvod proc budova nelze vylepsit
     */
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
            if (b.getCena() <= inventar.getPenize()){
                b.zvysLvl();
                inventar.odebraniPenez(b.getCena());
            }
            else {
                return "Nedostatek penez";
            }
        }
        return "Budova vylepsena";
    }
    public  boolean exit(){
        return false;
    }
}
