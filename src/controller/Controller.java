package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    // Hotel

    public static Hotel createHotel(String hotelnavn, int pris, int dobbeltpris){
        Hotel hotel = new Hotel(hotelnavn,pris,dobbeltpris);
        Storage.storeHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHoteller(){
        return Storage.getHoteller();
    }


    // Udflugt

    public static Udflugt createUdflugt(String beskrivelse, LocalDate dato, int pris, Konference konference){
        Udflugt udflugt = new Udflugt(beskrivelse, dato, pris, konference);
        Storage.storeUdflugt(udflugt);
        return udflugt;
    }

    public static ArrayList<Udflugt> getUdflugter(){
        return Storage.getUdflugter();
    }


    // Konference

    public static Konference createKonference(String sted, LocalDate startDato, LocalDate slutDato, int pris){
        Konference konference = new Konference(sted, startDato, slutDato, pris);
        Storage.storeKonference(konference);
        return konference;
    }

    public static ArrayList<Konference> getKonferencer(){
        return Storage.getKonferencer();
    }


    // Deltager

    public static Deltager createDeltager(String navn, String adresse, String byEllerLand, int tlfNr, boolean erForedragsholder, LocalDate ankomstdato, LocalDate afrejsedato, Konference konference){
        Deltager deltager = new Deltager(navn, adresse, byEllerLand, tlfNr, erForedragsholder, ankomstdato, afrejsedato, konference);
        Storage.storeDeltager(deltager);
        return deltager;
    }

    public static ArrayList<Deltager> getDeltagere(){
        return Storage.getDeltagere();
    }


    // opret konference: add metoder

    public static void addHotelTilKonference(Konference konference, ArrayList<Hotel> hoteller){
        konference.tilføjHotel(hoteller);
    }

    public static Tillæg createAndAddTillægTilHotel(Hotel hotel, String navn, int pris){
        return hotel.createTillæg(navn, pris);
    }


    // opret tilmelding: add metoder

    public static void addHotelTilDeltager(Hotel hotel, Deltager deltager){
        deltager.setHotel(hotel);
    }

    public static void addTillægTilDeltager(Tillæg tillæg, Deltager deltager){
        deltager.addTillæg(tillæg);
    }

    public static Ledsager createAndAddLedsagerTilDeltager(Deltager deltager, String navn){
        return deltager.createLedsager(navn);
    }

    public static void addUdflugtTilLedsagerPåDeltager(Udflugt udflugt, Deltager deltager){
        deltager.getLedsager().addUdflugt(udflugt);
    }


    // oversigter

    public static ArrayList<String> getDeltagereStringForKonference(Konference konference) {
        ArrayList<String> deltagerListe = new ArrayList<>();

        ArrayList<Deltager> deltagere = konference.getDeltagere();
        for(int i = 0; i < deltagere.size(); i++){
            String navn = deltagere.get(i).getNavn();
            deltagerListe.add(navn);

            String byEllerLand = deltagere.get(i).getByEllerLand();
            deltagerListe.add(byEllerLand);

            String tlf = Integer.toString(deltagere.get(i).getTlfNr());
            deltagerListe.add(tlf);

            String foredragsholder = "Er ikke foredragsholder";
            if(deltagere.get(i).isErForedragsholder()){
                foredragsholder = "Er foredragsholder";
            }
            deltagerListe.add(foredragsholder);

            String deltagerdatoer = "Deltager fra " + deltagere.get(i).getAnkomstdato().toString() +
                    " til " + deltagere.get(i).getAfrejsedato().toString();
            deltagerListe.add(deltagerdatoer);

            if(deltagere.get(i).getFirmanavn() != null){
                String firmanavn = deltagere.get(i).getFirmanavn();
                deltagerListe.add("Firma: " + firmanavn);
            }
        }

        return deltagerListe;
    }

    public static ArrayList<String> getUdflugterStringForKonference(Konference konference) {
        ArrayList<String> udflugtListe = new ArrayList<>();

        ArrayList<Udflugt> udflugter = konference.getUdflugter();
        for(int i = 0; i < udflugter.size(); i++){
            udflugtListe.add(udflugter.get(i).getBeskrivelse());

            udflugtListe.add("Deltagende ledsagere:");
            for(Ledsager ledsager : udflugter.get(i).getLedsagere()){
                String ledsagernavn = ledsager.getNavn();
                String deltagernavn = ledsager.getDeltager().getNavn();
                String deltagertlf = Integer.toString(ledsager.getDeltager().getTlfNr());
                udflugtListe.add(ledsagernavn + " (" + deltagernavn + " " + deltagertlf + ")");
            }
        }

        return udflugtListe;
    }

    public static ArrayList<String> getHotellerStringForKonference(Konference konference) {
        ArrayList<String> hotelListe = new ArrayList<>();

        ArrayList<Hotel> hoteller = konference.getHoteller();
        for(int i = 0; i < hoteller.size(); i++){
            if(!hoteller.get(i).getDeltagere().isEmpty()){
                hotelListe.add(hoteller.get(i).getHotelnavn());
            }

            for(Deltager deltager : hoteller.get(i).getDeltagere()){
                String deltagernavn = deltager.getNavn();
                String ledsagernavn = "";
                if(deltager.getLedsager() != null){
                    ledsagernavn = " og " + deltager.getLedsager().getNavn();
                }
                hotelListe.add("Booking: " + deltagernavn + ledsagernavn);

                for(Tillæg tillæg : deltager.getTillæg()){
                    hotelListe.add("tillæg: " + tillæg.getNavn());
                }
            }
        }

        return hotelListe;
    }
}
