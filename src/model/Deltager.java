package model;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Deltager {
    private final String navn;
    private final String adresse;
    private final String byEllerLand;
    private final int tlfNr;
    private final boolean erForedragsholder;
    private final LocalDate ankomstdato;
    private final LocalDate afrejsedato;
    private String firmanavn;
    private int firmaTlfNr;
    private Ledsager ledsager;
    private final Konference konference;
    private Hotel hotel;
    private ArrayList<Tillæg> tillæg;

    public Deltager(String navn, String adresse, String byEllerLand, int tlfNr, boolean erForedragsholder, LocalDate ankomstdato, LocalDate afrejsedato, Konference konference) {
        this.navn = navn;
        this.adresse = adresse;
        this.byEllerLand = byEllerLand;
        this.tlfNr = tlfNr;
        this.erForedragsholder = erForedragsholder;
        this.ankomstdato = ankomstdato;
        this.afrejsedato = afrejsedato;
        this.konference = konference;
        konference.deltagere.add(this);
    }

    // getters

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getByEllerLand() {
        return byEllerLand;
    }

    public int getTlfNr() {
        return tlfNr;
    }

    public boolean isErForedragsholder() {
        return erForedragsholder;
    }

    public LocalDate getAnkomstdato() {
        return ankomstdato;
    }

    public LocalDate getAfrejsedato() {
        return afrejsedato;
    }

    public String getFirmanavn() {
        return firmanavn;
    }

    public int getFirmaTlfNr() {
        return firmaTlfNr;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public Konference getKonference() {
        return konference;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }

    // setters, begge nullable

    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
    }

    public void setFirmaTlfNr(int firmaTlfNr) {
        this.firmaTlfNr = firmaTlfNr;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    // add tillæg

    public void addTillæg(Tillæg tillæg){
        this.tillæg.add(tillæg);
    }

    // create ledsager, nullable

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        this.ledsager = ledsager;
        ledsager.deltager = this;
        return ledsager;
    }

    // beregn samlet pris

    public int beregnSamletPris() {
        int pris = 0;

        if (firmanavn == null && !erForedragsholder) {
            pris += konference.getPris();
        }

        long antalOvernatninger = DAYS.between(ankomstdato, afrejsedato);
        if (ledsager != null) {
            for (Udflugt udflugt : ledsager.getUdflugter()) {
                pris += udflugt.getPris();
            }
            pris += hotel.getDobbeltpris() * antalOvernatninger;
            for (Tillæg tillæg : tillæg) {
                    pris += tillæg.getPris();
            }
        } else {
            pris += hotel.getPris() * antalOvernatninger;
            for (Tillæg tillæg : tillæg) {
                    pris += tillæg.getPris();
            }
        }
        return pris;
    }
}