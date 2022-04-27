package model;

import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){


        Konference k1 = new Konference(("Odense Universitet"),localDate.of(2021,12,18),localDate.of(2021,12,18),Arraylist<Hotel> hoteller,Arraylist<Tillæg> tillæg,1500);


        Deltager d1 = new Deltager("Finn Madsen", "Bogfinkevej 420", "København", 88888888, false, LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);

        Deltager d2 = new Deltager("Niels Petersen","Aggervej 22", "Agger", 21212121, false,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);
        Deltager d3 = new Deltager("Ulla Hansen","Romvej 99","Sønderborg",11223344,false, LocalDate.of(2021,12,18), LocalDate.of(2021,12,19), k1);
        Deltager d4 = new Deltager("Peter Sommer","Nørrebrogade 47", "København", 20202020,false,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);
        Deltager d5 = new Deltager("Lone Jensen","Stjernegade 1","Aarhus",12345678,true,LocalDate.of(2021,12,18), LocalDate.of(2021,12,20), k1);

        Tillæg t1 = new Tillæg("DVS-WIFI", 75);
        Tillæg t2 = new Tillæg("HP-Bad", 200);
        Tillæg t3 = new Tillæg("HP-WIFI",75);
        Tillæg t4 = new Tillæg("PT-Mad", 100);

        Hotel h1 = new Hotel("Den Hvide Svane", 1050, 1250,Arraylist<Deltager> deltagere, Arraylist<Tillæg> tillæg, t1);
        Hotel h2 = new Hotel("Hotel Phønix", 700, 800, Arraylist<Deltager> deltagere, Arraylist<Tillæg> tillæg, t2+t3);
        Hotel h3 = new Hotel("Pension Tusindfryd", 500, 600,Arraylist<Deltager> deltagere, Arraylist<Tillæg> tillæg, t4);







    }

}
