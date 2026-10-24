package edu.uni.datos;

import edu.uni.modelo.Usuario;
import java.sql.*;

public class UsuarioDAO {
    public Usuario autenticar(String usuario, String clave) throws SQLException {
        String sql = "SELECT idUsuario, usuario, rol FROM Usuario " +
                "WHERE usuario = ? AND clave = ?";
        try (Connection con = ConexionBD.obtener();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, clave);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(rs.getInt("idUsuario"),
                            rs.getString("usuario"),
                            rs.getString("rol"));
                }
            }
        }
        return null; // no encontrado: credenciales inválidas
    }
}