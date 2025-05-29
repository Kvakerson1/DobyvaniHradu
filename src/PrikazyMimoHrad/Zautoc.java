package PrikazyMimoHrad;

import Armada.Jednotka;
import Armada.NacteniObrany;
import Armada.PocitaniJednotek;
import Hrac.Inventar;
import Konzole.Command;
import Mapa.HerniMapa;
import MestaADoly.Doly;
import MestaADoly.Mesto;

import java.util.ArrayList;

public class Zautoc extends Command {
    /**
     * metoda pro souboj
     * @return kdo vyhral nebo duvod proc se souboj neuskutecnil
     */
    public  String execute(){
        HerniMapa h = new HerniMapa();
        Inventar inventar = new Inventar();
        NacteniObrany o = new NacteniObrany();
        Doly d = new Doly();
        if (!h.getSoucasnaLokace().contains("hrad") && !h.getSoucasnaLokace().contains("dul")){
            return "Zde neni na co utocit";
        }
        for (int i = 0; i < inventar.getMesta().size();i++){
            if (inventar.getMesta().get(i).getNazev().equals(h.getSoucasnaLokace())){
                return "Nemuzes zautocit na vlastni mesto";
            }
        }
        for (int i = 0; i < inventar.getDoly().size();i++){
            if (inventar.getDoly().get(i).getNazev().equals(h.getSoucasnaLokace())){
                return "Nemuzes zautocit na vlastni dul";
            }
        }
        if (inventar.getJednotky().isEmpty()){
            return "Nemas zadne vojaky, co by zautocily";
        }
        ArrayList<PocitaniJednotek> hrac = inventar.pocetJednotek();
        ArrayList<PocitaniJednotek> obrana = o.vypis(h.getSoucasnaLokace());
        for (int i = 0; i < hrac.size();i++){
            for (int j = 0; j < obrana.size(); j++){
                if (hrac.get(i).getJednotka().equals(obrana.get(j).getJednotka())){
                    if (hrac.get(i).getPocet() >= obrana.get(j).getPocet()){
                        hrac.get(i).snizPocet(obrana.get(j).getPocet());
                        obrana.get(i).setPocet(0);
                    }else {
                        obrana.get(i).snizPocet(hrac.get(j).getPocet());
                        hrac.get(i).setPocet(0);
                    }
                }
            }
        }
        int celkovaSilaHrac = 0;
        int celkovaSilaObrana = 0;
        for (int i = 0; i < hrac.size();i++){
            celkovaSilaHrac+=hrac.get(i).celkovaSila();
        }
        for (int i = 0; i < obrana.size();i++){
            celkovaSilaObrana+=obrana.get(i).celkovaSila();
        }
        if (celkovaSilaHrac == celkovaSilaObrana){
            inventar.setJednotky(new ArrayList<>());
            if (h.getSoucasnaLokace().contains("hrad")){
                inventar.pridejMesto(new Mesto(h.getSoucasnaLokace()));
            }else {
                for (int i = 0; i < d.getDoly().size();i++){
                    if (d.getDoly().get(i).getNazev().equals(h.getSoucasnaLokace())){
                        inventar.pridejDul(d.getDoly().get(i));
                    }
                }
            }
            return "Hrac vyhral";
        }
        if (celkovaSilaHrac > celkovaSilaObrana){
            for (int i = 0; i < hrac.size(); i++){
                while(hrac.get(i).getPocet() > 0 && hrac.get(i).getJednotka().getSila() < celkovaSilaObrana){
                    hrac.get(i).snizPocet(1);
                    celkovaSilaObrana-= hrac.get(i).getJednotka().getSila();
                }
            }
            inventar.setJednotky(new ArrayList<>());
            for (int i = 0; i < hrac.size();i++){
                for (int j = 0; j < hrac.get(i).getPocet();j++){
                    inventar.pridejJednotku(hrac.get(i).getJednotka());
                }
            }
            if (h.getSoucasnaLokace().contains("hrad")){
                inventar.pridejMesto(new Mesto(h.getSoucasnaLokace()));
            }else {
                for (int i = 0; i < d.getDoly().size();i++){
                    if (d.getDoly().get(i).getNazev().equals(h.getSoucasnaLokace())){
                        inventar.pridejDul(d.getDoly().get(i));
                    }
                }
            }
            return "Hrac vyhral";
        }
        if (celkovaSilaObrana > celkovaSilaHrac) {
            for (int i = 0; i < obrana.size(); i++) {
                while (obrana.get(i).getPocet() > 0 && obrana.get(i).getJednotka().getSila() < celkovaSilaHrac) {
                    obrana.get(i).snizPocet(1);
                    celkovaSilaHrac -= obrana.get(i).getJednotka().getSila();
                }
            }
            inventar.setJednotky(new ArrayList<>());
            boolean bylPridan;
            int cislo = 0;
            for (int i = 0; i < o.getObrana().size();i++){
                if (o.getObrana().get(i).getNazev().equals(h.getSoucasnaLokace())){
                    cislo = i;
                }
            }
            o.getObrana().get(cislo).setJednotky(new ArrayList<>());
            for (int i = 0; i < obrana.size();i++){
                for (int j = 0; j < obrana.get(i).getPocet();j++){
                    o.getObrana().get(cislo).pridejJednotku(obrana.get(i).getJednotka());
                }
            }
            return "Obrana vyhrala";
        }
        return "Doslo k chybe";

    }
    public  boolean exit(){
        return false;
    }
}
