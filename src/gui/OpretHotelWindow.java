package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OpretHotelWindow extends Stage {
    private final TextField txfHotelNavn = new TextField("Hotelnavn");
    private final TextField txfHotelPris = new TextField("Pris enkeltværelse");
    private final TextField txfHotelDobbeltPris = new TextField ("Pris dobbeltværelse");
    Button btnTilføjTillæg = new Button("Tilføj tillæg");

    public OpretHotelWindow() {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle("Opret hotel");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(20);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        pane.add(txfHotelNavn,0,0);
        pane.add(txfHotelPris,0,1);
        pane.add(txfHotelDobbeltPris,1,1);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,0,2);
        btnOpret.setOnAction(event -> HotelAction());

        btnTilføjTillæg.setDisable(true);
        pane.add(btnTilføjTillæg, 1,2);
        btnTilføjTillæg.setOnAction(event -> tilføjTillægAction());
    }

    private void HotelAction() {
        String navn = txfHotelNavn.getText();
        int pris = Integer.parseInt(txfHotelPris.getText());
        int dobbeltpris = Integer.parseInt(txfHotelDobbeltPris.getText());
        Controller.createHotel(navn,pris,dobbeltpris);
        btnTilføjTillæg.setDisable(false);
    }

    private void tilføjTillægAction() {
        OpretTillægWindow dialog = new OpretTillægWindow();
        dialog.showAndWait();
    }
}
