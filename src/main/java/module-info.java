module com.example.numbergame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.numbergame to javafx.fxml;
    exports com.example.numbergame;
}