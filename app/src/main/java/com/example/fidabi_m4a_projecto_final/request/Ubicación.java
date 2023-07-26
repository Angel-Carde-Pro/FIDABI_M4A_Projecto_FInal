package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;

public class Ubicación implements Serializable {

    private Long ubi_cod;
    private String ubi_nombre;
    private String departamento;
    private Boolean ubi_estado;

    public Ubicación(Long ubi_cod, String ubi_nombre, String ubi_departamento, Boolean ubi_estado) {
        this.ubi_cod = ubi_cod;
        this.ubi_nombre = ubi_nombre;
        this.departamento = ubi_departamento;
        this.ubi_estado = ubi_estado;
    }

    public Long getUbi_cod() {
        return ubi_cod;
    }

    public void setUbi_cod(Long ubi_cod) {
        this.ubi_cod = ubi_cod;
    }

    public String getUbi_nombre() {
        return ubi_nombre;
    }

    public void setUbi_nombre(String ubi_nombre) {
        this.ubi_nombre = ubi_nombre;
    }

    public String getUbi_departamento() {
        return departamento;
    }

    public void setUbi_departamento(String ubi_departamento) {
        this.departamento = ubi_departamento;
    }

    public Boolean getUbi_estado() {
        return ubi_estado;
    }

    public void setUbi_estado(Boolean ubi_estado) {
        this.ubi_estado = ubi_estado;
    }
}
