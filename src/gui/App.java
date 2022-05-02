package gui;

import controller.Controller;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }

    public static void initStorage(){
        Konference k1 = Controller.createKonference("Odense Universitet", LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 18), 1500);

        Hotel h1 = Controller.createHotel("Den Hvide Svane", 1050, 1250);
        Hotel h2 = Controller.createHotel("Hotel Phønix", 700, 800);
        Hotel h3 = Controller.createHotel("Pension Tusindfryd", 500, 600);
        Controller.addHotelTilKonference(k1,new ArrayList<>(List.of(h1,h2,h3)));

        Tillæg t1 = Controller.createAndAddTillægTilHotel(h1, "DVS-WIFI",50);
        Tillæg t2 = Controller.createAndAddTillægTilHotel(h2, "HP-Bad", 200);
        Tillæg t3 = Controller.createAndAddTillægTilHotel(h2, "HP-WIFI", 75);
        Tillæg t4 = Controller.createAndAddTillægTilHotel(h3, "PT-Mad", 100);

        Udflugt u1 = Controller.createUdflugt("Byrundtur Odense", LocalDate.of(2021, 12, 18), 125, k1);
        Udflugt u2 = Controller.createUdflugt("Egeskov", LocalDate.of(2021, 12, 19), 75, k1);
        Udflugt u3 = Controller.createUdflugt("Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20), 200, k1);

        Deltager d1 = Controller.createDeltager("Finn Madsen", "Bogfinkevej 420", "København", 88888888, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);

        Deltager d2 = Controller.createDeltager("Niels Petersen", "Aggervej 22", "Agger", 21212121, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        Controller.addHotelTilDeltager(h1, d2);

        Deltager d3 = Controller.createDeltager("Ulla Hansen", "Romvej 99", "Sønderborg", 11223344, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 19), k1);
        Controller.createAndAddLedsagerTilDeltager(d3, "Hans Hansen");
        Controller.addUdflugtTilLedsagerPåDeltager(u1, d3);

        Deltager d4 = Controller.createDeltager("Peter Sommer", "Nørrebrogade 47", "København", 20202020, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        Controller.addHotelTilDeltager(h1, d4);
        Controller.addTillægTilDeltager(t1,d4);
        Controller.createAndAddLedsagerTilDeltager(d4, "Mie Sommer");
        Controller.addUdflugtTilLedsagerPåDeltager(u2, d4);
        Controller.addUdflugtTilLedsagerPåDeltager(u3, d4);

        Deltager d5 = Controller.createDeltager("Lone Jensen", "Stjernegade 1", "Aarhus", 12345678, true, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), k1);
        Controller.addHotelTilDeltager(h1, d5);
        Controller.addTillægTilDeltager(t1,d5);
        Controller.createAndAddLedsagerTilDeltager(d5, "Jan Madsen");
        Controller.addUdflugtTilLedsagerPåDeltager(u2, d5);
        Controller.addUdflugtTilLedsagerPåDeltager(u1, d5);
    }
}