package com.example.proyectointegrador.firebase;

public class DatosRegistro {
    String nombre;
    String usuario;
    String email;
    String contraseña;
    String confirContraseña;
    public DatosRegistro(String nombre, String usuario, String email, String contraseña, String confirContraseña) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.contraseña = contraseña;
        this.confirContraseña = confirContraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getConfirContraseña() {
        return confirContraseña;
    }
}
