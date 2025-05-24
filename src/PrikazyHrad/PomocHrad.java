package PrikazyHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class PomocHrad extends Command {
    public  String execute(){

        return "sever, vychod, jih, zapad, pomoc, postav, vycvic, vylepsi, popis, inventar, odejdi";
    }
    public  boolean exit(){
        return false;
    }
}
