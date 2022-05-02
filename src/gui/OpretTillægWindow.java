package gui;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;

public class OpretTillægWindow extends Stage {
    private final TextField txfOpretTillæg = new TextField ("Opret tillæg");
    private final TextField txfOpretTillægPris = new TextField ("Pris på tillæg");
    ComboBox cbHoteller = new ComboBox<>();

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

        pane.add(txfOpretTillæg,0,0);
        pane.add(txfOpretTillægPris,0,1);

        for(Hotel hotel : Controller.getHoteller()){
            cbHoteller = new ComboBox(FXCollections.observableArrayList(hotel.getHotelnavn());
        }
        pane.add(cbHoteller, 0, 2);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,0,3);
        btnOpret.setOnAction(event -> opretAction());
    }

    private void opretAction() {
        String navn = txfOpretTillæg.getText();
        int pris = Integer.parseInt(txfOpretTillægPris.getText());

        Controller.createAndAddTillægTilHotel(, );
    }

}
