module dev.philipepedrosa.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens dev.philipepedrosa.demo to javafx.fxml;
    exports dev.philipepedrosa.demo;
    exports dev.philipepedrosa.demo.controller;
    opens dev.philipepedrosa.demo.controller to javafx.fxml;
    exports dev.philipepedrosa.demo.view;
    opens dev.philipepedrosa.demo.view to javafx.fxml;
}