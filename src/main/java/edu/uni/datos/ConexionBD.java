package edu.uni.datos;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {
    private static Connection conexion;

    private ConexionBD() { }

    private static Properties cargarConfig() throws SQLException {
        Properties p = new Properties();
        try (InputStream in = ConexionBD.class.getResourceAsStream("/db.properties")) {
            if (in == null) {
                throw new SQLException("Falta el archivo db.properties en src/main/resources");
            }
            p.load(in);
        } catch (IOException e) {
            throw new SQLException("No se pudo leer db.properties", e);
        }
        return p;
    }

    public static Connection obtener() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            Properties cfg = cargarConfig();
            conexion = DriverManager.getConnection(
                    cfg.getProperty("db.url"),
                    cfg.getProperty("db.usuario"),
                    cfg.getProperty("db.clave"));
        }
        return conexion;
    }
}