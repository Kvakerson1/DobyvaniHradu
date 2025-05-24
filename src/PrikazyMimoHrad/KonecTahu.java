package PrikazyMimoHrad;

import Armada.Jednotky;
import Hrac.Inventar;
import Konzole.Command;

import java.util.ArrayList;

public class KonecTahu extends Command {

    public  String execute(){
        Inventar inventar = new Inventar();
        Jednotky jednotky = new Jednotky();
        try {
            for (int i = 0; i < inventar.getDoly().size();i++){
                inventar.pridaniPenez(inventar.getDoly().get(i).getGeneruje());
            }

        }catch (Exception e){

        }

        try {
            for (int i = 0; i < jednotky.getVycvik().size();i++){
                inventar.pridejJednotku(jednotky.getVycvik().get(i));
            }
        }catch (Exception e){

        }
        jednotky.setBudovy(new ArrayList<>());
        jednotky.setVycvik(new ArrayList<>());
        return "Tah ukoncen";
    }
    public  boolean exit(){
        return false;
    }
}
