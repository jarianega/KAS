package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String beskrivelse;
    private LocalDate dato;
    private int pris;
    ArrayList<Ledsager> ledsagere = new ArrayList<>();
    private Konference konference;

    public Udflugt(String beskrivelse, LocalDate dato, int pris, Konference konference){
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.pris = pris;
        this.konference = konference;
        konference.udflugter.add(this);
    }

    public String getBeskrivelse() { return this.beskrivelse; }

    public void setBeskrivelse(String beskrivelse) { this.beskrivelse = beskrivelse; }

    public LocalDate getDato() { return this.dato; }

    public void setDato(LocalDate dato) { this.dato = dato; }

    public int getPris() { return this.pris; }

    public void setPris(int pris) { this.pris = pris; }

    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }
}
