package Mapa;

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
        System.out.println(herniMapa.vypisSoucasnePolohy());
    }
}
