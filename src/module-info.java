module javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kotlin.stdlib;
    requires java.mail;
    requires activation;
    opens sample;
    opens sample.Server;
    opens sample.View;
}