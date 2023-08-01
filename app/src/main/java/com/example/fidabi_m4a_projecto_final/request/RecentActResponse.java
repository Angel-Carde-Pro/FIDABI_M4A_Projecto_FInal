package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;
import java.util.List;

public class RecentActResponse implements Serializable {
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

        public long getUsu_cod() {
            return usu_cod;
        }

        public void setUsu_cod(long usu_cod) {
            this.usu_cod = usu_cod;
        }

        public PersonaResponse getPersona() {
            return persona;
        }

        public void setPersona(PersonaResponse persona) {
            this.persona = persona;
        }

        public List<RolResponse> getRoles() {
            return roles;
        }

        public void setRoles(List<RolResponse> roles) {
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

        public boolean isUsu_estado() {
            return usu_estado;
        }

        public void setUsu_estado(boolean usu_estado) {
            this.usu_estado = usu_estado;
        }
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

        public long getPerCod() {
            return perCod;
        }

        public void setPerCod(long perCod) {
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


        public long getBien_cod() {
            return bien_cod;
        }

        public void setBien_cod(long bien_cod) {
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

        public int getBien_precio() {
            return bien_precio;
        }

        public void setBien_precio(int bien_precio) {
            this.bien_precio = bien_precio;
        }

        public boolean isBien_estadoA() {
            return bien_estadoA;
        }

        public void setBien_estadoA(boolean bien_estadoA) {
            this.bien_estadoA = bien_estadoA;
        }

        public Object getBien_estado_asignado() {
            return bien_estado_asignado;
        }

        public void setBien_estado_asignado(Object bien_estado_asignado) {
            this.bien_estado_asignado = bien_estado_asignado;
        }

        public UbicacionResponse getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(UbicacionResponse ubicacion) {
            this.ubicacion = ubicacion;
        }

        public PropietarioResponse getPropietario() {
            return propietario;
        }

        public void setPropietario(PropietarioResponse propietario) {
            this.propietario = propietario;
        }

        public CategoriaResponse getCategoria() {
            return categoria;
        }

        public void setCategoria(CategoriaResponse categoria) {
            this.categoria = categoria;
        }

        public UsuarioResponse getUsuario() {
            return usuario;
        }

        public void setUsuario(UsuarioResponse usuario) {
            this.usuario = usuario;
        }
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
