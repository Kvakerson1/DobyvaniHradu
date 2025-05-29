package PrikazyMimoHrad;

import Konzole.Command;

public class Pomoc extends Command {
    /**
     * vypise vsechny prikazy co jdou pouzit mimo hrad
     * @return vsechny prikazy co jdou pouzit mimo hrad
     */
    public  String execute(){
        return "sever, vychod, jih, zapad, pomoc, vejdi, inventar, zautoc, popis, vylepsi, konectahu, konec";
    }
    public  boolean exit(){
        return false;
    }
}
