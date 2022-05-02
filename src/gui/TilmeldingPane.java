package gui;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

public class TilmeldingPane extends GridPane {
    String arKonferencer[] = {"konference 1", "konference 2", "konference 3"};
    ComboBox cbKonferencer = new ComboBox(FXCollections.observableArrayList(arKonferencer));
    private final TextField txfNavn = new TextField("Dit navn");
    private final TextField txfAdresse = new TextField("Din adresse");
    private final TextField txfBy = new TextField("Land/By");
    private final TextField txfTlf = new TextField("Telefonnummer");
    private final TextField txfAnkomst = new TextField("Ankomst");
    private final TextField txfAfrejse = new TextField("Afrejse");
    private final TextField txfFirmaNavn = new TextField("Firmanavn");
    private final TextField txfFirmaTlf = new TextField("Firma telefon");
    private final RadioButton rdbErLedsager = new RadioButton();
    private final Label lblErLedsager = new Label("Har du en ledsager?");
    private final TextField ledsagerNavn = new TextField("Ledsager navn");

    String arUdflugter[] = {"Udflugt 1", "Udflugt 2", "Udflugt 3"};
    private final ComboBox cbLedsagerUdflugter = new ComboBox(FXCollections.observableArrayList(arUdflugter));

    String arHoteller[] = {"Hotel 1", "Hotel 2", "Hotel 3"};
    private final ComboBox cbHoteller = new ComboBox(FXCollections.observableArrayList(arHoteller));

    public TilmeldingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.add(cbKonferencer, 0, 0);
        this.add(txfNavn, 0, 1);
        this.add(txfAdresse, 0, 2);
        this.add(txfBy, 0, 3);
        this.add(txfTlf, 0, 4);

        HBox hbox = new HBox(2);
        hbox.getChildren().addAll(txfAnkomst, txfAfrejse);
        this.add(hbox, 0, 5);

        this.add(txfFirmaNavn,0, 6);
        this.add(txfFirmaTlf, 0, 7);

        VBox vbox = new VBox(2);
        this.add(rdbErLedsager, 0, 8);
        this.add(lblErLedsager, 1, 8);
        vbox.getChildren().addAll(ledsagerNavn, cbLedsagerUdflugter);
        this.add(vbox, 0, 9);
        ledsagerNavn.isDisabled();
        cbLedsagerUdflugter.isDisabled();
        rdbErLedsager.setOnAction(event -> this.visLedsagerTilmelding());

        this.add(cbHoteller, 0, 10);
    }

    private void visLedsagerTilmelding() {
        if(!ledsagerNavn.isVisible()) {
            ledsagerNavn.isEditable();
            cbLedsagerUdflugter.isEditable();
        } else {
            ledsagerNavn.isEditable();
            cbLedsagerUdflugter.isEditable();
        }
    }
}
