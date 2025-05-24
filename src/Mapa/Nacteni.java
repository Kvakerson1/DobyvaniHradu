package Mapa;

import Armada.Jednotky;
import Armada.NacteniObrany;
import Hrac.Inventar;
import MestaADoly.Doly;
import MestaADoly.Mesto;

public class Nacteni {
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
        for (int i = 0;i < 10; i++){
            inventar.pridejJednotku(j.getJednotky().get(0));
        }
        for (int i = 0;i < 10; i++){
            inventar.pridejJednotku(j.getJednotky().get(2));
        }
        System.out.println(herniMapa.vypisSoucasnePolohy());
    }
}
