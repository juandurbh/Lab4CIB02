package edu.uni.controlador;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class PrincipalController {
    @FXML private void onCursos()      { System.out.println("Abrir módulo de Cursos"); }
    @FXML private void onEstudiantes() { System.out.println("Abrir módulo de Estudiantes"); }
    @FXML private void onMatricula()   { System.out.println("Abrir módulo de Matrícula"); }
    @FXML private void onSalir()       { Platform.exit(); }
}