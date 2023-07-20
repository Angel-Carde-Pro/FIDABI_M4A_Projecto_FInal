package com.example.fidabi_m4a_projecto_final.request;

import java.util.Date;

public class RecentActResponse {

    /*
    * "act_cod": 1,
        "usuario": "Rector",
        "act_tabla": "MAQUINARIA Y EQUIPO:1 BANCO MÓVIL PARA MÁQUINAS DESARMABLES 8120-0",
        "act_accion": "Usted fue asignado",
        "fecha": "2023-07-19"*/
    private Long act_cod;
    private String usuario;
    private String act_tabla;
    private String act_accion;
    private Date fecha;

    public RecentActResponse(Long act_cod, String usuario, String act_tabla, String act_accion, Date fecha) {
        this.act_cod = act_cod;
        this.usuario = usuario;
        this.act_tabla = act_tabla;
        this.act_accion = act_accion;
        this.fecha = fecha;
    }

    public Long getAct_cod() {
        return act_cod;
    }

    public void setAct_cod(Long act_cod) {
        this.act_cod = act_cod;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAct_tabla() {
        return act_tabla;
    }

    public void setAct_tabla(String act_tabla) {
        this.act_tabla = act_tabla;
    }

    public String getAct_accion() {
        return act_accion;
    }

    public void setAct_accion(String act_accion) {
        this.act_accion = act_accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
