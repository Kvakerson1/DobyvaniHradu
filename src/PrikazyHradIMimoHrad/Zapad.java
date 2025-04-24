package PrikazyHradIMimoHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Zapad extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.posun(4);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return false;
    }
}
