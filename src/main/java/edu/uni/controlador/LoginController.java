package edu.uni.controlador;

import edu.uni.datos.UsuarioDAO;
import edu.uni.modelo.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    @FXML
    private void onIngresar() {
        String usuario = txtUsuario.getText();
        String clave = txtPassword.getText();

        if (usuario.isBlank() || clave.isBlank()) {
            lblMensaje.setText("Ingrese usuario y contraseña.");
            return;
        }
        try {
            Usuario u = new UsuarioDAO().autenticar(usuario, clave);
            if (u != null) {
                irAPrincipal();
            } else {
                lblMensaje.setText("Usuario o contraseña incorrectos.");
            }
        } catch (SQLException ex) {
            lblMensaje.setText("No se pudo conectar a la base de datos.");
            ex.printStackTrace(); // el detalle va a la consola, no a la pantalla
        }
    }

    private void irAPrincipal() {
        try {
            Parent raiz = FXMLLoader.load(
                    getClass().getResource("/edu/uni/vista/Principal.fxml"));
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setScene(new Scene(raiz, 640, 420));
            stage.setTitle("Sistema Académico UNI");
        } catch (IOException ex) {
            lblMensaje.setText("No se pudo abrir la pantalla principal.");
            ex.printStackTrace();
        }
    }
}