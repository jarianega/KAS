package gui;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Konference;

public class OversigtPane extends GridPane {

    private final TextArea txaDeltagere = new TextArea();
    private final TextArea txaUdflugter = new TextArea();
    private final TextArea txaHoteller = new TextArea();
    private ComboBox<String> cbKonferencer = new ComboBox<>();

    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblKonference = new Label("Vælg konference:");
        this.add(lblKonference, 0, 0);
        for (Konference konference : Controller.getKonferencer()) {
            cbKonferencer = new ComboBox<>(FXCollections.observableArrayList(konference.getNavn()));
        }
        this.add(cbKonferencer, 0, 1);
        cbKonferencer.setOnAction(event -> selectKonference());

        HBox deltagerBox = new HBox();
        this.add(deltagerBox, 0, 2);
        Label lblDeltagere = new Label("Deltagere:  ");
        deltagerBox.getChildren().add(lblDeltagere);
        deltagerBox.getChildren().add(txaDeltagere);
        txaDeltagere.setEditable(false);
        txaDeltagere.setPrefWidth(300);

        HBox udflugterBox = new HBox();
        this.add(udflugterBox, 0, 3);
        Label lblUdflugter = new Label("Udlugter:    ");
        udflugterBox.getChildren().add(lblUdflugter);
        udflugterBox.getChildren().add(txaUdflugter);
        txaUdflugter.setEditable(false);
        txaUdflugter.setPrefWidth(300);

        HBox hotellerBox = new HBox();
        this.add(hotellerBox, 0, 4);
        Label lblHoteller = new Label("Hoteller:      ");
        hotellerBox.getChildren().add(lblHoteller);
        hotellerBox.getChildren().add(txaHoteller);
        txaHoteller.setEditable(false);
        txaHoteller.setPrefWidth(300);
    }

    public void setDeltagereText() {
        Object konference = cbKonferencer.getSelectionModel().getSelectedItem();

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < Controller.getDeltagereStringForKonference((Konference) konference).size(); i++) {
            text.append(Controller.getDeltagereStringForKonference((Konference) konference).get(i) + "\n");
        }
        txaDeltagere.setText(text.toString());
    }

    public void setUdflugterText() {
        Object konference = cbKonferencer.getSelectionModel().getSelectedItem();

        StringBuilder text = new StringBuilder();
            for (String linje : Controller.getUdflugterStringForKonference((Konference) konference)) {
                text.append(linje + "\n");
            }
            txaUdflugter.setText(text.toString());
        }


    public void setHotellerText() {
        StringBuilder text = new StringBuilder();
        for (Konference konference : Controller.getKonferencer()) {
            for (String linje : Controller.getHotellerStringForKonference(konference)) {
                text.append(linje + "\n");
            }
            txaHoteller.setText(text.toString());
        }
    }

    public void selectKonference() {
        setDeltagereText();
        setUdflugterText();
        setHotellerText();
    }
}