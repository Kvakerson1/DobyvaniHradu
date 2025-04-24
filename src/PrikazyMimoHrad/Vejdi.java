package PrikazyMimoHrad;

import Konzole.Command;
import Konzole.Konzole;
import Mapa.HerniMapa;

public class Vejdi extends Command {
    public  String execute(){
        HerniMapa herniMapa = new HerniMapa();
        Konzole k = new Konzole();
        if (herniMapa.getSoucasnaLokace().contains("hrad")){
            herniMapa.NactiMapu(2);
            System.out.println(herniMapa.vypisSoucasnePolohy());
            k.startHrad();
            return "Vyšel jsi z hradu";
        }
        return "Nemáš kam vejít";
    }
    public  boolean exit(){
        return false;
    }
}
