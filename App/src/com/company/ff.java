package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;

public class ff extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
     //   FXMLLoader loader = new FXMLLoader(new File("\\home\\mojtaba\\Desktop\\AP_Final_Project\\resourc").toURI().toURL());
        Label headerLabel = new Label("Registration Form");
        stage.setTitle("Registration Form JavaFX Application");
        stage.show();

    }
}
