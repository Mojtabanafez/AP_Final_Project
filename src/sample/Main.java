package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sample.Server.DB.User;
import sample.View.MainPage;
import sample.View.SignUp;
import sample.View.Sign_In;
import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class Main extends Application {

    static User accountOwner = new User();
    public static int number;
    static Socket socket;
    static {
        try {
            socket = new Socket("127.0.0.1", 1978);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Scanner socketIn;
    static {
        try {
            socketIn = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Formatter socketOut;

    static {
        try {
            socketOut = new Formatter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("View/Tests/sample.fxml"));
        switch (number) {
            case 0: {
                primaryStage.setTitle("Registration Form JavaFX Application");
                SignUp signUp = new SignUp();
                GridPane gridPane = signUp.createRegistrationFormPane();
                signUp.addUIControls(gridPane, primaryStage , accountOwner);
                Scene scene = new Scene(gridPane, 800, 900);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            break;
            case 1:{
                primaryStage.setTitle("Registration Form JavaFX Application");
                Sign_In sign_in = new Sign_In();
                GridPane gridPane = sign_in.createRegistrationFormPane();
                sign_in.addUIControls(gridPane , primaryStage , accountOwner);
                Scene scene = new Scene(gridPane, 800, 900);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            break;
            case 2: {
                SplitPane root2= MainPage.Mainpage(accountOwner);
                Scene scene = new Scene(root2,800,900);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            break;
            default:
                System.out.println("nothing!!!!");
        }
    }
    public String ReceivedMessage(){
        String received = socketIn.nextLine();
        return received;
    }
    public void SendMassage(String massage){
        try {
            socketOut.format(massage + "\n");
            socketOut.flush();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    public static void main(String[] args){
        launch(args);
    }
}