package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Long usu_cod;
    private String usuario;
    private String contrasenia;
    private Boolean usu_estado;
    private Persona persona;

    public Long getUsu_cod() {
        return usu_cod;
    }

    public void setUsu_cod(Long usu_cod) {
        this.usu_cod = usu_cod;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getUsu_estado() {
        return usu_estado;
    }

    public void setUsu_estado(Boolean usu_estado) {
        this.usu_estado = usu_estado;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
