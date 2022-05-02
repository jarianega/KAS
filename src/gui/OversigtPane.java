package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Konference;

public class OversigtPane extends GridPane {

    private final TextArea txaDeltagere = new TextArea();
    private final TextArea txaUdflugter = new TextArea();
    private final TextArea txaHoteller = new TextArea();

    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        HBox deltagerBox = new HBox();
        this.add(deltagerBox, 0, 0);
        Label lblDeltagere = new Label("Deltagere:  ");
        deltagerBox.getChildren().add(lblDeltagere);
        deltagerBox.getChildren().add(txaDeltagere);
        txaDeltagere.setEditable(false);
        txaDeltagere.setPrefWidth(300);
        setDeltagereText();

        HBox udfulgterBox = new HBox();
        this.add(udfulgterBox, 0, 1);
        Label lblUdflugter = new Label("Udlugter:    ");
        udfulgterBox.getChildren().add(lblUdflugter);
        udfulgterBox.getChildren().add(txaUdflugter);
        txaUdflugter.setEditable(false);
        txaUdflugter.setPrefWidth(300);
        setUdflugterText();

        HBox hotellerBox = new HBox();
        this.add(hotellerBox, 0, 2);
        Label lblHoteller = new Label("Hoteller:      ");
        hotellerBox.getChildren().add(lblHoteller);
        hotellerBox.getChildren().add(txaHoteller);
        txaHoteller.setEditable(false);
        txaHoteller.setPrefWidth(300);
        setHotellerText();
    }

    public void setDeltagereText() {
       StringBuilder text = new StringBuilder();
        for (Konference konference : Controller.getKonferencer()) {
            for(String linje : Controller.getDeltagereStringForKonference(konference)){
                    text.append(linje + "\n");
                }
            txaDeltagere.setText(text.toString());
        }
    }

    public void setUdflugterText() {
        StringBuilder text = new StringBuilder();
        for (Konference konference : Controller.getKonferencer()) {
            for(String linje : Controller.getUdflugterStringForKonference(konference)){
                text.append(linje + "\n");
            }
            txaUdflugter.setText(text.toString());
        }
    }

    public void setHotellerText(){
        StringBuilder text = new StringBuilder();
        for (Konference konference : Controller.getKonferencer()) {
            for(String linje : Controller.getHotellerStringForKonference(konference)){
                text.append(linje + "\n");
            }
            txaHoteller.setText(text.toString());
        }
    }
}