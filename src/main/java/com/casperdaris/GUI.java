package com.casperdaris;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class GUI {

    public static BorderPane CreateGUI() {

        BorderPane GUI = new BorderPane();

        Text titleText = new Text("Voetbalclub Guessing Game");
        titleText.getStyleClass().add("titleText");
        Text aantalClubs = new Text("Aantal clubs in database:");
        aantalClubs.getStyleClass().add("labelText");
        Text aantalVragen = new Text("Vraag #:");
        aantalVragen.getStyleClass().add("labelText");
        VBox clubsEnVragenDataBox = new VBox(aantalClubs, aantalVragen);
        HBox topBox = new HBox(titleText, clubsEnVragenDataBox);
        topBox.getStyleClass().add("top");
        topBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GUI.setTop(topBox);

        Text vraag = new Text("Hier komt de volgende vraag te staan.");
        vraag.getStyleClass().add("vraagText");
        Button jaKnop = new Button("Ja");
        Button neeKnop = new Button("Nee");
        TextField input = new TextField();
        Button invoeren = new Button("Invoeren");
        HBox knoppenBox = new HBox(jaKnop, neeKnop);
        HBox invoerBox = new HBox(input, invoeren);
        VBox centerBox = new VBox(vraag, knoppenBox, invoerBox);
        centerBox.getStyleClass().add("center");
        centerBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        GUI.setCenter(centerBox);

        Button herstartKnop = new Button("Herstart");
        GUI.setBottom(herstartKnop);

        return GUI;
    }
}
