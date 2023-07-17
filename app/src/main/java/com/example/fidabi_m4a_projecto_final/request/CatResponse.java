package com.example.fidabi_m4a_projecto_final.request;

public class CatResponse {
    private int cat_cod;
    private String cat_nombre;
    private String cat_descripcion;
    private boolean cat_estado;

    public CatResponse(int catCod, String catNombre, String catDescripcion, boolean catEstado) {
    }

    public int getCat_cod() {
        return cat_cod;
    }

    public void setCat_cod(int cat_cod) {
        this.cat_cod = cat_cod;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public String getCat_descripcion() {
        return cat_descripcion;
    }

    public void setCat_descripcion(String cat_descripcion) {
        this.cat_descripcion = cat_descripcion;
    }

    public boolean isCat_estado() {
        return cat_estado;
    }

    public void setCat_estado(boolean cat_estado) {
        this.cat_estado = cat_estado;
    }
}