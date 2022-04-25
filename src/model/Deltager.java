package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Deltager {
    private final String navn;
    private final String adresse;
    private final String byEllerLand;
    private final int tlfNr;
    private boolean erForedragsholder;
    private LocalDate ankomstdato;
    private LocalDate afrejsedato;
    private String firmanavn;
    private String firmaTlfNr;
    private Ledsager ledsager;
    private final Konference konference;
    private Hotel hotel;

    public Deltager(String navn, String adresse, String byEllerLand, int tlfNr, boolean erForedragsholder, LocalDate ankomstdato, LocalDate afrejsedato, Konference konference){
        this.navn = navn;
        this.adresse = adresse;
        this.byEllerLand = byEllerLand;
        this.tlfNr = tlfNr;
        this.erForedragsholder = erForedragsholder;
        this.ankomstdato = ankomstdato;
        this.afrejsedato = afrejsedato;
        this.konference = konference;
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

    public boolean isErForedragsholder(){
        return erForedragsholder;
    }

    public int getAnkomstdato() {
        return ankomstdato;
    }

    public int getAfrejsedato() {
        return afrejsedato;
    }

    public String getFirmanavn() {
        return firmanavn;
    }

    public String getFirmaTlfNr() {
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

    // setters

    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
    }

    public void setFirmaTlfNr(String firmaTlfNr) {
        this.firmaTlfNr = firmaTlfNr;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    // create ledsager

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        this.ledsager = ledsager;
        return ledsager;
    }

    // beregn samlet pris

    public int beregnSamletPris(){
        return 0;
    }
}
