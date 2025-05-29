package PrikazyHrad;

import Konzole.Command;
import Mapa.HerniMapa;

public class PomocHrad extends Command {
    /**
     * vypise vsechny prikazy co jdou pouzit na hrade
     * @return vsechny prikazy co jdou pouzit na hrade
     */
    public  String execute(){

        return "sever, vychod, jih, zapad, pomoc, postav, vycvic, vylepsi, popis, inventar, odejdi";
    }
    public  boolean exit(){
        return false;
    }
}
