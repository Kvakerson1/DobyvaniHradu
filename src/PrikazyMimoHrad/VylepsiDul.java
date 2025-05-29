package PrikazyMimoHrad;

import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;

public class VylepsiDul extends Command {
    /**
     * vylepsi dul na hracove lokaci
     * @return Dul vylepsen nebo duvod proc dul nejde vylepsit
     */
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        if(h.getSoucasnaLokace().contains("dul")){
            for (int i = 0; i < inventar.getDoly().size();i++){
                if (h.getSoucasnaLokace().equals(inventar.getDoly().get(i).getNazev())){
                    if (inventar.getDoly().get(i).getGeneruje()*3 <= inventar.getPenize()){
                        inventar.odebraniPenez(inventar.getDoly().get(i).getGeneruje()*3);
                        inventar.getDoly().get(i).zvysLvl();
                        return "Dul vylepsen";
                    }
                    return "Nedostatek penez";
                }
            }
            return "Dul nevlastnite";
        }
        return "Neni co vylepsit";
    }
    public  boolean exit(){
        return false;
    }
}
