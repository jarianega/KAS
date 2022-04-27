package controller;

import model.*;
import org.jetbrains.annotations.NotNull;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    // Hotel

    public static Hotel createHotel(String hotelnavn, int pris, int dobbeltpris, ArrayList<Deltager> deltagere, ArrayList<Tillæg> tillæg){
        Hotel hotel = new Hotel(hotelnavn,pris,dobbeltpris, deltagere, tillæg);
        Storage.storeHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHoteller(){
        return Storage.getHoteller();
    }

    /*public static void deleteHotel(Hotel hotel){
        Storage.deleteHotel(hotel);
    }*/

    // Tillæg

    public static Tillæg createTillæg(String navn, int pris){
        Tillæg tillæg = new Tillæg(navn,pris);
        Storage.storeTillæg(tillæg);
        return tillæg;
    }

    public static ArrayList<Tillæg> getTillæg(){
        return Storage.getTillæg();
    }

    /*public static void deleteTillæg(Tillæg tillæg){
        Storage.deleteTillæg(tillæg);
    }*/

    // Udflugt

    public static Udflugt createUdflugt(String beskrivelse, LocalDate dato, int pris){
        Udflugt udflugt = new Udflugt(beskrivelse, dato,pris);
        Storage.storeUdflugt(udflugt);
        return udflugt;
    }

    public static ArrayList<Udflugt> getUdflugter(){
        return Storage.getUdflugter();
    }

    /*public static void deleteUdflugt(Udflugt udflugt){
        Storage.deleteUdflugt(udflugt);
    }*/

    // Konference

    public static Konference createKonference(String sted, LocalDate startDato, LocalDate slutDato, ArrayList<Hotel> hoteller, ArrayList<Udflugt> udflugter, int pris){
        Konference konference = new Konference(sted, startDato, slutDato, hoteller, udflugter, pris);
        Storage.storeKonference(konference);
        return konference;
    }

    public static ArrayList<Konference> getKonferencer(){
        return Storage.getKonferencer();
    }

    /*public static void deleteKonference(Konference konference){
        Storage.deleteKonference(konference);
    }*/

    // Deltager

    public static Deltager createDeltager(String navn, String adresse, String byEllerLand, int tlfNr, boolean erForedragsholder, LocalDate ankomstdato, LocalDate afrejsedato, Konference konference){
        Deltager deltager = new Deltager(navn, adresse, byEllerLand, tlfNr, erForedragsholder, ankomstdato, afrejsedato, konference);
        Storage.storeDeltager(deltager);
        return deltager;
    }

    public static ArrayList<Deltager> getDeltagere(){
        return Storage.getDeltagere();
    }

    /*public static void deleteDeltager(Deltager deltager){
        Storage.deleteDeltager(deltager);
    }*/

    // Ledsager

    /*public static Ledsager createLedsager(String navn){
        Ledsager ledsager = new Ledsager(navn);
        Storage.storeLedsager(ledsager);
        return ledsager;
    }

    public static ArrayList<Ledsager> getLedsagere(){
        return Storage.getLedsagere();
    }*/


    // opret konference: add metoder

    public static void addHotelTilKonference(@NotNull Konference konference, ArrayList<Hotel> hoteller){
        konference.tilføjHotel(hoteller);
    }

    public static void addTillægTilHotel(Tillæg tillæg, Hotel hotel){
        hotel.getTillæg().add(tillæg);
    }

    public static void addUdflugtTilKonference(Konference konference, ArrayList<Udflugt> udflugter){
        konference.tilføjUdflugt(udflugter);
    }

    // opret tilmelding: add metoder

    public static void addHotelTilDeltager(Hotel hotel, Deltager deltager){
        deltager.setHotel(hotel);
    }

    public static void addTillægTilDeltager(Tillæg tillæg, Deltager deltager){
        deltager.addTillæg(tillæg);
    }

    public static void addUdflugtTilLedsagerPåDeltager(Udflugt udflugt, Deltager deltager){
        deltager.getLedsager().addUdflugt(udflugt);
    }
}
