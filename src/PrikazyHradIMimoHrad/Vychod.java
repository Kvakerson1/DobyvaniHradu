package PrikazyHradIMimoHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Vychod extends Command {
    /**
     * posune hrace smerem na vychod
     * @return lokace po posunu
     */
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.posun(2);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return false;
    }
}
