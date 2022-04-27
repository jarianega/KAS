package storage;

import model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();
    private static final ArrayList<Tillæg> tillæg = new ArrayList<>();
    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();
    // private static final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    // Hotel

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void storeHotel(Hotel hotel){
        hoteller.add(hotel);
    }

    /*public static void deleteHotel(Hotel hotel){
        hoteller.remove(hotel);
    }*/

    // Tillæg

    public static ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public static void storeTillæg(Tillæg tillæg){
        Storage.tillæg.add(tillæg);
    }

    /*public static void deleteTillæg(Tillæg tillæg){
        Storage.tillæg.remove(tillæg);
    }*/

    // Udflugt

    public static ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public static void storeUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    /*public static void deleteUdflugt(Udflugt udflugt){
        udflugter.remove(udflugt);
    }*/

    // Konference

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void storeKonference(Konference konference){
        konferencer.add(konference);
    }

    /*public static void deleteKonference(Konference konference){
        konferencer.remove(konference);
    }*/

    // Deltager

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static void storeDeltager(Deltager deltager){
        deltagere.add(deltager);
    }

    /*public static void deleteDeltager(Deltager deltager){
        deltagere.remove(deltager);
    }*/

    // Ledsager

    /*public static ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public static void storeLedsager(Ledsager ledsager){
        ledsagere.add(ledsager);
    }

    *//*public static void deleteLedsager(Ledsager ledsager){
        ledsagere.remove(ledsager);
    }*/
}
