package com.example.fidabi_m4a_projecto_final.request;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class BienResponse {
    @SerializedName("bien_cod")
    private Long bien_cod;

    @SerializedName("bien_codigoG")
    private String bien_codigoG;

    @SerializedName("bien_modelo")
    private String bien_modelo;

    @SerializedName("bien_cat_cod")
    private BigInteger bien_cat_cod;

    @SerializedName("bien_marca")
    private String bien_marca;

    @SerializedName("bien_estado")
    private String bien_estado;

    @SerializedName("bien_detalles")
    private String bien_detalles;

    @SerializedName("bien_descripcion")
    private String bien_descripcion;

    @SerializedName("bien_serie")
    private String bien_serie;

    @SerializedName("bien_precio")
    private Double bien_precio;

    @SerializedName("bien_estadoA")
    private Boolean bien_estadoA;

    @SerializedName("bien_estado_asignado")
    private Boolean bien_estado_asignado;

    public Long getBien_cod() {
        return bien_cod;
    }

    public void setBien_cod(Long bien_cod) {
        this.bien_cod = bien_cod;
    }

    public String getBien_codigoG() {
        return bien_codigoG;
    }

    public void setBien_codigoG(String bien_codigoG) {
        this.bien_codigoG = bien_codigoG;
    }

    public String getBien_modelo() {
        return bien_modelo;
    }

    public void setBien_modelo(String bien_modelo) {
        this.bien_modelo = bien_modelo;
    }

    public String getBien_marca() {
        return bien_marca;
    }

    public void setBien_marca(String bien_marca) {
        this.bien_marca = bien_marca;
    }

    public String getBien_estado() {
        return bien_estado;
    }

    public void setBien_estado(String bien_estado) {
        this.bien_estado = bien_estado;
    }

    public String getBien_detalles() {
        return bien_detalles;
    }

    public void setBien_detalles(String bien_detalles) {
        this.bien_detalles = bien_detalles;
    }

    public String getBien_descripcion() {
        return bien_descripcion;
    }

    public void setBien_descripcion(String bien_descripcion) {
        this.bien_descripcion = bien_descripcion;
    }

    public String getBien_serie() {
        return bien_serie;
    }

    public void setBien_serie(String bien_serie) {
        this.bien_serie = bien_serie;
    }

    public Double getBien_precio() {
        return bien_precio;
    }

    public void setBien_precio(Double bien_precio) {
        this.bien_precio = bien_precio;
    }

    public Boolean getBien_estadoA() {
        return bien_estadoA;
    }

    public void setBien_estadoA(Boolean bien_estadoA) {
        this.bien_estadoA = bien_estadoA;
    }

    public Boolean getBien_estado_asignado() {
        return bien_estado_asignado;
    }

    public void setBien_estado_asignado(Boolean bien_estado_asignado) {
        this.bien_estado_asignado = bien_estado_asignado;
    }

    public BigInteger getBien_cat_cod() {
        return bien_cat_cod;
    }

    public void setBien_cat_cod(BigInteger bien_cat_cod) {
        this.bien_cat_cod = bien_cat_cod;
    }
}