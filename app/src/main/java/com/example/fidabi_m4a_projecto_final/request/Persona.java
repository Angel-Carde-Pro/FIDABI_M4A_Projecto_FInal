package com.example.fidabi_m4a_projecto_final.request;
import java.io.Serializable;
import java.util.Date;


public class Persona implements Serializable {
    private Long perCod;
    private String perCedula;
    private String perPrimerNom;
    private String perSegundoNom;
    private String perApellidoPater;
    private String perApellidoMater;
    private String perTelefono;

    private String perGenero;

    private String perEmail;


    private Date perFechaNac;

    public Long getPerCod() {
        return perCod;
    }

    public void setPerCod(Long perCod) {
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

    public Date getPerFechaNac() {
        return perFechaNac;
    }

    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }
}
