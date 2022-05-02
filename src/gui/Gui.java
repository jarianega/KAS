package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Gui extends Application {
    public void start(Stage stage) {
        stage.setTitle("KAS");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabOpretKonference = new Tab("Opret konference");
        tabPane.getTabs().add(tabOpretKonference);

        OpretKonferencePane konferencePane = new OpretKonferencePane();
        tabOpretKonference.setContent(konferencePane);
        tabOpretKonference.setOnSelectionChanged(event -> konferencePane.updateControls());

        Tab tabTilmelding = new Tab("Tilmelding");
        tabPane.getTabs().add(tabTilmelding);

        TilmeldingPane tilmeldingPane = new TilmeldingPane();
        tabTilmelding.setContent(tilmeldingPane);
        tabTilmelding.setOnSelectionChanged(event -> tilmeldingPane.updateControls());

        Tab tabOversigt = new Tab("Oversigter");
        tabPane.getTabs().add(tabOversigt);

        OversigtPane oversigtPane = new OversigtPane();
        tabOversigt.setContent(oversigtPane);
        tabOversigt.setOnSelectionChanged(event -> oversigtPane.updateControls());
    }
}
