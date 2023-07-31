package com.example.joshuaburt_comp1011sec005_labex05;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lab5ApplicationV2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Lab5ApplicationV2.class.getResource("lab5ViewV2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 270);
        stage.setTitle("Institution Search");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
