package com.example.proyectointegrador.model;

public class Usuario {
    private long id;
    private String nomApe;
    private String usuario;
    private String email;
    private String password;
    private String confirmPass;

    public Usuario (String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(String nomApe, String usuario, String email, String password, String confirmPass) {
        id = -1;
        this.nomApe = nomApe;
        this.usuario = usuario;
        this.email = email;
        this.password = password;
        this.confirmPass = confirmPass;
    }

    public String getUsuario() {
        return usuario;
    }

    public Usuario(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getNomApe() {
        return nomApe;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean hasBeenSaved () {
        if (id != -1){
            return false;
        }else
            return true;
    }
}
