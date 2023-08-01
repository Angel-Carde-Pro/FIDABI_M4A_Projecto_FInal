package com.example.fidabi_m4a_projecto_final.request;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BienResponse implements Serializable {

    @SerializedName("bien_cod")
    private Long bienCod;

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


    public Long getBienCod() {
        return bienCod;
    }

    public void setBienCod(Long bienCod) {
        this.bienCod = bienCod;
    }

    public String getBienCodigoG() {
        return bienCodigoG;
    }

    public void setBienCodigoG(String bienCodigoG) {
        this.bienCodigoG = bienCodigoG;
    }

    public String getBienModelo() {
        return bienModelo;
    }

    public void setBienModelo(String bienModelo) {
        this.bienModelo = bienModelo;
    }

    public String getBienMarca() {
        return bienMarca;
    }

    public void setBienMarca(String bienMarca) {
        this.bienMarca = bienMarca;
    }

    public String getBienEstado() {
        return bienEstado;
    }

    public void setBienEstado(String bienEstado) {
        this.bienEstado = bienEstado;
    }

    public String getBienDetalles() {
        return bienDetalles;
    }

    public void setBienDetalles(String bienDetalles) {
        this.bienDetalles = bienDetalles;
    }

    public String getBienDescripcion() {
        return bienDescripcion;
    }

    public void setBienDescripcion(String bienDescripcion) {
        this.bienDescripcion = bienDescripcion;
    }

    public String getBienSerie() {
        return bienSerie;
    }

    public void setBienSerie(String bienSerie) {
        this.bienSerie = bienSerie;
    }

    public double getBienPrecio() {
        return bienPrecio;
    }

    public void setBienPrecio(double bienPrecio) {
        this.bienPrecio = bienPrecio;
    }

    public boolean isBienEstadoA() {
        return bienEstadoA;
    }

    public void setBienEstadoA(boolean bienEstadoA) {
        this.bienEstadoA = bienEstadoA;
    }

    public String getBienEstadoAsignado() {
        return bienEstadoAsignado;
    }

    public void setBienEstadoAsignado(String bienEstadoAsignado) {
        this.bienEstadoAsignado = bienEstadoAsignado;
    }

    public String getBienDescripcionLugar() {
        return bienDescripcionLugar;
    }

    public void setBienDescripcionLugar(String bienDescripcionLugar) {
        this.bienDescripcionLugar = bienDescripcionLugar;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public class Ubicacion implements Serializable {
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

        public int getUbiCod() {
            return ubiCod;
        }

        public void setUbiCod(int ubiCod) {
            this.ubiCod = ubiCod;
        }

        public String getUbiNombre() {
            return ubiNombre;
        }

        public void setUbiNombre(String ubiNombre) {
            this.ubiNombre = ubiNombre;
        }

        public String getDepartamento() {
            return departamento;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

        public boolean isUbiEstado() {
            return ubiEstado;
        }

        public void setUbiEstado(boolean ubiEstado) {
            this.ubiEstado = ubiEstado;
        }
    }

    public class Propietario implements Serializable{
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

    public class Categoria implements Serializable {
        @SerializedName("cat_cod")
        private int catCod;

        @SerializedName("cat_nombre")
        private String catNombre;

        @SerializedName("cat_descripcion")
        private String catDescripcion;

        @SerializedName("cat_estado")
        private boolean catEstado;

        public int getCatCod() {
            return catCod;
        }

        public void setCatCod(int catCod) {
            this.catCod = catCod;
        }

        public String getCatNombre() {
            return catNombre;
        }

        public void setCatNombre(String catNombre) {
            this.catNombre = catNombre;
        }

        public String getCatDescripcion() {
            return catDescripcion;
        }

        public void setCatDescripcion(String catDescripcion) {
            this.catDescripcion = catDescripcion;
        }

        public boolean isCatEstado() {
            return catEstado;
        }

        public void setCatEstado(boolean catEstado) {
            this.catEstado = catEstado;
        }
    }

    public class Usuario implements Serializable{
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

        public int getUsuCod() {
            return usuCod;
        }

        public void setUsuCod(int usuCod) {
            this.usuCod = usuCod;
        }

        public Persona getPersona() {
            return persona;
        }

        public void setPersona(Persona persona) {
            this.persona = persona;
        }

        public List<Rol> getRoles() {
            return roles;
        }

        public void setRoles(List<Rol> roles) {
            this.roles = roles;
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

        public boolean isUsuEstado() {
            return usuEstado;
        }

        public void setUsuEstado(boolean usuEstado) {
            this.usuEstado = usuEstado;
        }

        public class Persona implements Serializable {
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

            public int getPerCod() {
                return perCod;
            }

            public void setPerCod(int perCod) {
                this.perCod = perCod;
            }

            public String getPerCedula() {
                return perCedula;
            }

            public void setPerCedula(String perCedula) {
                this.perCedula = perCedula;
            }

            public String getPerPrimerNom() {
                return perPrimerNom;
            }

            public void setPerPrimerNom(String perPrimerNom) {
                this.perPrimerNom = perPrimerNom;
            }

            public String getPerSegundoNom() {
                return perSegundoNom;
            }

            public void setPerSegundoNom(String perSegundoNom) {
                this.perSegundoNom = perSegundoNom;
            }

            public String getPerApellidoPater() {
                return perApellidoPater;
            }

            public void setPerApellidoPater(String perApellidoPater) {
                this.perApellidoPater = perApellidoPater;
            }

            public String getPerApellidoMater() {
                return perApellidoMater;
            }

            public void setPerApellidoMater(String perApellidoMater) {
                this.perApellidoMater = perApellidoMater;
            }

            public String getPerTelefono() {
                return perTelefono;
            }

            public void setPerTelefono(String perTelefono) {
                this.perTelefono = perTelefono;
            }

            public String getPerGenero() {
                return perGenero;
            }

            public void setPerGenero(String perGenero) {
                this.perGenero = perGenero;
            }

            public String getPerEmail() {
                return perEmail;
            }

            public void setPerEmail(String perEmail) {
                this.perEmail = perEmail;
            }

            public String getPerFechaNac() {
                return perFechaNac;
            }

            public void setPerFechaNac(String perFechaNac) {
                this.perFechaNac = perFechaNac;
            }
        }

        public class Rol implements Serializable {
            @SerializedName("rol_cod")
            private int rolCod;

            @SerializedName("rol_nombre")
            private String rolNombre;

            @SerializedName("rol_estado")
            private boolean rolEstado;

            public int getRolCod() {
                return rolCod;
            }

            public void setRolCod(int rolCod) {
                this.rolCod = rolCod;
            }

            public String getRolNombre() {
                return rolNombre;
            }

            public void setRolNombre(String rolNombre) {
                this.rolNombre = rolNombre;
            }

            public boolean isRolEstado() {
                return rolEstado;
            }

            public void setRolEstado(boolean rolEstado) {
                this.rolEstado = rolEstado;
            }
// Constructor, getters, and setters
            // ...
        }
    }
}
