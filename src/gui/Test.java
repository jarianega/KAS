package gui;

import controller.Controller;
import model.*;
import storage.Storage;

import javax.lang.model.util.ElementKindVisitor14;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        Konference k1 = Controller.createKonference("Odense Universitet", LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 18), 1500);

        Tillæg t1 = Controller.createTillæg("DVS-WIFI", 50);
        Tillæg t2 = Controller.createTillæg("HP-Bad", 200);
        Tillæg t3 = Controller.createTillæg("HP-WIFI", 75);
        Tillæg t4 = Controller.createTillæg("PT-Mad", 100);

        Hotel h1 = Controller.createHotel("Den Hvide Svane", 1050, 1250, new ArrayList < Tillæg >(List.of(t1)));
        Hotel h2 = Controller.createHotel("Hotel Phønix", 700, 800,  new ArrayList < Tillæg >(List.of(t2 , t3)));
        Hotel h3 = Controller.createHotel("Pension Tusindfryd", 500, 600, new ArrayList < Tillæg > (List.of(t4)));
        Controller.addHotelTilKonference(k1,new ArrayList<>(List.of(h1,h2,h3)));

        Udflugt u1 = Controller.createUdflugt("Byrundtur Odense", LocalDate.of(2021, 12, 18), 125, k1);
        Udflugt u2 = Controller.createUdflugt("Egeskov", LocalDate.of(2021, 12, 19), 75, k1);
        Udflugt u3 = Controller.createUdflugt("Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20), 200, k1);


        Deltager d1 = Controller.createDeltager("Finn Madsen", "Bogfinkevej 420", "København", 88888888, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        System.out.println(d1.beregnSamletPris());

        Deltager d2 = Controller.createDeltager("Niels Petersen", "Aggervej 22", "Agger", 21212121, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        Controller.addHotelTilDeltager(h1, d2);
        System.out.println(d2.beregnSamletPris());

        Deltager d3 = Controller.createDeltager("Ulla Hansen", "Romvej 99", "Sønderborg", 11223344, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 19), k1);
        Controller.addLedsagerTilDeltager(d3, "Hans Hansen");
        Controller.addUdflugtTilLedsagerPåDeltager(u1, d3);
        System.out.println(d3.beregnSamletPris());

        Deltager d4 = Controller.createDeltager("Peter Sommer", "Nørrebrogade 47", "København", 20202020, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        Controller.addHotelTilDeltager(h1, d4);
        Controller.addTillægTilDeltager(t1,d4);
        Controller.addLedsagerTilDeltager(d4, "Mie Sommer");
        Controller.addUdflugtTilLedsagerPåDeltager(u2, d4);
        Controller.addUdflugtTilLedsagerPåDeltager(u3, d4);
        System.out.println(d4.beregnSamletPris());

        Deltager d5 = Controller.createDeltager("Lone Jensen", "Stjernegade 1", "Aarhus", 12345678, true, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        Controller.addHotelTilDeltager(h1, d5);
        Controller.addTillægTilDeltager(t1,d5);
        Controller.addLedsagerTilDeltager(d5, "Jan Madsen");
        Controller.addUdflugtTilLedsagerPåDeltager(u2, d5);
        Controller.addUdflugtTilLedsagerPåDeltager(u1, d5);
        System.out.println(d5.beregnSamletPris());

        System.out.println(k1.getDeltagereString());
        System.out.println(k1.getUdflugterString());
        System.out.println(k1.getHotellerString());
    }
}
