package storage;

import model.*;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Hotel> hoteller = new ArrayList<>();
    private static final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Deltager> deltagere = new ArrayList<>();

    // Hotel

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void storeHotel(Hotel hotel){
        hoteller.add(hotel);
    }


    // Udflugt

    public static ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public static void storeUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }


    // Konference

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void storeKonference(Konference konference){
        konferencer.add(konference);
    }


    // Deltager

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static void storeDeltager(Deltager deltager){
        deltagere.add(deltager);
    }
}
