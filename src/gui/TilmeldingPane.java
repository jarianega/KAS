package gui;

import controller.Controller;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Hotel;
import model.Konference;
import model.Udflugt;

import java.time.LocalDate;

public class TilmeldingPane extends GridPane {
    private Controller controller = new Controller();

    ComboBox cbKonferencer = new ComboBox();

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
    private final TextField txfLedsagerNavn = new TextField("Ledsager navn");
    private final RadioButton rdbForedragsholder = new RadioButton();


    private ComboBox cbLedsagerUdflugter = new ComboBox();

    //String arHoteller[] = {"Hotel 1", "Hotel 2", "Hotel 3"};
    private ComboBox cbHoteller = new ComboBox();

    public TilmeldingPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        for (Konference konference : Controller.getKonferencer()) {
            cbKonferencer = new ComboBox<>(FXCollections.observableArrayList(konference.getNavn()));
        }
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

        HBox ledsagerHBox = new HBox(2);
        ledsagerHBox.getChildren().addAll(rdbErLedsager, lblErLedsager);
        this.add(ledsagerHBox, 0, 8);
        
        for(Udflugt udflugt : Controller.getUdflugter()){
            cbLedsagerUdflugter.setItems(FXCollections.observableArrayList(udflugt.getBeskrivelse()));
        }
        VBox vbox = new VBox(2);
        vbox.getChildren().addAll(txfLedsagerNavn, cbLedsagerUdflugter);
        this.add(vbox, 0, 9);
        txfLedsagerNavn.setDisable(true);
        cbLedsagerUdflugter.setDisable(true);
        cbLedsagerUdflugter.getSelectionModel().selectFirst();
        rdbErLedsager.setOnAction(event -> this.visLedsagerTilmelding());

        this.add(rdbForedragsholder,5,10);

        for(Hotel hotel : Controller.getHoteller()){
            cbHoteller = new ComboBox<>(FXCollections.observableArrayList(hotel.getHotelnavn()));
        }
        this.add(cbHoteller, 0, 10);
        cbHoteller.getSelectionModel().selectFirst();


        Button btnTilmeld = new Button("Tilmeld");
        this.add(btnTilmeld, 0, 11);
        btnTilmeld.setOnAction(event -> TilmeldAction());

    }

    private void TilmeldAction() {
        String navn = txfNavn.getText();
        String adresse = txfAdresse.getText();
        String byellerland = txfBy.getText();
        int tlfnummer = Integer.parseInt(txfTlf.getText());
        LocalDate ankomst = LocalDate.parse(txfAnkomst.getText());
        LocalDate afrejse = LocalDate.parse(txfAfrejse.getText());
        boolean foredragsholder = rdbForedragsholder.isSelected();
        String konferencenavn = (String) cbKonferencer.getSelectionModel().getSelectedItem();
        Konference konference = null;
        for(Konference k : Controller.getKonferencer()){
            if(konferencenavn.equals(k.getNavn())){
                konference = k;
            }
        }
        Controller.createDeltager(navn,adresse,byellerland,tlfnummer,foredragsholder,ankomst,afrejse,konference);

    }

    private void visLedsagerTilmelding() {
        if(txfLedsagerNavn.isDisabled()) {
            txfLedsagerNavn.setDisable(false);
            cbLedsagerUdflugter.setDisable(false);
        } else {
            txfLedsagerNavn.setDisable(true);
            cbLedsagerUdflugter.setDisable(true);
        }
    }
}
