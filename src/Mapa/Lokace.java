package Mapa;

public class Lokace {
    //nazev lokace + nazvy sousednich lokaci
    private String nazevLokace;
    private String sever;
    private String vychod;
    private String jih;
    private String zapad;

    public Lokace(String nazevLokace, String sever, String vychod, String jih, String zapad) {
        this.nazevLokace = nazevLokace;
        this.sever = sever;
        this.vychod = vychod;
        this.jih = jih;
        this.zapad = zapad;
    }

    public Lokace() {
    }

    public String getNazevLokace() {
        return nazevLokace;
    }

    public String getSever() {
        return sever;
    }

    public String getVychod() {
        return vychod;
    }

    public String getJih() {
        return jih;
    }

    public String getZapad() {
        return zapad;
    }

    @Override
    public String toString() {
        return  "nazevLokace:" + nazevLokace +
                ", sever:" + sever +
                ", vychod:" + vychod  +
                ", jih:" + jih +
                ", zapad:" + zapad;
    }
}
