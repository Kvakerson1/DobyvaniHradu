package PrikazyHrad;

import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;
import Mapa.Lokace;
import MestaADoly.Budova;
import MestaADoly.Mesto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Postav extends Command {
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        Mesto m = new Mesto();
        for (int i = 0; i < inventar.getMesta().size();i++){
            if (inventar.getMesta().get(i).getNazev().equals(h.getLokaceNaMape())){
                m = inventar.getMesta().get(i);
            }
        }
        if (h.getSoucasnaLokace().contains("budova")){
            if (m.getBudova(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6)))-1) != null){
                System.out.println("Zde už budova stojí");
            }
            try (BufferedReader br = new BufferedReader(new FileReader("seznamBudov.txt"))){
                System.out.println("Kterou budovu chcete postavit?");
                String line;
                line = br.readLine();
                System.out.println(line);
                Scanner sc = new Scanner(System.in);
                String budova = sc.next();
                while ((line = br.readLine()) != null) {
                    String[] lines = line.split(" ");
                    if (lines[0].equals(budova)){
                        if (Integer.parseInt(lines[2]) < inventar.getPenize()){
                            inventar.odebraniPenez(Integer.parseInt(lines[2]));
                            m.postavBudovu(Integer.parseInt(String.valueOf(h.getSoucasnaLokace().charAt(6)))-1, new Budova(lines[0],lines[1]));
                            return "Budova postavena";
                        }else {
                            return "Nedostatek penez";
                        }
                    }
                }
            }catch (IOException e){
                return "Doslo k chybe";
            }
            return "Tato budova neexistuje";
        }
        return "Zde nelze stavet";
    }
    public  boolean exit(){
        return false;
    }
}
