package sample.View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Help2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        SplitPane root = new SplitPane();

        Button button21 = new Button("Click me21");
        Button button22 = new Button( "Click me22");
        VBox vBox1 = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPannable(true);
        //fill all over the page
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(vBox1);


        Button button11 = new Button("Click me11");
        Button button12 = new Button( "Click me12");
        BorderPane borderPane = new BorderPane(null,button12,null,button11,null);


        Button button31 = new Button("Click me31");
        Button button32 = new Button( "Click me32");
        VBox vBox2 = new VBox(button31,button32);

        //we determine just width of Line form left side of screen
        // 0.2f== 20%
        root.setDividerPositions(0.2f,0.8f);
        root.getItems().addAll(vBox1,borderPane,vBox2);


        Scene scene = new Scene(root,500,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
