package PrikazyHradIMimoHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Zapad extends Command {
    /**
     * posune hrace smerem na zapad
     * @return lokace po posunu
     */
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.posun(4);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return false;
    }
}
