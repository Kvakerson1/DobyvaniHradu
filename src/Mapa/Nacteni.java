package Mapa;

import Armada.Jednotky;
import Armada.NacteniObrany;
import Hrac.Inventar;
import Konzole.Konzole;
import MestaADoly.Doly;
import MestaADoly.Mesto;

public class Nacteni {
    /**
     * nacte vse co je potreba na zacatku hry
     */
    public void nacteni(){
        HerniMapa herniMapa = new HerniMapa();
        herniMapa.NactiMapu(1);
        Inventar inventar = new Inventar();
        Mesto m = new Mesto("hrad1");
        inventar.pridejMesto(m);
        Doly d = new Doly();
        d.nacteniDolu();
        Jednotky j = new Jednotky();
        j.nacteniJednotky();
        inventar.pridejDul(d.getDoly().get(0));
        NacteniObrany o = new NacteniObrany();
        o.nacteniObrany();
        System.out.println(herniMapa.vypisSoucasnePolohy());
        Konzole k = new Konzole();
        k.start();
    }
}
