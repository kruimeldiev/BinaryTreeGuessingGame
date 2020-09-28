package com.casperdaris;

import com.casperdaris.controller.BTController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(GUI.CreateGUI());
        String styleURI = Paths.get("/Users/casper/Desktop/BinaryTreeGuessingGame/src/main/java/com/casperdaris/styles/style.css").toUri().toString();
        scene.getStylesheets().add(styleURI);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();

        BTController controller = new BTController();

        while (controller.spelen) {
            controller.spelSpelen(controller.beginBoomMaken());
        }
    }
}
