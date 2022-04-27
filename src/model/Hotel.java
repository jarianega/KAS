package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {
    private String hotelnavn;
    private int pris;
    private int dobbeltpris;
    private ArrayList<Deltager> deltagere;
    private ArrayList<Tillæg> tillæg;

    public Hotel(String hotelnavn, int pris, int dobbeltpris, ArrayList<Deltager> deltagere, ArrayList<Tillæg> tillæg) {
        this.hotelnavn = hotelnavn;
        this.pris = pris;
        this.dobbeltpris = dobbeltpris;
        this.deltagere = deltagere;
        this.tillæg = tillæg;

    }
    // getters

    public String getHotelnavn() {
        return hotelnavn;
    }
    public int getPris() {return pris;}
    public int getDobbeltpris(){return dobbeltpris;}

    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }

    public ArrayList<Deltager> getDeltagere() {
        return deltagere;
    }

    // setters

    public void setNavn(String hotelnavn) {this.hotelnavn = hotelnavn;}
    public void setPris(int pris) {this.pris = pris;}
    public void setDobbeltpris(int dobbeltpris) {this.dobbeltpris = dobbeltpris;}

}






