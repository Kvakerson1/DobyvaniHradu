package PrikazyHradIMimoHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Sever extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.posun(1);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return false;
    }
}
