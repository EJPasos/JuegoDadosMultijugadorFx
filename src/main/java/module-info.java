module com.example.juegodados {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;


    opens com.example.juegodados to javafx.fxml;
    exports com.example.juegodados;
}