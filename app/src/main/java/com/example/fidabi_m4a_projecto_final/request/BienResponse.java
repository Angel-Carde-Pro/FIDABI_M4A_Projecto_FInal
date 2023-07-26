package com.example.fidabi_m4a_projecto_final.request;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BienResponse {

    @SerializedName("bien_cod")
    private int bienCod;

    @SerializedName("bien_codigoG")
    private String bienCodigoG;

    @SerializedName("bien_modelo")
    private String bienModelo;

    @SerializedName("bien_marca")
    private String bienMarca;

    @SerializedName("bien_estado")
    private String bienEstado;

    @SerializedName("bien_detalles")
    private String bienDetalles;

    @SerializedName("bien_descripcion")
    private String bienDescripcion;

    @SerializedName("bien_serie")
    private String bienSerie;

    @SerializedName("bien_precio")
    private double bienPrecio;

    @SerializedName("bien_estadoA")
    private boolean bienEstadoA;

    @SerializedName("bien_estado_asignado")
    private String bienEstadoAsignado;

    @SerializedName("bien_descripcion_lugar")
    private String bienDescripcionLugar;

    @SerializedName("ubicacion")
    private Ubicacion ubicacion;

    @SerializedName("propietario")
    private Propietario propietario;

    @SerializedName("categoria")
    private Categoria categoria;

    @SerializedName("usuario")
    private Usuario usuario;

    // Constructor, getters, and setters
    // ...

    public class Ubicacion {
        @SerializedName("ubi_cod")
        private int ubiCod;

        @SerializedName("ubi_nombre")
        private String ubiNombre;

        @SerializedName("departamento")
        private String departamento;

        @SerializedName("ubi_estado")
        private boolean ubiEstado;

        // Constructor, getters, and setters
        // ...
    }

    public class Propietario {
        @SerializedName("pro_cod")
        private int proCod;

        @SerializedName("pro_nombre")
        private String proNombre;

        @SerializedName("pro_direccion")
        private String proDireccion;

        @SerializedName("pro_telefono")
        private String proTelefono;

        @SerializedName("pro_estado")
        private boolean proEstado;

        // Constructor, getters, and setters
        // ...
    }

    public class Categoria {
        @SerializedName("cat_cod")
        private int catCod;

        @SerializedName("cat_nombre")
        private String catNombre;

        @SerializedName("cat_descripcion")
        private String catDescripcion;

        @SerializedName("cat_estado")
        private boolean catEstado;

        // Constructor, getters, and setters
        // ...
    }

    public class Usuario {
        @SerializedName("usu_cod")
        private int usuCod;

        @SerializedName("persona")
        private Persona persona;

        @SerializedName("roles")
        private List<Rol> roles;

        @SerializedName("usuario")
        private String usuario;

        @SerializedName("contrasenia")
        private String contrasenia;

        @SerializedName("usu_estado")
        private boolean usuEstado;

        // Constructor, getters, and setters
        // ...

        public class Persona {
            @SerializedName("perCod")
            private int perCod;

            @SerializedName("perCedula")
            private String perCedula;

            @SerializedName("perPrimerNom")
            private String perPrimerNom;

            @SerializedName("perSegundoNom")
            private String perSegundoNom;

            @SerializedName("perApellidoPater")
            private String perApellidoPater;

            @SerializedName("perApellidoMater")
            private String perApellidoMater;

            @SerializedName("perTelefono")
            private String perTelefono;

            @SerializedName("perGenero")
            private String perGenero;

            @SerializedName("perEmail")
            private String perEmail;

            @SerializedName("perFechaNac")
            private String perFechaNac;

            // Constructor, getters, and setters
            // ...
        }

        public class Rol {
            @SerializedName("rol_cod")
            private int rolCod;

            @SerializedName("rol_nombre")
            private String rolNombre;

            @SerializedName("rol_estado")
            private boolean rolEstado;

            // Constructor, getters, and setters
            // ...
        }
    }
}
