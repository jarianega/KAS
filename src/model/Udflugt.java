package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String beskrivelse;
    private LocalDate dato;
    private int pris;
    private ArrayList<Ledsager> ledsager;

    public String getBeskrivelse() { return this.beskrivelse; }

    public void setBeskrivelse(String beskrivelse) { this.beskrivelse = beskrivelse; }

    public LocalDate getDato() { return this.dato; }

    public void setDato(LocalDate dato) { this.dato = dato; }

    public int getPris() { return this.pris; }

    public void setPris(int pris) { this.pris = pris; }
}
