package com.example.fidabi_m4a_projecto_final.request;

import java.io.Serializable;

public class RecentActRequest implements Serializable {
    private Long usu_cod;

    public Long getUsu_cod() {
        return usu_cod;
    }

    public void setUsu_cod(Long usu_cod) {
        this.usu_cod= usu_cod;
    }
}
