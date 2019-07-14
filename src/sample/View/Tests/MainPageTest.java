package sample.View.Tests;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainPageTest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SplitPane root = new SplitPane();

        VBox LeftVBox = new VBox();

        HBox searchHBox1 = new HBox(20);
        searchHBox1.setAlignment(Pos.CENTER);
        searchHBox1.setPadding(new Insets(30));
        TextField searchtextField = new TextField();
        searchtextField.setPromptText("search");
        Button searchButton = new Button("  search  ");
        searchHBox1.getChildren().addAll(searchtextField,searchButton);
        LeftVBox.getChildren().add(searchHBox1);

        ScrollPane scrollPaneLeft = new ScrollPane();

        VBox groupsAndPv = new VBox(20);
        groupsAndPv.setAlignment(Pos.CENTER);

        for(int i=0; i<12;i++){
            Image image= new Image("file:/home/mojtaba/Desktop/AP_Final_Project/src/sample/picture/Mydear.jpg");
            ImageView imageView=new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(200);
            groupsAndPv.getChildren().add(imageView);
        }
        scrollPaneLeft.setPrefWidth(250);
        scrollPaneLeft.setFitToWidth(true);
        //scrollPaneLeft.setPrefHeight(500);
        scrollPaneLeft.setContent(groupsAndPv);

        LeftVBox.getChildren().addAll(scrollPaneLeft);

//****************************************************************

        VBox RightVBox = new VBox();

        HBox hBox2 = new HBox(20);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(30));
        Image Profile= new Image("file:/home/mojtaba/Desktop/AP_Final_Project/src/sample/picture/Mydear.jpg");
        ImageView ProfileImageView1=new ImageView(Profile);
        ProfileImageView1.setPreserveRatio(true);
        ProfileImageView1.setFitWidth(100);
        RightVBox.getChildren().add(ProfileImageView1);

        Label Namelable = new Label(" Name ");
        Namelable.setAlignment(Pos.CENTER);
        Namelable.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        hBox2.getChildren().addAll(ProfileImageView1,Namelable);

        ScrollPane scrollPaneRight = new ScrollPane();
        VBox vBox2 = new VBox();
        scrollPaneRight.setPannable(true);
        scrollPaneRight.setFitToWidth(true);
        scrollPaneRight.setFitToHeight(true);

        for(int i=0; i<12;i++){
            Image image= new Image("file:/home/mojtaba/Desktop/AP_Final_Project/src/sample/picture/Mydear.jpg");
            ImageView imageView=new ImageView(image);
            imageView.setPreserveRatio(true);
            imageView.setFitWidth(200);
            vBox2.getChildren().add(imageView);
        }
        scrollPaneRight.setContent(vBox2);

        TextField sendingMassage= new TextField();
        sendingMassage.setPadding(new Insets(20));
        sendingMassage.setPromptText("Write a message...");

        sendingMassage.setAlignment(Pos.CENTER);
        RightVBox.getChildren().addAll(hBox2,scrollPaneRight,sendingMassage);


        root.setDividerPositions(0.5f,0.5f);
        root.getItems().addAll(LeftVBox,RightVBox);


        Scene scene = new Scene(root,800,900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
