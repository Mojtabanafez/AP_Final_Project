package sample.View;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sample.Main;
import sample.Server.DB.PrivateMassage;
import sample.Server.DB.User;

public class MainPage extends Application {
    private final static Background focusBackground = new Background( new BackgroundFill( Color.web( "#00FF00" ), CornerRadii.EMPTY, Insets.EMPTY ));
    private final static Background focusBackground2 = new Background( new BackgroundFill( Color.web( "#C0C0C0" ), CornerRadii.EMPTY, Insets.EMPTY ));
    private final static Background focusBackground3 = new Background( new BackgroundFill( Color.web( "#00FFFF" ), CornerRadii.EMPTY, Insets.EMPTY ));
    @Override
    public void start(Stage primaryStage) throws Exception {
        SplitPane root = MainPage.Mainpage(new User());
        Scene scene = new Scene(root, 800, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println();
    }

    public static SplitPane Mainpage(User accountOwner){
        User receiver = new User();
        SplitPane root = new SplitPane();
        VBox RightVBox = new VBox();
        RightVBox.setBackground(focusBackground3);
        HBox hBox2 = new HBox(20);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setPadding(new Insets(30));

        ScrollPane scrollPaneRight = new ScrollPane();
        VBox vBox2 = new VBox(20);
        scrollPaneRight.setPannable(true);
        scrollPaneRight.setFitToWidth(true);
        scrollPaneRight.setPrefHeight(850);
        scrollPaneRight.setFitToHeight(true);

        scrollPaneRight.setContent(vBox2);

        HBox sendMassage = new HBox();
        Button send = new Button("send");
        send.setPrefSize(70, 100);
        send.setDefaultButton(true);
        TextField sendingMassage = new TextField();
        sendingMassage.setPadding(new Insets(20));
        sendingMassage.setPromptText("Write a message...");
        sendingMassage.setAlignment(Pos.CENTER);
        sendingMassage.setPrefWidth(330);

        sendMassage.getChildren().addAll(sendingMassage, send);
        RightVBox.getChildren().addAll(hBox2, scrollPaneRight, sendMassage);
//*******************************************************************************************************************************************
        VBox LeftVBox = new VBox();
        LeftVBox.setBackground(focusBackground3);
        HBox searchHBox1 = new HBox(20);
        searchHBox1.setAlignment(Pos.CENTER);
        searchHBox1.setPadding(new Insets(30));

        TextField searchtextField = new TextField();
        searchtextField.setPromptText("search");

        ScrollPane scrollPaneLeft = new ScrollPane();

        VBox groupsAndPv = new VBox();
        groupsAndPv.setBackground(focusBackground3);

        Button searchButton = new Button("  search  ");
        searchButton.setDefaultButton(true);
        searchHBox1.getChildren().addAll(searchtextField, searchButton);
        System.out.println(searchtextField.getText());
        search( searchButton , searchtextField , groupsAndPv , vBox2 , hBox2 , RightVBox , receiver , accountOwner , send , sendingMassage );
        LeftVBox.getChildren().add(searchHBox1);
        groupsAndPv.setAlignment(Pos.CENTER);

        Pvs(groupsAndPv, accountOwner , RightVBox , hBox2 ,send ,sendingMassage , vBox2);
        System.out.println("come");
        scrollPaneLeft.setPrefWidth(250);
        scrollPaneLeft.setFitToWidth(true);
        scrollPaneLeft.setContent(groupsAndPv);

        LeftVBox.getChildren().addAll(scrollPaneLeft);

//****************************************************************
        /*
       send.setOnAction(event -> {
            Pvs(groupsAndPv,accountOwner,RightVBox,hBox2,send,sendingMassage,vBox2);
        });
        */
        root.setDividerPositions(0.5f, 0.5f);
        root.getItems().addAll(LeftVBox, RightVBox);
        return root;
    }

    public static void Pvs(VBox groupsAndPv, User accountOwner , VBox RightVBox , HBox hBox2 , Button send , TextField sendingMassage , VBox vBox2) {
        Main main = new Main();
        String Massage3 = "EveryPvsGroups" + "^" + accountOwner.getId();
        main.SendMassage(Massage3);
        groupsAndPv.getChildren().clear();
        while (true) {
            String InfUser = main.ReceivedMessage();
            String[] Massages = InfUser.split("\\^");
            if (Massages[0].equals("FinishedPvsGroups")) {
                break;
            } else if (Massages[0].equals("EveryPvsGroups")){
                User user = new User();
                user.setName(Massages[1]);
                user.setEmail(Massages[2]);
                user.setLastName(Massages[3]);
                user.setPassword(Massages[4]);
                user.setId(Integer.parseInt(Massages[5]));
                user.setProfileAddress(Massages[6]);
                user.setUserName(Massages[7]);


                Image image = new Image("file:/home/mojtaba/c++ project/AP_Final_Project_96431335_Messenger/AP_Final_Project/src/sample/picture/Mydear.jpg");
                ImageView imageView = new ImageView(image);

                imageView.setPreserveRatio(true);
                imageView.setFitWidth(100);
                Button pvGroup = new Button(user.getName(), imageView);
                pvGroup.setPrefSize(400, 50);
                pvGroup.setAlignment(Pos.BOTTOM_LEFT);
                pvGroup.setPadding(new Insets(10));

                pvGroup.setOnAction ( event1 -> {
                    Label Namelable = new Label(user.getName());
                    Namelable.setAlignment(Pos.CENTER);
                    Namelable.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    Image Profile = new Image("file:/home/mojtaba/c++ project/AP_Final_Project_96431335_Messenger/AP_Final_Project/src/sample/picture/Mydear.jpg");
                    ImageView ProfileImageView1 = new ImageView(Profile);
                    ProfileImageView1.setPreserveRatio(true);
                    ProfileImageView1.setFitWidth(100);
                    RightVBox.getChildren().add(ProfileImageView1);
                    hBox2.getChildren().clear();
                    hBox2.getChildren().addAll(ProfileImageView1, Namelable);

                    send.setOnAction(event -> {
                        if (!sendingMassage.getText().equals("")) {
                            if (user.getName() != null) {
                                String message = "SendMessage" + "^" + user.getId() + "^" + accountOwner.getId() + "^" + sendingMassage.getText();
                                System.out.println(message);
                                main.SendMassage(message);
                            }
                        }
                        updatemassage(accountOwner,user,vBox2);
                    });
                    updatemassage(accountOwner,user,vBox2);
                });
                pvGroup.setFont(Font.font("Arial", FontWeight.BOLD, 24));

                groupsAndPv.getChildren().add(pvGroup);

            }
        }
    }
    public static void updatemassage(User accountOwner , User goalUser , VBox vBox2 ){
        Main main = new Main();
        String showMessage = "ShowMessage"+ "^" + goalUser.getId() + "^" + accountOwner.getId();
        main.SendMassage(showMessage);
        vBox2.getChildren().clear();
        while ( true ){
            String MessageInf = main.ReceivedMessage();
            String[]Massagess = MessageInf.split("\\^");

            if(Massagess[0].equals("Finished message!!!")){
                break;
            }else if(Massagess[0].equals("PVsMessage")){
                PrivateMassage privateMassage1 = new PrivateMassage();

                privateMassage1.setDate(Massagess[1]);
                privateMassage1.setText(Massagess[2]);
                privateMassage1.setId(Integer.parseInt(Massagess[3]));
                privateMassage1.setUser_id_receiver(Integer.parseInt(Massagess[4]));
                privateMassage1.setUser_id_sender(Integer.parseInt(Massagess[5]));

                VBox TextvBox = new VBox();
                if( privateMassage1.getUser_id_sender() == accountOwner.getId() ) {
                    TextvBox.setAlignment(Pos.BASELINE_RIGHT);
                    TextvBox.setBackground(focusBackground);
                }else {
                    TextvBox.setBackground(focusBackground2);
                }
                Label label = new Label(privateMassage1.getText());
                Label label1 = new Label(privateMassage1.getDate());
                TextvBox.getChildren().addAll(label,label1);
                vBox2.getChildren().add(TextvBox);


            }
        }
    }

    public static User search(Button button, TextField textField, VBox groupsAndPv, VBox vBox2, HBox hBox2, VBox RightVBox, User user , User accountOwner ,Button send , TextField sendingMassage) {
        button.setOnAction(event -> {
            if (!textField.getText().equals("")) {
                Main main = new Main();
                String message = "searchUser" + "^" + textField.getText();
                main.SendMassage(message);
                String Answer = main.ReceivedMessage();
                String[] Message = Answer.split("\\^");
                if (!Message[1].equals("not_found_user")) {
                    user.setName(Message[1]);
                    user.setEmail(Message[2]);
                    user.setLastName(Message[3]);
                    user.setPassword(Message[4]);
                    user.setId(Integer.parseInt(Message[5]));
                    user.setProfileAddress(Message[6]);
                    user.setUserName(Message[7]);
                    Image image = new Image("file:/home/mojtaba/c++ project/AP_Final_Project_96431335_Messenger/AP_Final_Project/src/sample/picture/Mydear.jpg");
                    ImageView imageView = new ImageView(image);
                    imageView.setPreserveRatio(true);
                    imageView.setFitWidth(100);

                    Button pvGroup = new Button(user.getName(), imageView);
                    pvGroup.setPrefSize(400, 50);
                    pvGroup.setAlignment(Pos.CENTER);
                    pvGroup.setPadding(new Insets(10));
                    pvGroup.setOnAction(event1 -> {
                        Label Namelable = new Label(user.getName());
                        Namelable.setAlignment(Pos.CENTER);
                        Namelable.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                        Image Profile = new Image("file:/home/mojtaba/c++ project/AP_Final_Project_96431335_Messenger/AP_Final_Project/src/sample/picture/Mydear.jpg");
                        ImageView ProfileImageView1 = new ImageView(Profile);
                        ProfileImageView1.setPreserveRatio(true);
                        ProfileImageView1.setFitWidth(100);
                        RightVBox.getChildren().add(ProfileImageView1);
                        hBox2.getChildren().clear();
                        hBox2.getChildren().addAll(ProfileImageView1, Namelable);


                    });
                    send.setOnAction(event2 -> {
                        if (!sendingMassage.getText().equals("")) {
                            if (user.getName() != null) {
                                String message2 = "SendMessage" + "^" + user.getId() + "^" + accountOwner.getId() + "^" + sendingMassage.getText();
                                main.SendMassage(message2);
                                updatemassage(accountOwner,user,vBox2);
                            }
                        }
                    });
                    updatemassage(accountOwner,user,vBox2);
                    pvGroup.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    groupsAndPv.getChildren().clear();
                    groupsAndPv.getChildren().add(pvGroup);
                }
            }else {
                Pvs(groupsAndPv,accountOwner,RightVBox,hBox2,send ,sendingMassage , vBox2);
            }
            return;
        });
        if (user.getName() != null){
            System.out.println("not Null");
            Label searchlable = new Label(user.getName());
            groupsAndPv.getChildren().add(searchlable);
        }
        return user;
    }
    public static void main(String[] args) {
        launch(args);
    }
}