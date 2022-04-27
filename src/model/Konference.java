package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String sted;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Hotel> hoteller;
    private ArrayList<Udflugt> udflugter;
    ArrayList<Deltager> deltagere;
    private Organisation organisation;
    private int pris;

    public Konference(String sted, LocalDate startDato, LocalDate slutDato, ArrayList<Hotel> hoteller, ArrayList<Udflugt> udflugter) {
        this.sted = sted;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.hoteller = hoteller;
        this.udflugter = udflugter;
    }

    public void tilføjHotel(ArrayList<Hotel> hoteller) { this.hoteller.addAll(hoteller); }

    public void tilføjUdflugt(ArrayList<Udflugt> udflugter) { this.udflugter.addAll(udflugter); }

    public int getPris() {
        return pris;
    }
}
