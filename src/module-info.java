module javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kotlin.stdlib;
    opens sample;
    opens sample.Server;
    opens sample.View;
}