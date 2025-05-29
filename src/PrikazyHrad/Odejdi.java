package PrikazyHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class Odejdi extends Command {
    /**
     * hrac odejde z hradu na mapu
     * @return soucasna lokace na mape
     */
    public  String execute(){
        HerniMapa h = new HerniMapa();
        h.NactiMapu(1);
        return h.vypisSoucasnePolohy();
    }
    public  boolean exit(){
        return true;
    }
}
