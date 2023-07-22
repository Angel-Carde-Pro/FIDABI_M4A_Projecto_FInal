package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;
import java.util.List;

public class LoginResponse implements Serializable {
    private Long usu_cod;
    private Persona persona;
    private List<Rol> roles;
    private String usuario;
    private String contrasenia;
    private boolean usu_estado;

    public Long getUsuCod() {
        return usu_cod;
    }

    public void setUsuCod(Long usu_cod) {
        this.usu_cod = usu_cod;
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
        return usu_estado;
    }

    public void setUsuEstado(boolean usu_estado) {
        this.usu_estado = usu_estado;
    }

    public static class Persona {
        private int perCod;
        private String perCedula;
        private String perPrimerNom;
        private String perSegundoNom;
        private String perApellidoPater;
        private String perApellidoMater;
        private String perTelefono;
        private String perGenero;
        private String perEmail;
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

    public static class Rol {
        private int rol_cod;
        private String rol_nombre;
        private boolean rol_estado;

        public int getRolCod() {
            return rol_cod;
        }

        public void setRolCod(int rol_cod) {
            this.rol_cod = rol_cod;
        }

        public String getRolNombre() {
            return rol_nombre;
        }

        public void setRolNombre(String rol_nombre) {
            this.rol_nombre = rol_nombre;
        }

        public boolean isRolEstado() {
            return rol_estado;
        }

        public void setRolEstado(boolean rol_estado) {
            this.rol_estado = rol_estado;
        }
    }
}

