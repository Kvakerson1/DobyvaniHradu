package PrikazyMimoHrad;

import Konzole.Command;

public class Pomoc extends Command {
    public  String execute(){
        return "sever, vychod, jih, zapad, pomoc, vejdi, inventar, konec";
    }
    public  boolean exit(){
        return false;
    }
}
