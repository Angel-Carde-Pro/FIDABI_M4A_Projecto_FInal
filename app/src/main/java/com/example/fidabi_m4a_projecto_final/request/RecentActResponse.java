package com.example.fidabi_m4a_projecto_final.request;

import java.util.List;

public class RecentActResponse {
    private long his_cod;
    private String his_fecha;
    private String his_detalles;
    private UsuarioResponse usuario;
    private BienResponse bien;

    public long getHis_cod() {
        return his_cod;
    }

    public void setHis_cod(long his_cod) {
        this.his_cod = his_cod;
    }

    public String getHis_fecha() {
        return his_fecha;
    }

    public void setHis_fecha(String his_fecha) {
        this.his_fecha = his_fecha;
    }

    public String getHis_detalles() {
        return his_detalles;
    }

    public void setHis_detalles(String his_detalles) {
        this.his_detalles = his_detalles;
    }

    public UsuarioResponse getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResponse usuario) {
        this.usuario = usuario;
    }

    public BienResponse getBien() {
        return bien;
    }

    public void setBien(BienResponse bien) {
        this.bien = bien;
    }

    // Clase interna para representar la parte "usuario" de la respuesta JSON
    public static class UsuarioResponse {
        private long usu_cod;
        private PersonaResponse persona;
        private List<RolResponse> roles;
        private String usuario;
        private String contrasenia;
        private boolean usu_estado;

        // Getters y Setters
    }

    // Clase interna para representar la parte "persona" de la respuesta JSON
    public static class PersonaResponse {
        private long perCod;
        private String perCedula;
        private String perPrimerNom;
        private String perSegundoNom;
        private String perApellidoPater;
        private String perApellidoMater;
        private String perTelefono;
        private String perGenero;
        private String perEmail;
        private String perFechaNac;

        // Getters y Setters
    }

    // Clase interna para representar la parte "roles" de la respuesta JSON
    public static class RolResponse {
        private int rol_cod;
        private String rol_nombre;
        private boolean rol_estado;

        // Getters y Setters
    }

    // Clase interna para representar la parte "bien" de la respuesta JSON
    public static class BienResponse {
        private long bien_cod;
        private String bien_codigoG;
        private String bien_modelo;
        private String bien_marca;
        private String bien_estado;
        private String bien_detalles;
        private String bien_descripcion;
        private String bien_serie;
        private int bien_precio;
        private boolean bien_estadoA;
        private Object bien_estado_asignado;
        private UbicacionResponse ubicacion;
        private PropietarioResponse propietario;
        private CategoriaResponse categoria;
        private UsuarioResponse usuario;

        // Getters y Setters
    }

    // Clase interna para representar la parte "ubicacion" de la respuesta JSON
    public static class UbicacionResponse {
        private int ubi_cod;
        private String ubi_nombre;
        private String ubi_departamento;
        private boolean ubi_estado;

        // Getters y Setters
    }

    // Clase interna para representar la parte "propietario" de la respuesta JSON
    public static class PropietarioResponse {
        private int pro_cod;
        private String pro_nombre;
        private String pro_direccion;
        private String pro_telefono;
        private boolean pro_estado;

        // Getters y Setters
    }

    // Clase interna para representar la parte "categoria" de la respuesta JSON
    public static class CategoriaResponse {
        private int cat_cod;
        private String cat_nombre;
        private String cat_descripcion;
        private boolean cat_estado;

        // Getters y Setters
    }
}
