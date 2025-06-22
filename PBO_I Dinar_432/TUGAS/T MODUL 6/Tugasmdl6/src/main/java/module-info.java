module com.example.tugasmdl6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tugasmdl6 to javafx.fxml;
    exports com.example.tugasmdl6;
}