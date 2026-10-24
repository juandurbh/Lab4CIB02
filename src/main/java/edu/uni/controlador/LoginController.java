package edu.uni.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    @FXML
    private void onIngresar() throws Exception {
        String usuario = txtUsuario.getText();
        String clave = txtPassword.getText();

        if (usuario.isBlank() || clave.isBlank()) {
            lblMensaje.setText("Ingrese usuario y contraseña.");
            return;
        }
        if (usuario.equals("admin") && clave.equals("uni2026")) {
            Parent raiz = FXMLLoader.load(
                    getClass().getResource("/edu/uni/vista/Principal.fxml"));
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setScene(new Scene(raiz, 640, 420));
            stage.setTitle("Sistema Académico UNI");
        } else {
            lblMensaje.setText("Usuario o contraseña incorrectos.");
        }
    }
}