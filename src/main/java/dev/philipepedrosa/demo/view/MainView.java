package dev.philipepedrosa.demo.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {
    private static Stage stage;

    @Override
    public void start(Stage st) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/dev/philipepedrosa/demo/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage = st;

        st.setTitle("DEMO");
        st.setScene(scene);
        st.show();
    }

    public void initialize() {
        launch();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MainView.stage = stage;
    }
}