package edu.uni.modelo;

public class Usuario {
    private int idUsuario;
    private String usuario;
    private String rol;

    public Usuario(int idUsuario, String usuario, String rol) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.rol = rol;
    }

    public String getUsuario() { return usuario; }
    public String getRol() { return rol; }
}