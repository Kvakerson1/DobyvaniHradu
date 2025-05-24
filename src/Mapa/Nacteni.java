package Mapa;

import Armada.Jednotky;
import Hrac.Inventar;
import MestaADoly.Doly;
import MestaADoly.Mesto;

public class Nacteni {
    public void nacteni(){
        HerniMapa herniMapa = new HerniMapa();
        herniMapa.NactiMapu(1);
        Inventar i = new Inventar();
        Mesto m = new Mesto("hrad1");
        i.pridejMesto(m);
        Doly d = new Doly();
        d.nacteniDolu();
        Jednotky j = new Jednotky();
        j.nacteniJednotky();
        i.pridejDul(d.getDoly().get(0));
        System.out.println(herniMapa.vypisSoucasnePolohy());
    }
}
