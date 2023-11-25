module com.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab6 to javafx.fxml;
    opens com.example.laba_6_1 to javafx.graphics;
    opens com.example.laba_6_2 to javafx.graphics;
    opens com.example.laba_6_3 to javafx.graphics;
    opens com.example.task to javafx.graphics;
}