package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.View.SignUp;
import sample.View.Sign_In;


public class Main extends Application {
    public static int number;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/sample.fxml"));

        switch (number) {
            case 0: {
                primaryStage.setTitle("Registration Form JavaFX Application");
                SignUp signUp = new SignUp();
                GridPane gridPane = signUp.createRegistrationFormPane();
                signUp.addUIControls(gridPane, primaryStage);
                Scene scene = new Scene(gridPane, 800, 900);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            break;
            case 1: {
                primaryStage.setTitle("Registration Form JavaFX Application");
                Sign_In sign_in = new Sign_In();
                GridPane gridPane = sign_in.createRegistrationFormPane();
                sign_in.addUIControls(gridPane , primaryStage );
                Scene scene = new Scene(gridPane, 800, 900);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            break;
            case 2:{
                System.out.println("welcome to telegram  @@@ $$ #");
            }break;
            default:
                System.out.println("nothing!!!!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}