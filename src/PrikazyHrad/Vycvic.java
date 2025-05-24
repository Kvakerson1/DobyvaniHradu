package PrikazyHrad;

import Armada.Jednotka;
import Armada.Jednotky;
import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;
import MestaADoly.Budova;
import MestaADoly.BudovyVeKterychSeCvici;
import MestaADoly.Mesto;

import java.util.Scanner;

public class Vycvic extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        Jednotky jednotky = new Jednotky();
        Mesto m = new Mesto();
        for (int i = 0; i < inventar.getMesta().size();i++){
            if (inventar.getMesta().get(i).getNazev().equals(h.getLokaceNaMape())){
                m = inventar.getMesta().get(i);
            }
        }
        if (h.getSoucasnaLokace().contains("budova")) {
            if (m.getBudova(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6))) - 1) == null) {
                return "Zde nestoji zadna budova";
            }
            Budova b = m.getBudova(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6))) - 1);
            Jednotka j = new Jednotka();
            for (int i = 0; i < jednotky.getJednotky().size();i++){
                if (b.getTypJedntek().equals(jednotky.getJednotky().get(i).getNazev())){
                    j = jednotky.getJednotky().get(i);
                }
            }
            for (int i = 0;i < jednotky.getBudovy().size(); i++){
                if (h.getLokaceNaMape().equals(jednotky.getBudovy().get(i).getMesto()) && Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6))) == jednotky.getBudovy().get(i).getPozice()){
                    return  "Zde uz se cvici";
                }
            }
            try {
                System.out.println("Cena " + j.getNazev() + " je " + j.getCena() + " a maximalne jich muzete vycvicit " + b.getLvl() + "\nKolik jich chcete vycvicit?");
                Scanner sc = new Scanner(System.in);
                int pocet = sc.nextInt();
                if (pocet > b.getLvl()){
                    return "Tolik jednotek vycvicit nelze";
                }
                if (pocet*j.getCena() <= inventar.getPenize()){
                    for (int i = 0;i < pocet;i++){
                        jednotky.pridatJednotkuNaVycvik(j);
                    }
                    inventar.odebraniPenez(pocet*j.getCena());
                    jednotky.getBudovy().add(new BudovyVeKterychSeCvici(h.getLokaceNaMape(),Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6)))));
                    return "Jednotky se cvici";
                }
                return "Nedostatek penez";
            }catch (Exception e){
                return"Neco se pokazilo";
            }
        }

        return "Zde nestoji zadna budova";
    }
    public  boolean exit(){
        return false;
    }

}
