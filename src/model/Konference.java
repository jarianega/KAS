package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String sted;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    ArrayList<Udflugt> udflugter = new ArrayList<>();
    ArrayList<Deltager> deltagere = new ArrayList<>();
    private Organisation organisation;
    private int pris;

    public Konference(String sted, LocalDate startDato, LocalDate slutDato, int pris) {
        this.sted = sted;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
    }

    public void tilføjHotel(ArrayList<Hotel> hoteller) { this.hoteller.addAll(hoteller); }

    public void tilføjUdflugt(ArrayList<Udflugt> udflugter) { this.udflugter.addAll(udflugter); }

    public int getPris() {
        return pris;
    }

    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }
}