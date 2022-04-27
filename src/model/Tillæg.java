package model;

import java.util.ArrayList;

public class Tillæg {
    public String navn;
    public int pris;
    ArrayList<Deltager> deltagere = new ArrayList<>();
    Hotel hotel;

    Tillæg(String navn, int pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public int getPris() {
        return pris;
    }

    public String getNavn() {
        return navn;
    }
}
