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
import model.Konference;

import java.time.LocalDate;

public class OpretUdflugtWindow extends Stage {
    private final TextField txfUdflugtBeskrivelse = new TextField ("Beskrivelse af udflugt");
    private final TextField txfUdflugtDato = new TextField ("Dato på udflugt");
    private final TextField txfUdflugtPris = new TextField ("Pris på udflugt");
    ComboBox cbKonferencer = new ComboBox();

    public OpretUdflugtWindow(){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.setTitle("Opret udflugt");
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

        pane.add(txfUdflugtBeskrivelse,0,0);
        pane.add(txfUdflugtDato,0,1);
        pane.add(txfUdflugtPris,0,2);

        for(Konference konference : Controller.getKonferencer()){
            cbKonferencer = new ComboBox<>(FXCollections.observableArrayList(konference.getNavn()));
        }
        pane.add(cbKonferencer, 0, 3);

        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 4);
        btnOpret.setOnAction(event -> udflugtAction());
    }

    private void udflugtAction() {
        String udflugtBeskrivelse = txfUdflugtBeskrivelse.getText();
        LocalDate udflugtDato = LocalDate.parse(txfUdflugtDato.getText());
        int udflugtPris = Integer.parseInt(txfUdflugtPris.getText());
        Object konference = cbKonferencer.getSelectionModel().getSelectedItem();
        Controller.createUdflugt(udflugtBeskrivelse, udflugtDato, udflugtPris, (Konference) konference);
    }
}
