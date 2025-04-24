package PrikazyHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Odejdi extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.NactiMapu(1);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return true;
    }
}
