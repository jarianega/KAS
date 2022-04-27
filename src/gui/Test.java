package gui;

import controller.Controller;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){


       Controller.createKonference("Odense Universitet"),localDate.of(2021,12,18),localDate.of(2021,12,18),Arraylist<Hotel> hoteller,Arraylist<Udflugter> udflugter,1500);

        Deltager d1 = Controller.createDeltager("Finn Madsen", "Bogfinkevej 420", "København", 88888888, false, LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);
        d1.setHotel(h1);

        Deltager d2 = Controller.createDeltager("Niels Petersen","Aggervej 22", "Agger", 21212121, false,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);
        Deltager d3 = Controller.createDeltager("Ulla Hansen","Romvej 99","Sønderborg",11223344,false, LocalDate.of(2021,12,18), LocalDate.of(2021,12,19), k1);
        Deltager d4 = Controller.createDeltager("Peter Sommer","Nørrebrogade 47", "København", 20202020,false,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);)
        Deltager d5 = Controller.createDeltager("Lone Jensen","Stjernegade 1","Aarhus",12345678,true,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);
        Deltager d6 = Controller.createDeltager("Niels Petersen","Aggervej 22", "Agger", 21212121, false,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);

        Tillæg t1 = Controller.createTillæg("DVS-WIFI", 75);
        Tillæg t2 = Controller.createTillæg("HP-Bad", 200);
        Tillæg t3 = Controller.createTillæg("HP-WIFI",75);
        Tillæg t4 = Controller.createTillæg("PT-Mad", 100);

        Hotel h1 = Controller.createHotel("Den Hvide Svane", 1050, 1250,Arraylist<Deltager> deltagere, Arraylist<Tillæg> tillæg,t1);
        Hotel h2 = Controller.createHotel("Hotel Phønix", 700, 800, Arraylist<Deltager> deltagere, Arraylist<Tillæg> tillæg, t2+t3);
        Hotel h3 = Controller.createHotel("Pension Tusindfryd", 500, 600,Arraylist<Deltager> deltagere, Arraylist<Tillæg> tillæg, t4);









    }

}
