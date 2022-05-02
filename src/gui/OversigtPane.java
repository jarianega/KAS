package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class OversigtPane extends GridPane {

    private final TextArea txaDeltagere = new TextArea();
    private final TextArea txaUdflugter = new TextArea();
    private final TextArea txaHoteller = new TextArea();

    public OversigtPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblDeltagere = new Label("Deltagere på konferencen");
    }
}
