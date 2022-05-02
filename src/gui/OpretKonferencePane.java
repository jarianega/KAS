package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.security.cert.PolicyNode;
import java.time.LocalDate;


public class OpretKonferencePane extends GridPane {

    private final TextField txfKonferenceNavn = new TextField("Navn på konferencen");
    private final TextField txfAdresse = new TextField("Adresse");
    private final TextField txfStartDato = new TextField("Startdato på konferencen");
    private final TextField txfSlutDato = new TextField("Slutdato på konferencen");
    private final TextField txfOrganisation = new TextField("Organisation");
    private final TextField txfPris = new TextField("Pris per dag");
    private final Button btnOpretHotel = new Button("Opret Hotel");
    private final Button btnOpretUdflugt = new Button("Opret Udflugt");
    private final TextField txfHotelNavn = new TextField("Hotelnavn");
    private final TextField txfHotelPris = new TextField("Pris enkeltværelse");
    private final TextField txfHotelDobbeltPris = new TextField ("Pris dobbeltværelse");
    private final TextField txfOpretTillæg = new TextField ("Opret tillæg");
    private final TextField txfOpretTillægPris = new TextField ("Pris på tillæg");
    private final TextField txfUdflugtBeskrivelse = new TextField ("Beskrivelse af udflugt");
    private final TextField txfUdflugtDato = new TextField ("Dato på udflugt");
    private final TextField txfUdflugtPris = new TextField ("Pris på udflugt");
    private final TextField txfTillæg2 = new TextField ("Tillæg 2");
    private final TextField txfTillæg3 = new TextField ("Tillæg 3");
    private final TextField txfTillæg4 = new TextField ("Tillæg 4");


    public OpretKonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.add(txfKonferenceNavn,0,0);
        this.add(txfAdresse,0,1);
        this.add(txfStartDato,0,2);
        this.add(txfSlutDato,0,3);
        this.add(txfOrganisation, 0, 4);
        this.add(txfPris,0,5);
        this.add(btnOpretHotel,0,10);
        this.add(txfHotelNavn,0,7);
        this.add(txfHotelPris,0,8);
        this.add(txfHotelDobbeltPris,1,8);
        this.add(txfOpretTillæg,0,9);
        this.add(txfOpretTillægPris,1,9);
        this.add(txfUdflugtBeskrivelse,0,11);
        this.add(txfUdflugtDato,0,12);
        this.add(txfUdflugtPris,0,13);
        this.add(btnOpretUdflugt,0,14);
        this.add(txfTillæg2,1,9);
        this.add(txfTillæg3,1,10);
        
        btnOpretHotel.setOnAction(event -> this.HotelAction());
        btnOpretUdflugt.setOnAction(event -> this.udflugtAction());
        


    }

    private void HotelAction() {
       String navn = txfHotelNavn.getText();
       int pris = txfHotelPris.getText();
       int dobbeltpris = txfHotelDobbeltPris();
        Controller.createHotel(navn,pris,dobbeltpris);


    }

    private void udflugtAction() {
        String udflugtBeskrivelse = txfUdflugtBeskrivelse.getText();
        LocalDate udflugtDato = LocalDate.parse(txfUdflugtDato.getText());
        int udflugtPris = Integer.parseInt(txfUdflugtPris.getText());
        Controller.createUdflugt(udflugtBeskrivelse, udflugtDato, udflugtPris, );
    }

}


