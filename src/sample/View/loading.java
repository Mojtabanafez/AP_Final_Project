package sample.View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class loading extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Label label=new Label("Loading...");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        VBox root = new VBox() ;
        root.getChildren().addAll(label);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root,800,900);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
