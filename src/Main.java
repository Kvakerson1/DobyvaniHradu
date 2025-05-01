import Hrac.Inventar;
import Hrac.Mesto;
import Konzole.Konzole;
import Mapa.HerniMapa;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HerniMapa herniMapa = new HerniMapa();
        herniMapa.NactiMapu(1);
        Inventar i = new Inventar();
        Mesto m = new Mesto("hrad1");
        i.pridejMesto(m);
        System.out.println(herniMapa.vypisSoucasnePolohy());
        Konzole k = new Konzole();
        k.start();
    }
}