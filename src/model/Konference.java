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

    public Konference(String sted, LocalDate startDato, LocalDate slutDato, ArrayList<Hotel> hoteller, ArrayList<Udflugt> udflugter, int pris) {
        this.sted = sted;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.hoteller = hoteller;
        this.udflugter = udflugter;
        this.pris = pris;
    }

    public void tilføjHotel(ArrayList<Hotel> hoteller) { this.hoteller.addAll(hoteller); }

    public void tilføjUdflugt(ArrayList<Udflugt> udflugter) { this.udflugter.addAll(udflugter); }

    public int getPris() {
        return pris;
    }

    // lister

    public ArrayList<String> getDeltagereString() {
        ArrayList<String> deltagerListe = new ArrayList<>();
        for(int i = 0; i < deltagere.size(); i++){
            deltagerListe.add("Deltager " + i+1);

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
                    "til " + deltagere.get(i).getAfrejsedato().toString();
            deltagerListe.add(deltagerdatoer);

            String firmanavn = deltagere.get(i).getFirmanavn();
            deltagerListe.add("Firma: " + firmanavn);

            deltagerListe.add("\n");
        }

        return deltagerListe;
    }

    public ArrayList<String> getUdflugterString() {
        ArrayList<String> udflugtListe = new ArrayList<>();

        for(int i = 0; i < udflugter.size(); i++){
            udflugtListe.add("Udflugt " + i+1 + "\n Deltagende ledsagere:");

            for(Ledsager ledsager : udflugter.get(i).getLedsagere()){
                String ledsagernavn = ledsager.getNavn();
                String deltagernavn = ledsager.getDeltager().getNavn();
                String deltagertlf = Integer.toString(ledsager.getDeltager().getTlfNr());
                udflugtListe.add(ledsagernavn + "(" + deltagernavn + " " + deltagertlf + ")");
            }

            udflugtListe.add("\n");
        }

        return udflugtListe;
    }

    public ArrayList<String> getHotellerString() {
        ArrayList<String> hotelListe = new ArrayList<>();

        for(int i = 0; i < hoteller.size(); i++){
            hotelListe.add("Hotel" + i+1);

            for(Deltager deltager : hoteller.get(i).getDeltagere()){
                String deltagernavn = deltager.getNavn();
                String ledsagernavn = deltager.getLedsager().getNavn();
                hotelListe.add("Booking: " + deltagernavn +" og " + ledsagernavn + "\n");
            }
        }

        return hotelListe;
    }
}
