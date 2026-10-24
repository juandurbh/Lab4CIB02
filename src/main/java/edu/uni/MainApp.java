package edu.uni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("/edu/uni/vista/Login.fxml"));
        stage.setScene(new Scene(raiz, 360, 260));
        stage.setTitle("Iniciar sesión");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}