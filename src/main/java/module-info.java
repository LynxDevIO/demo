module dev.philipepedrosa.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens dev.philipepedrosa.demo to javafx.fxml;
    exports dev.philipepedrosa.demo;
}