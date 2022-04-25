package model;

public class Ledsager {
    private String navn;
    private ArrayList<Udflugt> udflugter;

    Ledsager(String navn){
        this.navn = navn;
    }

    // getters

    public String getNavn() {
        return navn;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    // add udflugt

    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    // beregn pris for udflugter

    public int beregnPrisForUdflugter(){
        int pris = 0;
        for(Udflugt udflugt : udflugter){
            pris = pris + udflugt.getPris();
        }
        return pris;
    }
}
