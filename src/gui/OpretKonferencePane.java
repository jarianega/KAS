package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class OpretKonferencePane extends GridPane {

    private final TextField txfKonferenceNavn = new TextField("Navn på konferencen");
    private final TextField txfAdresse = new TextField("Adresse");
    private final TextField txfStartDato = new TextField("Startdato på konferencen");
    private final TextField txfSlutDato = new TextField("Slutdato på konferencen");
    private final TextField txfOrganisation = new TextField("Organisation");
    private final TextField txfPris = new TextField("Pris per dag");
    private final Button btnOpretHotel = new Button("Opret Hotel");
    private final Button btnOpretUdflugt = new Button("Opret Udflugt");
    private final Button btnOpretKonference = new Button ("Opret Konference");



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
        this.add(btnOpretKonference,0,6);
        this.add(btnOpretHotel,0,10);
        this.add(btnOpretUdflugt,0,14);
        
        btnOpretHotel.setOnAction(event -> this.HotelAction());
        btnOpretUdflugt.setOnAction(event -> this.udflugtAction());
        


    }

    private void HotelAction() {
        OpretHotelWindow dialog = new OpretHotelWindow();
        dialog.showAndWait();
    }


    private void udflugtAction() {
        OpretUdflugtWindow dialog = new OpretUdflugtWindow();
        dialog.showAndWait();
    }

}


