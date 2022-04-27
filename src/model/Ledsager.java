package model;

import java.util.ArrayList;

public class Ledsager {
    private final String navn;
    private ArrayList<Udflugt> udflugter;

    Ledsager(String navn){
        this.navn = navn;
        this.udflugter = new ArrayList<>();
    }

    // getters

    public String getNavn() {
        return navn;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    // add udflugt

    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
        udflugt.ledsagere.add(this);
    }

    // beregn samlet pris for udflugter

    public int beregnPrisForUdflugter(){
        int pris = 0;
        for(Udflugt udflugt : udflugter){
            pris = pris + udflugt.getPris();
        }
        return pris;
    }
}
