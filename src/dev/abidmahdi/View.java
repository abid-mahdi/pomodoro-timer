package dev.abidmahdi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class View {

    private final Label studySessionNumLbl, whatsNextLbL, timerLbl;
    private final Button startPauseBtn;
    private final Scene scene;

    // UI Setup
    public View() {
        studySessionNumLbl = new Label();
        whatsNextLbL = new Label();
        HBox hbox = new HBox(studySessionNumLbl, whatsNextLbL);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);

        timerLbl = new Label("25:00");
        timerLbl.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        startPauseBtn = new Button("> ||");
        VBox vbox = new VBox(timerLbl, startPauseBtn, hbox);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        scene = new Scene(vbox, 400, 400);

    }

    public Scene getScene() {
        return scene;
    }

    public Label getStudySessionNumLbl() {
        return studySessionNumLbl;
    }

    public Label getWhatsNextLbL() {
        return whatsNextLbL;
    }

    public Button getStartPauseBtn() {
        return startPauseBtn;
    }

    public Label getTimerLbl() {
        return timerLbl;
    }

}
