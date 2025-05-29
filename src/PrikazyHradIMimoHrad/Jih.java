package PrikazyHradIMimoHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Jih extends Command {
    /**
     * posune hrace smerem na jih
     * @return lokace po posunu
     */
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.posun(3);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return false;
    }
}
