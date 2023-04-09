module com.example.decrypter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.decrypter to javafx.fxml;
    exports com.example.decrypter;
}