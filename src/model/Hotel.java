package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String hotelnavn;
    private LocalDate dato;
    private int hotelpris;
    private int dobbeltpris;
    private ArrayList<Deltager> deltagere;
    private ArrayList<Tillæg> tillæg;

    public Hotel(String hotelnavn, LocalDate dato, int hotelpris, int dobbeltpris, ArrayList<Deltager> deltagere, ArrayList<Tillæg> tillæg) {
        this.hotelnavn = hotelnavn;
        this.dato = dato;
        this.hotelpris = hotelpris;
        this.dobbeltpris = dobbeltpris;
        this.deltagere = deltagere;
        this.tillæg = tillæg;

    }
    // getters

    public String getHotelnavn() {
        return hotelnavn;
    }
    public LocalDate getDato() {return dato;}
    public int getHotelpris() {return hotelpris;}
    public int getDobbeltpris(){return dobbeltpris;}

    // setters

    public void setNavn(String hotelnavn) {this.hotelnavn = hotelnavn;}
    public void setDato(LocalDate dato) {this.dato = dato;}
    public void setHotelpris(int hotelpris) {this.hotelpris = hotelpris;}
    public void setDobbeltpris(int dobbeltpris) {this.dobbeltpris = dobbeltpris;}

}






