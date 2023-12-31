package com.example.fidabi_m4a_projecto_final;

public class GlobalData {
    public String PrimerNombre;
    public String Rol;

    public Long usuarios;

    //Para que solo acceda
    private static GlobalData instance;

    public GlobalData() {

    }

    public static GlobalData getInstance() {
        if (instance == null) {
            instance = new GlobalData();
        }
        return instance;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        PrimerNombre = primerNombre;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public Long getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Long usuarios) {
        this.usuarios = usuarios;
    }

    public void cerrarsesion() {
        setPrimerNombre("");
        setRol("");
        setUsuarios(null);
    }

}
