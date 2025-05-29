package PrikazyHradIMimoHrad;

import Hrac.Inventar;
import Konzole.Command;

public class VypisInventare extends Command {
    /**
     * vypise inventar
     * @return vypis inventare
     */
    public  String execute(){
        Inventar i = new Inventar();
        return i.toString();
    }
    public  boolean exit(){
        return false;
    }
}
