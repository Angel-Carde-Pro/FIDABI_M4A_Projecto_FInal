package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;

public class Propietario implements Serializable {

    private Long pro_cod;
    private String pro_nombre;
    private String pro_direccion;
    private String pro_telefono;
    private Boolean pro_estado;

    public Long getPro_cod() {
        return pro_cod;
    }

    public void setPro_cod(Long pro_cod) {
        this.pro_cod = pro_cod;
    }

    public String getPro_nombre() {
        return pro_nombre;
    }

    public void setPro_nombre(String pro_nombre) {
        this.pro_nombre = pro_nombre;
    }

    public String getPro_direccion() {
        return pro_direccion;
    }

    public void setPro_direccion(String pro_direccion) {
        this.pro_direccion = pro_direccion;
    }

    public String getPro_telefono() {
        return pro_telefono;
    }

    public void setPro_telefono(String pro_telefono) {
        this.pro_telefono = pro_telefono;
    }

    public Boolean getPro_estado() {
        return pro_estado;
    }

    public void setPro_estado(Boolean pro_estado) {
        this.pro_estado = pro_estado;
    }
}