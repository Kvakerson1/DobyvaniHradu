package Konzole;

import PrikazyHrad.*;
import PrikazyHradIMimoHrad.*;
import PrikazyMimoHrad.*;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {
    private boolean exit = false;
    private HashMap<String, Command> mapa = new HashMap<>();
    public void inicializace(){
        mapa.put("sever", new Sever());
        mapa.put("vychod", new Vychod());
        mapa.put("jih", new Jih());
        mapa.put("zapad", new Zapad());
        mapa.put("pomoc", new Pomoc());
        mapa.put("vejdi", new Vejdi());
        mapa.put("inventar", new VypisInventare());
        mapa.put("vylepsi", new VylepsiDul());
        mapa.put("konectahu", new KonecTahu());
        mapa.put("zautoc", new Zautoc());
        mapa.put("popis", new PopisMimoHrad());
        mapa.put("konec", new Konec());
    }
    public void inicializaceHrad(){
        mapa.put("sever", new Sever());
        mapa.put("vychod", new Vychod());
        mapa.put("jih", new Jih());
        mapa.put("zapad", new Zapad());
        mapa.put("odejdi", new Odejdi());
        mapa.put("pomoc", new PomocHrad());
        mapa.put("postav", new Postav());
        mapa.put("popis", new Popis());
        mapa.put("inventar", new VypisInventare());
        mapa.put("vycvic", new Vycvic());
        mapa.put("vylepsi", new VylepsiBudovu());
        mapa.put("konec", new Konec());
    }

    private Scanner scanner = new Scanner(System.in);
    private void proved(){
        System.out.print(">>");
        String prikaz = scanner.nextLine();
        prikaz = prikaz.trim();
        prikaz = prikaz.toLowerCase();
        if(mapa.containsKey(prikaz)){
            System.out.println(">> "+mapa.get(prikaz).execute());
            exit = mapa.get(prikaz).exit();
        }else{
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    public void start(){
        inicializace();
        try{
            do{
                proved();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void startHrad(){
        inicializaceHrad();
        try{
            do{
                proved();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
