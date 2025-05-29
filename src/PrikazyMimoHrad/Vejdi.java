package PrikazyMimoHrad;

import Hrac.Inventar;
import Konzole.Command;
import Konzole.Konzole;
import Mapa.HerniMapa;

public class Vejdi extends Command {
    /**
     * vejde do hradu vlastneneho hracem
     * @return duvod proc hrac nemuze vejit do hradu
     */
    public  String execute(){
        HerniMapa herniMapa = new HerniMapa();
        Konzole k = new Konzole();
        Inventar inventar = new Inventar();
        for (int i = 0;i < inventar.getMesta().size();i++){
            if (herniMapa.getSoucasnaLokace().equals(inventar.getMesta().get(i).getNazev())){
                herniMapa.NactiMapu(2);
                System.out.println(herniMapa.vypisSoucasnePolohy());
                k.startHrad();
                return "Vyšel jsi z hradu";
            }
        }
        if (herniMapa.getSoucasnaLokace().contains("hrad")){
            return "tento hrad nevlastníš";
        }
        return "Nemáš kam vejít";
    }
    public  boolean exit(){
        return false;
    }
}
