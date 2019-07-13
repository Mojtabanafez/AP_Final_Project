package sample.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));
        root.setCenter(creatCenterPanel());
        root.setTop(creatTopPanel());
        root.setLeft(creatLeftPanel());

        Scene scene = new Scene(root);
        primaryStage.setTitle("Sketch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Parent creatLeftPanel(){
        ScrollPane scrollPane = new ScrollPane();
        VBox vBox = new VBox(20);
        vBox.setAlignment(Pos.CENTER);
        for(int i=0; i<6;i++){
            Image image= new Image("file:/home/mojtaba/Desktop/AP_Final_Project/src/sample/picture/Mydear.jpg");
            ImageView imageView=new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(200);
            vBox.getChildren().add(imageView);
        }
        scrollPane.setPrefWidth(250);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(500);
        scrollPane.setContent(vBox);
        return scrollPane;
    }
    public Parent creatTopPanel(){
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15));
        hBox.setAlignment(Pos.CENTER);
        Button searchBox = new Button("search");
        TextField textField = new TextField();
        hBox.setHgrow(textField, Priority.ALWAYS);
        textField.setPromptText("what are you looking for ???");
        textField.setMaxWidth(500);
        textField.setPrefWidth(250);
        hBox.getChildren().addAll(searchBox,textField);
        return hBox;
    }
    public Parent creatCenterPanel(){
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(15));
        borderPane.setPrefHeight(500);
        borderPane.setPrefWidth(500);
        Label label = new Label("I.U.S.T");

        label.setAlignment(Pos.CENTER);
        borderPane.setBottom(label);
        Image image= new Image("file:/home/mojtaba/Desktop/AP_Final_Project/src/sample/picture/Mydear.jpg");
        ImageView imageView=new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(300);
        borderPane.setCenter(imageView);
        borderPane.setAlignment(label,Pos.CENTER);
        return borderPane;
    }

    public static void main(String[] args){
        launch();
    }
}